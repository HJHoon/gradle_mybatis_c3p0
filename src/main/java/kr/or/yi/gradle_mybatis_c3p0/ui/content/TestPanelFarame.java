package kr.or.yi.gradle_mybatis_c3p0.ui.content;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dao.EmployeeDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.EmployeeDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class TestPanelFarame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private PanelEmployee panel;
	private JButton btnNSet;
	private JButton btnGet;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestPanelFarame frame = new TestPanelFarame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestPanelFarame() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		DepartmentDao deptDao = new DepartmentDaoImpl();
		TitleDao titleDao = new TitleDaoImpl();
		
		panel = new PanelEmployee();
		panel.setDeptList(deptDao.selectDepartmentByAll());//부서목록 불러오기
		panel.setTitleList(titleDao.selectTitleByAll());
		
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnNSet = new JButton("설정");
		btnNSet.addActionListener(this);
		panel_1.add(btnNSet);
		
		btnGet = new JButton("불러오기");
		btnGet.addActionListener(this);
		panel_1.add(btnGet);
		
		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		panel_1.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnGet) {
			actionPerformedBtnGet(e);
		}
		if (e.getSource() == btnNSet) {
			actionPerformedBtnNSet(e);
		}
	}
	protected void actionPerformedBtnNSet(ActionEvent e) {
		Employee emp = new Employee(1234, "현종훈", 2000000, new Department(1),
						false, new Date(), new Title(1));
		
		panel.setItem(emp);
	}
	protected void actionPerformedBtnGet(ActionEvent e) {
		Employee emp = panel.getItem();
		JOptionPane.showMessageDialog(null, emp);
	}
	protected void actionPerformedBtnClear(ActionEvent e) {
		EmployeeDao empDao = new EmployeeDaoImpl();
		panel.clearComponent(empDao.selectEmployeeByAll().size()+1);
	}
}

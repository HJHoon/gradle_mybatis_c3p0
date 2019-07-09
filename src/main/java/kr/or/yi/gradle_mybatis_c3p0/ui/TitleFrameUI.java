package kr.or.yi.gradle_mybatis_c3p0.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.PanelTitle;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.TitleList;




@SuppressWarnings("serial")
public class TitleFrameUI extends JFrame {
	
	public TitleFrameUI() {
		initComponents();
	}

	private void initComponents() {
		setTitle("流氓包府");
		setBounds(200, 100, 450, 450);
		JPanel pMain = new JPanel();
		getContentPane().add(pMain, BorderLayout.CENTER);
		pMain.setLayout(new BorderLayout(0, 0));

		PanelTitle pContent = new PanelTitle();
		pMain.add(pContent, BorderLayout.CENTER);

		JPanel pBtns = new JPanel();
		pMain.add(pBtns, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("眠啊");
		pBtns.add(btnAdd);

		JButton btnCancel = new JButton("秒家");
		pBtns.add(btnCancel);

		TitleList pList = new TitleList("流氓 格废");
		
		pList.setItemList(new ArrayList<Title>());
		pList.reloadData();
		
		getContentPane().add(pList, BorderLayout.SOUTH);
	}

}
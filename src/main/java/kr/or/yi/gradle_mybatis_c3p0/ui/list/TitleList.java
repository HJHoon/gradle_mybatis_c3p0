package kr.or.yi.gradle_mybatis_c3p0.ui.list;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.gradle_mybatis_c3p0.dto.Title;



@SuppressWarnings("serial")
public class TitleList extends JPanel {
	private JTable table;
	protected List<Title> itemList;
	private JScrollPane scrollPane;
	
	public TitleList(String title) {
		initComponents(title);
	}

	private void initComponents(String title) {
		setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 200));
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	public void setPopupMenu(JPopupMenu popupMenu) {
		table.setComponentPopupMenu(popupMenu);
		scrollPane.setComponentPopupMenu(popupMenu);
	}
	
	public void setItemList(List<Title> itemList) {
		this.itemList = itemList;
	}
	
	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
		tableAlignmentAndWidth();
	}
	
	private Object[][] getRows() {
		Object[][] rows = new Object[itemList.size()][];
		for (int i = 0; i < itemList.size(); i++) {
			rows[i] = toArray(i);
		}
		return rows;
	}
	
	protected void tableAlignmentAndWidth() {
		// ��å��ȣ, ��å���� ��� ����
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
		// ��å��ȣ, ��å���� ���� (100, 200)���� �����ϸ� ����
		tableSetWidth(100, 200);
	}

	protected Object[] toArray(int idx) {
		Title title = itemList.get(idx);
		return title.toArray();
	}

	
	protected String[] getColumnNames() {
		return new String[] { "��å��ȣ", "��å��"};
	}

	// ���̺� �� ������ ����
	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	// ���̺� ���� �� ����
	protected void tableSetWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

}
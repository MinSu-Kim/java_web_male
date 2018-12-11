package kr.or.yi.java_web_male.ui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.yi.java_web_male.dto.Post;

public class PostListPanel extends JPanel {
	private JTable table;
	private List<Post> list;
	
	public void setLists(List<Post> list) {
		this.list = list;
	}
	/**
	 * Create the panel.
	 */
	public PostListPanel() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
	
	public void loadData() {
		table.setModel(new DefaultTableModel(
				getdatas(),
				getColumn()
			));
	
	}

	private Object[] getColumn() {
		return new String[]{"우편번호","시도","시군구","읍면","도로명","건물번호1","건물번호2"};
	}
	

	private Object[][] getdatas() {
		Object[][] datas = new Object[list.size()][];
		for(int i = 0; i<list.size(); i++) {
			datas[i]=getRow(list.get(i));
		}
		return datas;
	}

	private Object[] getRow(Post post) {
		return new Object[]{post.getZipcode(),post.getSido(),post.getSigungu(),post.getEupmyeon(),post.getDoro(),post.getBuilding1(),post.getBuilding2()};
	}

	public Post selectedItem() {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex == -1) {
			JOptionPane.showMessageDialog(null, "해당 항목을 선택하세요");
			return null;
		}
		String zipcode = (String) table.getValueAt(selectedIndex, 0);
		String sido = (String) table.getValueAt(selectedIndex, 1);
		String sigungu = (String) table.getValueAt(selectedIndex, 2);
		String eupmyeon = (String) table.getValueAt(selectedIndex, 3);
		String doro = (String) table.getValueAt(selectedIndex, 4);
		int building1 = (int) table.getValueAt(selectedIndex, 5);
		int building2 = (int) table.getValueAt(selectedIndex, 6);
		return new Post();
	}

}

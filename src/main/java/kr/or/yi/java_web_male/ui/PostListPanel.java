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
		return new String[]{"우편번호","주소"};
	}
	

	private Object[][] getdatas() {
		Object[][] datas = new Object[list.size()][];
		for(int i = 0; i<list.size(); i++) {
			datas[i]=getRow(list.get(i));
		}
		return datas;
	}

	private Object[] getRow(Post post) {
		return new Object[]{post.getZipcode(),post.toString()};
	}

	public Post selectedItem() {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex == -1) {
			JOptionPane.showMessageDialog(null, "해당 항목을 선택하세요");
			return null;
		}
		return list.get(selectedIndex);
	}
	
	
	public JTable getTable() {
		return table;
	}
	
	
}

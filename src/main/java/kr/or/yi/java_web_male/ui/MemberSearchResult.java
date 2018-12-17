package kr.or.yi.java_web_male.ui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.Member;

public class MemberSearchResult extends JPanel {
	private JTable table;
	private List<Member> list;
	public void setLists(List<Member> list) {
		this.list = list;
	}

	/**
	 * Create the panel.
	 */
	public MemberSearchResult() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
	public void loadData() {
		table.setModel(new DefaultTableModel(
				getdatas(),
				getCoulum()
				));
	}
	private Object[] getCoulum() {
		return new String[] {"회원번호","이름","생년월일","전화번호"};
	}

	private Object[][] getdatas() {
		Object[][] datas = new Object[list.size()][];
		for(int i=0; i<list.size(); i++) {
			datas[i]=getRow(list.get(i));
		}
		return datas;
	}

	private Object[] getRow(Member member) {
		return new Object[] {member.getMemberNo(),
							 member.getKorName(),
							 member.getJumin(),
							 member.getPhone()};
	}
	public Member selectedItem() {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex == -1) {
			JOptionPane.showMessageDialog(null, "해당 항목을 선택하세요");
			return null;
		}
		return list.get(selectedIndex);
	}
	public void setPopupMenu(JPopupMenu popupMenu) {
		table.setComponentPopupMenu(popupMenu);
	}
	public Member getSelectedMember() {
		int selectedIndex = table.getSelectedRow();
		String memberNo = (String) table.getValueAt(selectedIndex, 0);
		Member mem = new Member();
		mem.setMemberNo(memberNo);
		return mem;
	}
	
	public JTable getTable() {
		return table;

	}


}

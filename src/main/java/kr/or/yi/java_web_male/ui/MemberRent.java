package kr.or.yi.java_web_male.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.yi.java_web_male.dto.Member;
import java.awt.Dimension;

public class MemberRent extends JPanel {
	private JTable table;
	private List<Member> list;

	public void setLists(List<Member> list) {
		this.list = list;
	}
	/**
	 * Create the panel.
	 */
	public MemberRent() {
		setPreferredSize(new Dimension(600, 100));
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
		return new String[] {"회원번호","이름","제목","대여날짜","반납일","반납예정일"};
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
				 member.getBook().getTitle(),
				 member.getBookRentallInfo().getRentalDate(),
				 member.getBookRentallInfo().getReturnDate(),
				 member.getBookRentallInfo().getReturnSchedule()};
	}
}

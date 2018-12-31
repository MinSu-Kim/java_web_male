package kr.or.yi.java_web_male.ui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.border.TitledBorder;


import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.Publisher;
import kr.or.yi.java_web_male.service.LibraryUIService;
import kr.or.yi.java_web_male.service.MemberUIService;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


public class BookDetailTablePanel extends JPanel {
	
	private MemberUIService serviceMember;
	private JTable table;
	private List<BookRentalInfo> lists;
	private NonEditableModel model;
	private LibraryUIService service;
	private Member member;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public BookDetailTablePanel() {
		service = new LibraryUIService();
		serviceMember = new MemberUIService();
		setBorder(new TitledBorder(null, "\uB3C4\uC11C \uB300\uC5EC \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNewLabel = new JLabel("총대여 횟수 :");
		add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

	}
	public void loadDatas() {
		
		model = new NonEditableModel(getDatas(), getColumnNames());
		table.setModel(model);		
		/*JOptionPane.showMessageDialog(null,table);*/
	}

	public Boolean setLists(List<BookRentalInfo> lists) {
		this.lists = lists;
		lblNewLabel.setText("총대여 횟수 : " + lists.size());
		if(lists.size()==0) {			
			return false;
		}else {
			return true;
		}
		
	}


	private Object[] getColumnNames() {
		return new String[] {"책번호", "대여 번호","대여일", "반납일", "대여한 회원 이름","대여한 회원번호"};
	}

	private Object[][] getDatas() {
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = getBookRentalInfoArray(lists.get(i));
		}
		return datas;
	}

	private Object[] getBookRentalInfoArray(BookRentalInfo bookRentalInfo) {
		String bookCode = bookRentalInfo.getBookCode().getBookCode();
		int rentalNo = bookRentalInfo.getRentalNo();
		Date rentalDate = bookRentalInfo.getRentalDate();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		Date returnDate =  bookRentalInfo.getReturnDate();
		member = new Member();
		member = serviceMember.selectMemberByNo(bookRentalInfo.getMemberNo());	
		String rentalDateSimple ="";
		String returnDateSimple = "";
		try {
			rentalDateSimple = date.format(rentalDate);
		} catch (Exception e) {
			rentalDateSimple = "기록없음";
		}
		try {
			returnDateSimple = date.format(returnDate);
		} catch (Exception e) {
			returnDateSimple = "기록없음";
		}
		
		
		
		return new Object[] {bookCode,rentalNo,rentalDateSimple,returnDateSimple,member.getKorName(),member};
	}

}

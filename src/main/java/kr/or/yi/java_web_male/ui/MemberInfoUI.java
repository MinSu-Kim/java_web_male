package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.synth.SynthSeparatorUI;

import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.Overdue;
import kr.or.yi.java_web_male.service.MemberInfoService;
import kr.or.yi.java_web_male.service.MemberUIService;
import kr.or.yi.java_web_male.ui.LoginUI;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class MemberInfoUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfMemberNo;
	private JTextField tfPhone;
	private JTextField tfJumin;
	private JTextField tfKorName;
	private JTextField tfAddress;
	private JTextField tfEngName;
	private JTextField tfEmail;
	private JTable table;
	private JButton btnMod;
	private JButton btnDetail;
	private JButton btnSearch;
	private JButton btnLogout;
	private JButton btnBest10;
	private LoginUI loginUI;
	private MemberUpdateUI memberUpdateUI;
	private MemberDetailUI memberDetailUI;
	private BookSearchUI bookSearchUI;
	private List<BookRentalInfo> lists;
	private String imgPath;
	private MemberInfoService service;
	private JTextField tfStopDate;
	private MemberUIService memberUIService;
	private Overdue overdue;
	private JLabel lblImg;

	public MemberInfoUI() {
		setResizable(false);
		imgPath = System.getProperty("user.dir") + "\\images\\";
		loginUI = new LoginUI();
		service = new MemberInfoService();
		memberUIService = new MemberUIService();
		initComponent();
	}

	private void initComponent() {
		String admin = "";
		if (LoginUI.getLogin().isAdmin() == true) {
			admin = "[관리자] ";
		} else {
			admin = "[사용자] ";
		}

		setTitle(admin + LoginUI.getLogin().getKorName() + "님 환영합니다.");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 580, 202);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 360, 202);
		panel_3.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblMemberNo = new JLabel("회원 번호");
		lblMemberNo.setBounds(19, 1, 137, 20);
		panel_2.add(lblMemberNo);

		tfMemberNo = new JTextField();
		tfMemberNo.setBounds(102, 1, 232, 20);
		panel_2.add(tfMemberNo);
		tfMemberNo.setColumns(10);

		JPanel pKorName = new JPanel();
		pKorName.setBounds(19, 31, 157, 20);
		panel_2.add(pKorName);
		pKorName.setLayout(null);

		JLabel lblKorName = new JLabel("한글명");
		lblKorName.setBounds(0, 0, 68, 20);
		pKorName.add(lblKorName);

		tfKorName = new JTextField();
		tfKorName.setBounds(80, 0, 77, 20);
		pKorName.add(tfKorName);
		tfKorName.setColumns(10);

		JPanel pEngName = new JPanel();
		pEngName.setBounds(178, 31, 156, 20);
		panel_2.add(pEngName);
		pEngName.setLayout(null);

		JLabel lblEngName = new JLabel("영어명");
		lblEngName.setBounds(12, 0, 56, 20);
		pEngName.add(lblEngName);

		tfEngName = new JTextField();
		tfEngName.setBounds(80, 0, 76, 20);
		pEngName.add(tfEngName);
		tfEngName.setText((String) null);
		tfEngName.setEditable(false);
		tfEngName.setColumns(10);

		JLabel label = new JLabel("전화번호");
		label.setBounds(19, 61, 78, 20);
		panel_2.add(label);
		tfPhone = new JTextField();
		tfPhone.setBounds(102, 61, 232, 20);
		panel_2.add(tfPhone);
		tfPhone.setColumns(10);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(19, 91, 78, 20);
		panel_2.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setBounds(102, 91, 232, 20);
		panel_2.add(tfEmail);
		tfEmail.setColumns(10);

		JLabel lblJumin = new JLabel("주민등록번호");
		lblJumin.setBounds(19, 121, 78, 20);
		panel_2.add(lblJumin);

		tfJumin = new JTextField();
		tfJumin.setBounds(102, 121, 232, 20);
		panel_2.add(tfJumin);
		tfJumin.setColumns(10);

		JLabel lblAddress = new JLabel("주소");
		lblAddress.setBounds(19, 151, 78, 20);
		panel_2.add(lblAddress);

		tfAddress = new JTextField();
		tfAddress.setBounds(102, 151, 232, 20);
		panel_2.add(tfAddress);
		tfAddress.setColumns(10);

		JLabel lblStopDate = new JLabel("정지일");
		lblStopDate.setBounds(19, 181, 78, 20);
		panel_2.add(lblStopDate);

		tfStopDate = new JTextField();
		tfStopDate.setBounds(102, 181, 232, 20);
		tfStopDate.setEnabled(false);
		panel_2.add(tfStopDate);
		tfStopDate.setEditable(false);
		tfStopDate.setColumns(10);

		JPanel pMemberPhoto = new JPanel();
		pMemberPhoto.setBounds(372, 0, 208, 202);
		panel_3.add(pMemberPhoto);
		pMemberPhoto.setLayout(null);

		JPanel pPhoto = new JPanel();
		pPhoto.setBounds(0, 0, 285, 202);
		pMemberPhoto.add(pPhoto);
		pPhoto.setLayout(null);

		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBounds(0, 10, 208, 192);
		pPhoto.add(lblImg);

		JPanel pRentList = new JPanel();
		pRentList.setBounds(5, 207, 580, 113);
		contentPane.add(pRentList);
		pRentList.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 10, 580, 103);
		pRentList.add(scrollPane);

		table = new JTable();
		table.setEnabled(false);
		loadDatas();
		scrollPane.setViewportView(table);
		pRentList.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { scrollPane, table }));

		JPanel pButton = new JPanel();
		pButton.setBounds(5, 330, 580, 23);
		contentPane.add(pButton);
		pButton.setLayout(new GridLayout(0, 5, 10, 10));

		btnMod = new JButton("정보수정");
		btnMod.addActionListener(this);
		pButton.add(btnMod);

		btnSearch = new JButton("도서 검색");
		btnSearch.addActionListener(this);

		btnDetail = new JButton("대여정보");
		btnDetail.addActionListener(this);
		pButton.add(btnDetail);
		pButton.add(btnSearch);

		btnBest10 = new JButton("Best");
		btnBest10.addActionListener(this);
		pButton.add(btnBest10);

		btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(this);
		pButton.add(btnLogout);

		getMemberInfo(LoginUI.getLogin());
		getMemberInfo2(overdue);

	}

	private void loadDatas() {
		table.setModel(new DefaultTableModel(getDatas(), getColumnNames()));
	}

	private Object[][] getDatas() {
		Member member = LoginUI.getLogin();
		lists = service.selectBookByMemberNoReturnDateNull(member);
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = getMemberRentalInfo(lists.get(i));
		}
		return datas;
	}

	private Object[] getMemberRentalInfo(BookRentalInfo bookRentalInfo) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		String bookCode = bookRentalInfo.getBookCode().getBookCode();
		String title = bookRentalInfo.getBookCode().getTitle();
		String publisher = bookRentalInfo.getPublisher().getPubName();
		String author = bookRentalInfo.getBookCode().getAuthor();
		Date rentalDate = bookRentalInfo.getRentalDate();
		Date returnSchedule = bookRentalInfo.getReturnSchedule();
		return new Object[] { bookCode, title, publisher, author, date.format(rentalDate),
				date.format(returnSchedule) };
	}

	private String[] getColumnNames() {
		return new String[] { "도서코드", "도서명", "출판사", "저자", "대여일자", "반납기한" };
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBest10) {
			do_btnBest10_actionPerformed(e);
		}
		if (e.getSource() == btnLogout) {
			do_btnLogout_actionPerformed(e);
		}
		if (e.getSource() == btnDetail) {
			do_btnDetail_actionPerformed(e);
		}
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
		if (e.getSource() == btnMod) {
			do_btnMod_actionPerformed(e);
		}
	}

	// 회원정보수정 이동
	protected void do_btnMod_actionPerformed(ActionEvent arg0) {
		if (memberUpdateUI == null) {
			memberUpdateUI = new MemberUpdateUI(LoginUI.getLogin());
		}
		memberUpdateUI.setVisible(true);
	}

	// 도서검색 이동
	protected void do_btnSearch_actionPerformed(ActionEvent arg0) {
		if (bookSearchUI == null) {
			bookSearchUI = new BookSearchUI();
		}
		bookSearchUI.setVisible(true);
	}

	// 상세정보
	protected void do_btnDetail_actionPerformed(ActionEvent arg0) {
		if (memberDetailUI == null) {
			memberDetailUI = new MemberDetailUI();
		}
		memberDetailUI.setVisible(true);
	}

	// 로그인 객체에서 정보 가져오기
	public void getMemberInfo(Member member) {
		String str = LoginUI.getLogin().getEmail();
		String[] strArr = str.split("@");

		tfMemberNo.setText(member.getMemberNo());
		tfKorName.setText(member.getKorName());
		tfEngName.setText(member.getEngName());
		tfPhone.setText(member.getPhone().substring(0, 3) + "-****-****");
		tfEmail.setText(strArr[0].substring(0, 4) + "****@" + strArr[1]);
		tfJumin.setText(member.getJumin().substring(0, 8) + "******");
		tfAddress.setText("****************************************");
		lblImg.setIcon(new ImageIcon(imgPath + member.getPhoto()));

		tfMemberNo.setEditable(false);
		tfKorName.setEditable(false);
		tfEngName.setEditable(false);
		tfPhone.setEditable(false);
		tfEmail.setEditable(false);
		tfJumin.setEditable(false);
		tfAddress.setEditable(false);
	}

	public void getMemberInfo2(Overdue overdue1) {
		Overdue oMno = new Overdue();
		oMno.setMemberNo(tfMemberNo.getText());
		Overdue overdueAll = memberUIService.selectOverdueByCode(oMno);
		int stopDate = overdueAll.getStopDate();
		String stop = String.valueOf(stopDate);

		tfStopDate.setText(stop);
	}

	protected void do_btnLogout_actionPerformed(ActionEvent e) {
		LoginUI.memberLogOut();
		loginUI.setVisible(true);
	}

	protected void do_btnBest10_actionPerformed(ActionEvent e) {
		BestUI bestUI = new BestUI();
		bestUI.setVisible(true);
		bestUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

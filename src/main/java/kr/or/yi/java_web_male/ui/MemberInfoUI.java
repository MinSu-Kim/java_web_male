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
	private MemberInfoUI memberInfoUI;
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
	private String pathName;
	private String fileName;

	public MemberInfoUI() {
		imgPath = System.getProperty("user.dir") + "\\images\\";
		loginUI = new LoginUI();
		service = new MemberInfoService();
		memberUIService = new MemberUIService();
		initComponent();
	}

	private void initComponent() {
		Member member = new Member();
		setTitle("[사용자] " + LoginUI.getLogin().getKorName() + "님 환영합니다.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 474, 202);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 474, 210);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 474, 83);
		panel_3.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10));

		JPanel pMemberInfo = new JPanel();
		panel_1.add(pMemberInfo);
		pMemberInfo.setLayout(new GridLayout(0, 1, 10, 10));

		JPanel panel_4 = new JPanel();
		pMemberInfo.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblMemberNo = new JLabel("회원 번호");
		panel_4.add(lblMemberNo);

		tfMemberNo = new JTextField();
		panel_4.add(tfMemberNo);
		tfMemberNo.setColumns(10);

		JPanel pKorName = new JPanel();
		pMemberInfo.add(pKorName);
		pKorName.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblKorName = new JLabel("한글명");
		pKorName.add(lblKorName);

		tfKorName = new JTextField();
		pKorName.add(tfKorName);
		tfKorName.setColumns(10);

		JPanel pEngName = new JPanel();
		pMemberInfo.add(pEngName);
		pEngName.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblEngName = new JLabel("영어명");
		pEngName.add(lblEngName);

		tfEngName = new JTextField();
		tfEngName.setText((String) null);
		tfEngName.setEditable(false);
		tfEngName.setColumns(10);
		pEngName.add(tfEngName);

		JPanel pMemberPhoto = new JPanel();
		panel_1.add(pMemberPhoto);
		pMemberPhoto.setLayout(new GridLayout(0, 1, 10, 10));

		JPanel pPhoto = new JPanel();
		pMemberPhoto.add(pPhoto);
		pPhoto.setLayout(null);

		lblImg = new JLabel("이미지");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBounds(12, 0, 208, 83);
		pPhoto.add(lblImg);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 93, 474, 114);
		panel_3.add(panel_2);
		panel_2.setLayout(null);
		tfPhone = new JTextField();
		tfPhone.setBounds(121, 0, 237, 21);
		panel_2.add(tfPhone);
		tfPhone.setColumns(10);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(0, 21, 122, 21);
		panel_2.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setBounds(121, 21, 237, 21);
		panel_2.add(tfEmail);
		tfEmail.setColumns(10);

		JLabel lblJumin = new JLabel("주민등록번호");
		lblJumin.setBounds(0, 42, 122, 21);
		panel_2.add(lblJumin);

		tfJumin = new JTextField();
		tfJumin.setBounds(121, 42, 237, 21);
		panel_2.add(tfJumin);
		tfJumin.setColumns(10);

		JLabel lblAddress = new JLabel("주소");
		lblAddress.setBounds(0, 63, 122, 21);
		panel_2.add(lblAddress);

		tfAddress = new JTextField();
		tfAddress.setBounds(121, 63, 317, 21);
		panel_2.add(tfAddress);
		tfAddress.setColumns(10);

		JLabel lblStopDate = new JLabel("정지일");
		lblStopDate.setBounds(0, 84, 122, 21);
		panel_2.add(lblStopDate);

		tfStopDate = new JTextField();
		tfStopDate.setEnabled(false);
		tfStopDate.setBounds(121, 84, 237, 21);
		panel_2.add(tfStopDate);
		tfStopDate.setEditable(false);
		tfStopDate.setColumns(10);

		JPanel pRentList = new JPanel();
		pRentList.setBounds(5, 207, 474, 319);
		contentPane.add(pRentList);
		pRentList.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 10, 474, 335);
		pRentList.add(scrollPane);

		table = new JTable();
		loadDatas();
		scrollPane.setViewportView(table);
		pRentList.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { scrollPane, table }));

		JPanel pButton = new JPanel();
		pButton.setBounds(5, 526, 474, 23);
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
		lists = service.selectBookRentalMemberInfo(member);
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
		String str = LoginUI.getLogin().getAddress();
		String[] strArr = str.split(",");

		tfMemberNo.setText(member.getMemberNo());
		tfKorName.setText(member.getKorName());
		tfEngName.setText(member.getEngName());
		tfPhone.setText(member.getPhone());
		tfEmail.setText(member.getEmail());
		tfJumin.setText(member.getJumin());
		tfAddress.setText(member.getEngName());
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
//		int stopDate = overdueAll.getStopDate();
//		String stop = String.valueOf(stopDate);

//		tfStopDate.setText(stop);
	}

	protected void do_btnLogout_actionPerformed(ActionEvent e) {
		LoginUI.memberLogOut();
		this.setVisible(false);
		loginUI.setVisible(true);
	}

	protected void do_btnBest10_actionPerformed(ActionEvent e) {
		BestUI bestUI = new BestUI();
		bestUI.setVisible(true);
		bestUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void images() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
		chooser.setFileFilter(filter);
		int ret = chooser.showOpenDialog(null);

		if (ret == JFileChooser.APPROVE_OPTION) {
			pathName = chooser.getSelectedFile().getPath();
			fileName = chooser.getSelectedFile().getName();

			System.out.println(pathName);
			System.out.println(fileName);
		}
	}
}

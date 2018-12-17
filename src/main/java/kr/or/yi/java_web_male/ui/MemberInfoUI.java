package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.ui.LoginUI;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class MemberInfoUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfMemberNo;
	private JTextField tfPhone;
	private JTextField tfJumin;
	private JTextField tfKorName;
	private JTextField tfAddress;

	private BookSearchUI bookSearchUI;
	private MemberModUI memberModUI;
	private MemberRentalList memberRentalList;
	private JButton btnMod;
	private JButton btnSearch;
	private JButton btnDetail;
	private JTextField tfEngName;
	private JTextField tfEmail;
	private String imgPath;

	public MemberInfoUI() {
		imgPath = System.getProperty("user.dir") + "\\images\\";
		initComponent();

		System.out.println("다른 클래스에서 호출" + LoginUI.getLogin());
	}

	private void initComponent() {
		setTitle("내 정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 10, 10));

		JPanel pMemberInfo = new JPanel();
		panel.add(pMemberInfo);
		pMemberInfo.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblMemberNo = new JLabel("회원 번호");
		pMemberInfo.add(lblMemberNo);

		tfMemberNo = new JTextField();
		pMemberInfo.add(tfMemberNo);
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

		JLabel lblPhone = new JLabel("전화번호");
		pMemberInfo.add(lblPhone);

		tfPhone = new JTextField();
		pMemberInfo.add(tfPhone);
		tfPhone.setColumns(10);

		JLabel lblEmail = new JLabel("이메일");
		pMemberInfo.add(lblEmail);

		tfEmail = new JTextField();
		pMemberInfo.add(tfEmail);
		tfEmail.setColumns(10);

		JLabel lblJumin = new JLabel("주민등록번호");
		pMemberInfo.add(lblJumin);

		tfJumin = new JTextField();
		pMemberInfo.add(tfJumin);
		tfJumin.setColumns(10);

		JLabel lblAddress = new JLabel("주소");
		pMemberInfo.add(lblAddress);

		tfAddress = new JTextField();
		pMemberInfo.add(tfAddress);
		tfAddress.setColumns(10);

		JPanel pMemberPhoto = new JPanel();
		panel.add(pMemberPhoto);
		pMemberPhoto.setLayout(new GridLayout(0, 1, 10, 10));

		JPanel pPhoto = new JPanel();
		pMemberPhoto.add(pPhoto);

		JPanel pRentList = new JPanel();
		contentPane.add(pRentList, BorderLayout.CENTER);
		pRentList.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pRentList.add(scrollPane, BorderLayout.CENTER);

		JPanel pButton = new JPanel();
		contentPane.add(pButton, BorderLayout.SOUTH);
		pButton.setLayout(new GridLayout(0, 3, 10, 10));

		btnMod = new JButton("회원정보수정");
		btnMod.addActionListener(this);
		pButton.add(btnMod);

		btnSearch = new JButton("도서 검색");
		btnSearch.addActionListener(this);

		btnDetail = new JButton("대여정보");
		btnDetail.addActionListener(this);
		pButton.add(btnDetail);
		pButton.add(btnSearch);

		getMemberInfo(LoginUI.getLogin());
	}

	public void actionPerformed(ActionEvent e) {
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
		if (memberModUI == null) {
			memberModUI = new MemberModUI();
		}
		memberModUI.setVisible(true);
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
		if (memberRentalList == null) {
			memberRentalList = new MemberRentalList();
		}
		memberRentalList.setVisible(true);
	}

	// 로그인 객체에서 정보 가져오기
	public void getMemberInfo(Member member) {
		tfMemberNo.setText(member.getMemberNo());
		tfKorName.setText(member.getKorName());
		tfEngName.setText(member.getEngName());
		tfPhone.setText(member.getPhone());
		tfEmail.setText(member.getEmail());
		tfJumin.setText(member.getAddress());
		tfAddress.setText(member.getEngName());

		tfMemberNo.setEditable(false);
		tfKorName.setEditable(false);
		tfEngName.setEditable(false);
		tfPhone.setEditable(false);
		tfEmail.setEditable(false);
		tfJumin.setEditable(false);
		tfAddress.setEditable(false);
	}

}

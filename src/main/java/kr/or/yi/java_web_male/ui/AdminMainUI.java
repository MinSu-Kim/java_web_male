package kr.or.yi.java_web_male.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Provider.Service;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.service.MemberUIService;

import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class AdminMainUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnBookInsert;
	private JButton btnBookSearch;
	private JButton btnMemberAdmin;
	private JButton btnRentalAdmin;
	private JButton btnLogout;
	private BookInsertUI bookInsertUI;
	private BookSearchUI bookSearchUI;
	private MemberSearchUI memberSearchUI;
	private MemberSearchDetail memberSearchDetail;
	private MemberUpdateUI memberUpdateUI;
	private InOutUI inOutUI;
	private LoginUI loginUI;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnUpdate;
	private MemberUIService service;
	private JTextField tfMemberNo;
	private JTextField tfpass;
	private JTextField tfKorName;
	private JTextField tfEngName;
	private JTextField tfPhone;
	private JTextField tfEmail;
	private JTextField tfJumin;
	private JTextField tfAddress;
	private JLabel lblImg;
	private static Member loginMember;
	
	public AdminMainUI() {
		loginUI = new LoginUI();
		service = new MemberUIService();
		memberSearchUI = new MemberSearchUI();
		System.out.println("나오는 값음"+LoginUI.getLogin());
		initComponents();
	}
	public static final Member getLogin() {
		return loginMember;
		
	}
	private void initComponents() {

		setTitle("[관리자] " + LoginUI.getLogin().getKorName() + "님 환영합니다.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(5, 5, 424, 69);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 10, 10));

		btnBookInsert = new JButton("도서 추가");
		panel.add(btnBookInsert);

		btnBookSearch = new JButton("도서 검색");
		panel.add(btnBookSearch);

		btnMemberAdmin = new JButton("회원 관리");
		panel.add(btnMemberAdmin);

		btnRentalAdmin = new JButton("출납 관리");
		panel.add(btnRentalAdmin);

		panel_1 = new JPanel();
		panel_1.setBounds(5, 84, 424, 33);
		contentPane.add(panel_1);

		btnLogout = new JButton("로그아웃");
		btnLogout.setBounds(171, 5, 81, 23);
		btnLogout.addActionListener(this);
		panel_1.setLayout(null);
		panel_1.add(btnLogout);
		
		btnUpdate = new JButton("정보수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (memberSearchDetail == null) {
					memberSearchDetail = new MemberSearchDetail();
				}else {
					Member mno =  service.selectMemberByNo(LoginUI.getLogin());
					System.out.println("mno값은"+mno);
					Member mem = new Member();
					mem.setMemberNo(mno.getMemberNo());
					mem.setPassword(mno.getPassword().substring(0,0));
					mem.setKorName(mno.getKorName());
					mem.setEngName(mno.getPhone());
					mem.setPhone(mno.getPhone());
					mem.setJumin(mno.getJumin());
					mem.setEmail(mno.getEmail());
					mem.setAddress(mno.getAddress());
					mem.setPhoto(mno.getPhoto());
					mem.setAdmin(true);
					mem.setUniqueness(mno.getUniqueness());
					
				
					memberSearchDetail.setLists(mem);
					memberSearchDetail.setVisible(true);
				}
			}
		});
		panel_1.add(btnUpdate);
		btnRentalAdmin.addActionListener(this);
		btnMemberAdmin.addActionListener(this);
		btnBookSearch.addActionListener(this);
		btnBookInsert.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogout) {
			do_btnLogout_actionPerformed(e);
		}
		if (e.getSource() == btnRentalAdmin) {
			do_btnRentalAdmin_actionPerformed(e);
		}
		if (e.getSource() == btnMemberAdmin) {
			do_btnMemberAdmin_actionPerformed(e);
		}
		if (e.getSource() == btnBookSearch) {
			do_btnBookSearch_actionPerformed(e);
		}
		if (e.getSource() == btnBookInsert) {
			do_btnBookInsert_actionPerformed(e);
		}
	}

	protected void do_btnBookInsert_actionPerformed(ActionEvent e) {
		if (bookInsertUI == null) {
			bookInsertUI = new BookInsertUI();
		}
		bookInsertUI.setVisible(true);
	}

	protected void do_btnBookSearch_actionPerformed(ActionEvent e) {
		if (bookSearchUI == null) {
			bookSearchUI = new BookSearchUI();
		}
		bookSearchUI.setVisible(true);
	}

	protected void do_btnMemberAdmin_actionPerformed(ActionEvent e) {
		if (memberSearchUI == null) {
			memberSearchUI = new MemberSearchUI();
		}
		memberSearchUI.setVisible(true);
	}

	protected void do_btnRentalAdmin_actionPerformed(ActionEvent e) {
		if (inOutUI == null) {
			inOutUI = new InOutUI();
		}
		inOutUI.setVisible(true);
	}

	protected void do_btnLogout_actionPerformed(ActionEvent e) {
		LoginUI.memberLogOut();
		this.setVisible(false);
		loginUI.setVisible(true);
	}
}

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
	private JButton btnRentAdmin;
	private JButton btnLogout;
	private BookInsertUI bookInsertUI;
	private BookSearchUI bookSearchUI;
	private MemberSearchUI memberSearchUI;
	private MemberSearchDetail memberSearchDetail;
	private MemberUpdateUI memberUpdateUI;
	private BookRentUI bookRentUI;
	private BookReturnUI bookReturnUI;
	private BookExtendUI bookExtendUI;
	private LoginUI loginUI;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnUpdate;
	private JButton btnExtendAdmin;
	private JButton btnReturnAdmin;

	public AdminMainUI() {
		loginUI = new LoginUI();
		memberSearchUI = new MemberSearchUI();
		initComponents();
	}

	private void initComponents() {
		setResizable(false);
		setTitle("[관리자] " + LoginUI.getLogin().getKorName() + "님 환영합니다.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(5, 5, 424, 156);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 10, 10));

		btnBookInsert = new JButton("도서 추가");
		btnBookInsert.addActionListener(this);
		panel.add(btnBookInsert);

		btnBookSearch = new JButton("도서 검색");
		btnBookSearch.addActionListener(this);
		panel.add(btnBookSearch);

		btnMemberAdmin = new JButton("회원 관리");
		btnMemberAdmin.addActionListener(this);
		panel.add(btnMemberAdmin);

		btnRentAdmin = new JButton("도서 대여");
		btnRentAdmin.addActionListener(this);
		panel.add(btnRentAdmin);
		
		btnReturnAdmin = new JButton("도서 반납");
		btnReturnAdmin.addActionListener(this);
		panel.add(btnReturnAdmin);
		
		btnExtendAdmin = new JButton("도서 연장");
		btnExtendAdmin.addActionListener(this);
		panel.add(btnExtendAdmin);

		panel_1 = new JPanel();
		panel_1.setBounds(5, 171, 424, 33);
		contentPane.add(panel_1);

		btnLogout = new JButton("로그아웃");
		btnLogout.setBounds(220, 5, 81, 23);
		btnLogout.addActionListener(this);
		panel_1.setLayout(null);
		panel_1.add(btnLogout);

		btnUpdate = new JButton("정보수정");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(127, 5, 81, 23);
		panel_1.add(btnUpdate);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate) {
			do_btnUpdate_actionPerformed(e);
		}
		if (e.getSource() == btnLogout) {
			do_btnLogout_actionPerformed(e);
		}
		if (e.getSource() == btnRentAdmin) {
			do_btnRentAdmin_actionPerformed(e);
		}
		if (e.getSource() == btnReturnAdmin) {
			do_btnRenturnAdmin_actionPerformed(e);
		}
		if (e.getSource() == btnExtendAdmin) {
			do_btnExtendAdmin_actionPerformed(e);
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
		}else {
			if(bookSearchUI.isVisible()==false) {
				bookSearchUI = new BookSearchUI();
			}
		}
		bookSearchUI.setVisible(true);
	}

	protected void do_btnMemberAdmin_actionPerformed(ActionEvent e) {
		if (memberSearchUI == null) {
			memberSearchUI = new MemberSearchUI();
		}
		memberSearchUI.setVisible(true);
	}

	protected void do_btnRentAdmin_actionPerformed(ActionEvent e) {
		if (bookRentUI == null) {
			bookRentUI = new BookRentUI();
		}
		bookRentUI.setVisible(true);
	}
	
	
	protected void do_btnRenturnAdmin_actionPerformed(ActionEvent e) {
		if (bookReturnUI == null) {
			bookReturnUI = new BookReturnUI();
		}
		bookReturnUI.setVisible(true);
	}
	
	protected void do_btnExtendAdmin_actionPerformed(ActionEvent e) {
		if (bookExtendUI == null) {
			bookExtendUI = new BookExtendUI();
		}
		bookExtendUI.setVisible(true);
	}
	

	protected void do_btnLogout_actionPerformed(ActionEvent e) {
		LoginUI.memberLogOut();
		this.setVisible(false);
		loginUI.setVisible(true);
	}

	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		if (memberUpdateUI == null) {
			memberUpdateUI = new MemberUpdateUI(LoginUI.getLogin());
		}
		memberUpdateUI.setVisible(true);
	}
}

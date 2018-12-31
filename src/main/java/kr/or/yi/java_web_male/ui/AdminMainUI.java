package kr.or.yi.java_web_male.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private InOutUI inOutUI;
	private LoginUI loginUI;
	private JPanel panel;
	private JPanel panel_1;

	public AdminMainUI() {
		loginUI = new LoginUI();
		initComponents();
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

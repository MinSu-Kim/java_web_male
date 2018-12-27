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

@SuppressWarnings("serial")
public class AdminMainUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnBookInsert;
	private JButton btnBookSearch;
	private JButton btnMemberAdmin;
	private JButton btnRentalAdmin;

	private BookInsertUI bookInsertUI;
	private BookSearchUI bookSearchUI;
	private MemberSearchUI memberSearchUI;
	private InOutUI inOutUI;

	public AdminMainUI() {
		initComponents();
	}

	private void initComponents() {
		setTitle("관리자");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 10, 10));

		btnBookInsert = new JButton("도서 추가");
		btnBookInsert.addActionListener(this);
		contentPane.add(btnBookInsert);

		btnBookSearch = new JButton("도서 검색");
		btnBookSearch.addActionListener(this);
		contentPane.add(btnBookSearch);

		btnMemberAdmin = new JButton("회원 관리");
		btnMemberAdmin.addActionListener(this);
		contentPane.add(btnMemberAdmin);

		btnRentalAdmin = new JButton("출납 관리");
		btnRentalAdmin.addActionListener(this);
		contentPane.add(btnRentalAdmin);
	}

	public void actionPerformed(ActionEvent e) {
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
}

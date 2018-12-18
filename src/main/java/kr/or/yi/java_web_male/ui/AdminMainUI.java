package kr.or.yi.java_web_male.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AdminMainUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnRentalAdmin;
	private JButton btnBookAdmin;
	private JButton btnMemberAdmin;
	private BookAdminUI bookAdminUI;
	private MemberSearchUI memberSearchUI;

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
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));

		btnBookAdmin = new JButton("도서 관리");
		btnBookAdmin.addActionListener(this);
		contentPane.add(btnBookAdmin);

		btnMemberAdmin = new JButton("회원 관리");
		btnMemberAdmin.addActionListener(this);
		contentPane.add(btnMemberAdmin);

		btnRentalAdmin = new JButton("출납 관리");
		btnRentalAdmin.addActionListener(this);
		contentPane.add(btnRentalAdmin);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMemberAdmin) {
			do_btnMemberAdmin_actionPerformed(e);
		}
		if (e.getSource() == btnBookAdmin) {
			do_btnBookAdmin_actionPerformed(e);
		}
		if (e.getSource() == btnRentalAdmin) {
			do_btnRentalAdmin_actionPerformed(e);
		}
	}

	protected void do_btnRentalAdmin_actionPerformed(ActionEvent e) {
	}

	protected void do_btnBookAdmin_actionPerformed(ActionEvent e) {
		if (bookAdminUI == null) {
			bookAdminUI = new BookAdminUI();
		}
		bookAdminUI.setVisible(true);
	}

	protected void do_btnMemberAdmin_actionPerformed(ActionEvent e) {
		if (memberSearchUI == null) {
			memberSearchUI = new MemberSearchUI();
		}
		memberSearchUI.setVisible(true);
	}
}

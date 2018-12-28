package kr.or.yi.java_web_male.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.service.LoginService;

@SuppressWarnings("serial")
public class LoginUI extends JFrame implements ActionListener {

	private static Member loginMember;
	private JPanel contentPane;
	private JTextField tfMemberNo;
	private JTextField tfPassword;
	private JLabel lblMemberNo;
	private JLabel lblPassword;
	private JPanel panel_2;
	private JButton btnLogin;
	private JButton btnSignUp;
	private JButton btnFind;
	private JButton btnSearch;
	private JButton btnBest;
	private AdminMainUI adminMainUI;
	private MemberInfoUI memberInfoUI;
	private BookSearchUI bookSearchUI;
	private String imgPath;
	private LoginService service;

	public static final Member getLogin() {
		return loginMember;
	}

	public static final void memberLogOut() {
		loginMember = null;
	}

	public static void main(String[] args) {
		// 룩앤필 변경
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginUI() {
		service = new LoginService();
		initComponent();
	}

	private void initComponent() {
		imgPath = System.getProperty("user.dir") + "\\images\\";

//		setContentPane(new JLabel(new ImageIcon(imgPath + "7.jpg")));
		pack();

		setTitle("로그인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 10));

		panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 10, 10));

		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));

		lblMemberNo = new JLabel("회원번호");
		panel.add(lblMemberNo);

		tfMemberNo = new JTextField();
		panel.add(tfMemberNo);
		tfMemberNo.setColumns(10);

		lblPassword = new JLabel("비밀번호");
		panel.add(lblPassword);

		tfPassword = new JPasswordField();
		panel.add(tfPassword);
		tfPassword.setColumns(10);

		btnLogin = new JButton("로그인");
		panel_2.add(btnLogin);
		btnLogin.addActionListener(this);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 10, 10));

		btnSignUp = new JButton("회원가입");
		btnSignUp.addActionListener(this);
		panel_1.add(btnSignUp);

		btnFind = new JButton("ID / PW 찾기");
		btnFind.addActionListener(this);
		panel_1.add(btnFind);

		btnSearch = new JButton("도서검색");
		btnSearch.addActionListener(this);
		panel_1.add(btnSearch);

		btnBest = new JButton("Best");
		btnBest.addActionListener(this);
		panel_1.add(btnBest);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBest) {
			do_btnBest_actionPerformed(e);
		}
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
		if (e.getSource() == btnFind) {
			do_btnFind_actionPerformed(e);
		}
		if (e.getSource() == btnSignUp) {
			do_btnSignUp_actionPerformed(e);
		}
		if (e.getSource() == btnLogin) {
			do_btnLogin_actionPerformed(e);
		}
	}

	protected void do_btnLogin_actionPerformed(ActionEvent arg0) {
		String id = tfMemberNo.getText().trim();
		String pw = tfPassword.getText().trim();
		Member member = service.selectMemberByNo(id);

		try {
			if (member != null) {
				if (member.getPassword().equals(pw)) {
					loginMember = member;
					if (member.isAdmin() == true) {
						if (adminMainUI == null) {
							adminMainUI = new AdminMainUI();
						}
						adminMainUI.setVisible(true);
					} else {
						if (memberInfoUI == null) {
							memberInfoUI = new MemberInfoUI();
						}
						memberInfoUI.setVisible(true);
					}
					dispose();
				} else {
					failLogin();
				}
			} else {
				failLogin();
			}
		} catch (Exception e) {
			e.printStackTrace();
			failLogin();
		}
	}

	private void failLogin() {
		clearTf();
	}

	private void clearTf() {
		tfMemberNo.setText("");
		tfPassword.setText("");
	}

	protected void do_btnSignUp_actionPerformed(ActionEvent e) {
	}

	protected void do_btnFind_actionPerformed(ActionEvent e) {
	}

	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		bookSearchUI = new BookSearchUI();
		bookSearchUI.setVisible(true);
		bookSearchUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	protected void do_btnBest_actionPerformed(ActionEvent e) {
		BestUI bestUI = new BestUI();
		bestUI.setVisible(true);
		bestUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

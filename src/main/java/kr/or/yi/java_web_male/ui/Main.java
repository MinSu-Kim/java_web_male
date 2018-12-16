package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private BookSearchUI bookSearchUI;
	private JButton btnLogin;
	private JButton btnSearchBook;
	private JButton btnBest;
	private LoginUI loginUI; 

	/**
	 * Launch the application.
	 */

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
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("○○도서관");
		setBackground(SystemColor.desktop);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));

		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);

		btnLogin.setFont(new Font("굴림", Font.PLAIN, 35));
		panel.add(btnLogin);

		btnSearchBook = new JButton("도서검색");
		btnSearchBook.addActionListener(this);

		btnSearchBook.setFont(new Font("굴림", Font.PLAIN, 35));
		panel.add(btnSearchBook);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnBest = new JButton("BEST!");
		btnBest.addActionListener(this);

		btnBest.setFont(new Font("굴림", Font.PLAIN, 18));
		panel_1.add(btnBest);
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBest) {
			do_btnBest_actionPerformed(e);
		}
		if (e.getSource() == btnLogin) {
			do_btnLogin_actionPerformed(e);
		}
		if (e.getSource() == btnSearchBook) {
			do_btnSearchBook_actionPerformed(e);
		}
	}
	private void do_btnSearchBook_actionPerformed(ActionEvent e) {
		if (bookSearchUI == null) {
			bookSearchUI = new BookSearchUI();
		}else {
			JOptionPane.showMessageDialog(null, "이미사용중인 창입니다");
		}
		bookSearchUI.setVisible(true);
	}

	protected void do_btnLogin_actionPerformed(ActionEvent e) {
		if (loginUI == null) {
			loginUI = new LoginUI();
		}else {
			JOptionPane.showMessageDialog(null, "이미사용중인 창입니다");
		}
		loginUI.setVisible(true);
	}
	
	protected void do_btnBest_actionPerformed(ActionEvent e) {
		
	}
}

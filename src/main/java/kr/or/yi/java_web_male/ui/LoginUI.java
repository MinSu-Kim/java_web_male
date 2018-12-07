package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dao.MemberMapperImpl;
import kr.or.yi.java_web_male.dto.Member;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfMemberNo;
	private JTextField tfPassword;
	private JLabel lblMemberNo;
	private JLabel lblPassword;
	// ui 몽음
	private AdminMainUI adminMainUI;
	private MemberInfoUI memberInfoUI;

	// 서비스 만들기
	private MemberMapper memberMapper;

	public static void main(String[] args) {
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
		memberMapper = new MemberMapperImpl();
		initComponent();
	}

	private void initComponent() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));

		lblMemberNo = new JLabel("회원번호");
		panel.add(lblMemberNo);

		tfMemberNo = new JTextField();
		panel.add(tfMemberNo);
		tfMemberNo.setColumns(10);

		lblPassword = new JLabel("비밀번호");
		panel.add(lblPassword);

		tfPassword = new JTextField();
		panel.add(tfPassword);
		tfPassword.setColumns(10);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(10, 10));

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLogin_actionPerformed(e);
			}
		});

		panel_1.add(btnLogin);
	}

	protected void do_btnLogin_actionPerformed(ActionEvent arg0) {
		String id = tfMemberNo.getText().trim();
		String pw = tfPassword.getText().trim();
		Member member = memberMapper.selectMemberbyNo(id);
		System.out.println(member);
		/*if (id.equals(member.getmemberNo())) {*/
			if (pw.equals(member.getPassword())) {
				JOptionPane.showMessageDialog(null, "성공");
				/*switch (member.getAdmin()) {
				case 0:
					 사용자 로그인 
					adminMainUI.setVisible(true);
				case 1:
					 관리자 로그인 
					memberInfoUI.setVisible(true);
				}*/
			} /*else {
				 로그인 실패 팝업 & 클리어 
				clearTf();
				System.out.println("로그인 실패!");
			}
		} else {
			 로그인 실패 
			clearTf();
			System.out.println("로그인 실패!");
		}*/
		
	}

	private void clearTf() {
		tfMemberNo.setText("");
		tfPassword.setText("");
	}

}

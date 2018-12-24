package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_male.service.LoginUIService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class FindIdPasswdUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textname;
	private JTextField textPhonenumber;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnPassword;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private LoginUIService loginUIService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindIdPasswdUI frame = new FindIdPasswdUI();
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
	public FindIdPasswdUI() {
		loginUIService = new LoginUIService();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 1, 0, 0));

		JPanel panelFindId = new JPanel();
		panel.add(panelFindId);
		panelFindId.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFindId.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(0);
		panelFindId.add(panel_3);

		rdbtnId = new JRadioButton("아이디찾기");
		rdbtnId.setSelected(true);
		panel_3.add(rdbtnId);
		rdbtnId.addActionListener(this);
		buttonGroup.add(rdbtnId);

		rdbtnPassword = new JRadioButton("비밀번호찾기");
		panel_3.add(rdbtnPassword);
		rdbtnPassword.addActionListener(this);
		buttonGroup.add(rdbtnPassword);

		JPanel panel_2 = new JPanel();
		panelFindId.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 10));

		lblNewLabel = new JLabel("이름");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);

		textname = new JTextField();
		panel_2.add(textname);
		textname.setColumns(10);

		lblNewLabel_1 = new JLabel("휴대폰 번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);

		textPhonenumber = new JTextField();
		panel_2.add(textPhonenumber);
		textPhonenumber.setColumns(10);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		btnNewButton = new JButton("찾기");
		btnNewButton.addActionListener(this);
		panel_1.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == rdbtnId) {
			do_rdbtnID_actionPerformed(e);
		}
		if (e.getSource() == rdbtnPassword) {
			try {
				do_rdbtnPassword_actionPerformed(e);
			} catch (AddressException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	protected void do_rdbtnPassword_actionPerformed(ActionEvent e) throws AddressException, MessagingException {
		/*final String host = "smtp.naver.com"; 
		final String username = "rlawpdud301"; 
		final String password = "dnlqh4517!";
		int port=465;
		String recipient = "psw2701@naver.com";
		String subject = "메일테스트"; 
		String body = username+"님으로 부터 메일을 받았습니다."; 
		Properties props = System.getProperties(); 
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", port); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true"); 
		props.put("mail.smtp.ssl.trust", host); 
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() { 
			String un=username; 
			String pw=password; 
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() { 
				return new javax.mail.PasswordAuthentication(un, pw); 
				} 
		}); 
		session.setDebug(true); 
		
		Message mimeMessage = new MimeMessage(session); //MimeMessage 생성 
		mimeMessage.setFrom(new InternetAddress("psw2701@naver.com")); 
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음 
		mimeMessage.setSubject(subject); //제목셋팅
		mimeMessage.setText(body); //내용셋팅 
		Transport.send(mimeMessage);*/
		
		lblNewLabel.setText("아이디(회원번호)");
	}

	protected void do_rdbtnID_actionPerformed(ActionEvent e) {
		lblNewLabel.setText("이름");
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", textPhonenumber.getText().trim());
		if (lblNewLabel.getText().equals("아이디(회원번호)")) {
			map.put("memberNo", textname.getText().trim());
		}else {
			map.put("korName", textname.getText().trim());
		}
	}
}

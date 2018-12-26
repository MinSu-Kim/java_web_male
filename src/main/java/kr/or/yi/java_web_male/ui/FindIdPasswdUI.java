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

import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.service.LoginUIService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FindIdPasswdUI extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField textname;
	private JTextField textPhonM;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnPassword;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private LoginUIService loginUIService;
	private JPanel panel_4;
	private JLabel lblNewLabel_2;
	private JTextField textPhonL;
	private JComboBox<String> comboBox;
	private JLabel label;
	private JLabel lblNamerage;
	private JLabel lblphonrage;

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
		setBounds(100, 100, 646, 234);
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
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblNewLabel = new JLabel("이름");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);

		textname = new JTextField();
		textname.addMouseListener(this);
		panel_2.add(textname);
		textname.setColumns(10);

		lblNamerage = new JLabel("");
		lblNamerage.setForeground(Color.RED);
		lblNamerage.setFont(new Font("굴림", Font.PLAIN, 9));
		panel_2.add(lblNamerage);

		panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblNewLabel_1 = new JLabel("휴대폰 번호");
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		String[] phone = { "선택해주세요", "010", "016", "017", "011" };

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(phone);
		comboBox = new JComboBox<>(model);
		panel_4.add(comboBox);

		label = new JLabel("-");
		panel_4.add(label);

		textPhonM = new JTextField();
		textPhonM.addMouseListener(this);
		panel_4.add(textPhonM);
		textPhonM.setColumns(10);

		lblNewLabel_2 = new JLabel("-");
		panel_4.add(lblNewLabel_2);

		textPhonL = new JTextField();
		textPhonL.addMouseListener(this);
		panel_4.add(textPhonL);
		textPhonL.setColumns(10);

		lblphonrage = new JLabel("");
		lblphonrage.setFont(new Font("굴림", Font.PLAIN, 9));
		lblphonrage.setForeground(Color.RED);
		panel_4.add(lblphonrage);

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

		/*final String host = "smtp.gmail.com";
		final String username = "rlawpdud301";
		final String password = "dnlqh1220";
		int port = 587;
		String recipient = "rlawpdud301@naver.com";
		String subject = "메일테스트";
		String body = username + "님으로 부터 메일을 받았습니다.";
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un = username;
			String pw = password;

			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(un, pw);
			}
		});
		session.setDebug(true);
		Message mimeMessage = new MimeMessage(session); // MimeMessage 생성
		mimeMessage.setFrom(new InternetAddress("rlawpdud301@gmail.com"));
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); // 수신자셋팅 //.TO 외에 .CC(참조)
																							// .BCC(숨은참조) 도 있음
		mimeMessage.setSubject(subject); // 제목셋팅 mimeMessage.setText(body); //내용셋팅
		Transport.send(mimeMessage);*/
		

		lblNamerage.setText("");
		lblphonrage.setText("");
		lblNewLabel.setText("아이디(회원번호)");
	}

	protected void do_rdbtnID_actionPerformed(ActionEvent e) {
		lblNamerage.setText("");
		lblphonrage.setText("");
		lblNewLabel.setText("이름");
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		if (comboBox.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "전화번호를 선택해주세요");
			return;
		}
		lblNamerage.setText("");
		lblphonrage.setText("");
		Map<String, Object> map = new HashMap<String, Object>();

		if (lblNewLabel.getText().equals("아이디(회원번호)")) {
			map.clear();
			String id = "^[A-Z]{1}[0-9]{4}$";
			if (Pattern.matches(id, textname.getText().trim())) {
				map.put("memberNo", textname.getText().trim());
				JOptionPane.showMessageDialog(null, map);
			} else {
				lblNamerage.setText("회원번호 형식이 몰바르지않습니다.");
				textname.setText("");
				return;
			}

		} else {
			map.clear();
			String name = "^[가-힣]{2,5}$";
			if (Pattern.matches(name, textname.getText().trim())) {
				map.put("korName", textname.getText().trim());
			} else {
				lblNamerage.setText("이름 형식이 몰바르지않습니다.");
				return;
			}

		}

		String phoneM = "^[0-9]{3,4}$";
		String phoneL = "^[0-9]{4}$";
		if (Pattern.matches(phoneM, textPhonM.getText().trim())) {
			if (Pattern.matches(phoneL, textPhonL.getText().trim())) {
				String phone = (comboBox.getSelectedItem() + "").trim() + "-" + textPhonM.getText().trim() + "-"
						+ textPhonL.getText().trim();
				map.put("phone", phone);
			} else {
				lblphonrage.setText("전화번호 형식이 몰바르지않습니다.");
				return;
			}
		} else {
			lblphonrage.setText("전화번호 형식이 몰바르지않습니다.");
			return;
		}

		Member member = loginUIService.selectBookByMapForeSum(map);
		if (lblNewLabel.getText().equals("아이디(회원번호)")) {
			if (member == null) {
				JOptionPane.showMessageDialog(null, "아이디, 전화번호를 확인해주세요");
			} else {
				String pass = "";
				for (int i = 0; i < 4; i++) {
					double random = Math.random();
					int num = (int) (random * 26) + 65;
					String a = ((char) num + "").trim();
					pass = pass + a;
				}
				for (int i = 0; i < 5; i++) {
					double random = Math.random();
					int num = (int) (random * 10);
					String a = (num + "").trim();
					pass = pass + a;
				}
				JOptionPane.showMessageDialog(null, pass);
				Map<String, Object> mappass = new HashMap<String, Object>();
				mappass.put("password", pass);
				mappass.put("memberNo", member.getMemberNo());
				int res = loginUIService.changePW(mappass);
				if (res == 1) {
					
					String from = "rlawpdud301";
			        String passWd = "비번";
			        String[] to = { member.getEmail() }; // 보낼 메일 목록
			        String subject = "Java send mail example";  // 메일 제목
			        String body = "고객님의 임시 비밀번호는"+pass+"입니다 로그인하여 비밀번호를 변경해주세요 ";       // 메일 내용

			        sendFromGMail(from, passWd, to, subject, body);
					JOptionPane.showMessageDialog(null, "임시비밀번호가 가입하실때기입하신 이메일로 발송되었습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "정상처리도지못하였습니다.관리자문의 바랍니다.");
				}

			}

		} else {
			if (member == null) {
				JOptionPane.showMessageDialog(null, "이름, 전화번호를 확인해주세요");
			} else {
				JOptionPane.showMessageDialog(null, "회원님의 회원번호는 " + member.getMemberNo() + " 입니다.");
				textname.setText("");
				comboBox.setSelectedIndex(0);
				textPhonM.setText("");
				textPhonL.setText("");
			}

		}

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == textPhonL) {
			do_textPhonL_mouseClicked(e);
		}
		if (e.getSource() == textPhonM) {
			do_textPhonM_mouseClicked(e);
		}
		if (e.getSource() == textname) {
			do_textname_mouseClicked(e);
		}
	}

	protected void do_textname_mouseClicked(MouseEvent e) {
		if (textname.getText() != null) {

		}
		lblNamerage.setText("");
		/* textname.setText(""); */
		textname.hasFocus();
	}

	protected void do_textPhonM_mouseClicked(MouseEvent e) {

		lblphonrage.setText("");
		/* textname.setText(""); */
		textPhonM.hasFocus();
	}

	protected void do_textPhonL_mouseClicked(MouseEvent e) {
		lblphonrage.setText("");
		/* textname.setText(""); */
		textPhonM.hasFocus();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        JOptionPane.showConfirmDialog(null, message);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

}

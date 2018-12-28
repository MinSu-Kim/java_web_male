package kr.or.yi.java_web_male.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dao.MemberMapperImpl;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.service.MemberModService;
import kr.or.yi.java_web_male.ui.LoginUI;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class MemberModUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfPassword;
	private JTextField tfNewPassword;
	private JTextField tfNewPasswordCheck;
	private JTextField tfEngName;
	private JTextField tfKorName;
	private JTextField tfMemberNo;
	private JTextField tfPhone;
	private JTextField tfJumin;
	private JTextField tfEmail;
	private JTextField tfAddress;
	private JLabel lblPhoto;
	private JButton btnPhoto;
	private JButton btnChange;
	private Member memberInfo;
	private MemberInfoUI memberInfoUI;
	private String pathName;
	private String fileName;
	private String imgPath;
	private MemberModService service;
	private JButton btnCancel;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField textField;
	private JButton btnNewButton;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JPanel panel_4;

	public MemberModUI() {
		imgPath = System.getProperty("user.dir") + "\\images\\";
		service = new MemberModService();
		initComponents();
	}

	private void initComponents() {
		setTitle("회원정보 변경");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 10));
		
		panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(91, 5, 242, 83);
		panel_4.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 10, 10));

		JPanel pMemberNo = new JPanel();
		panel_2.add(pMemberNo);
		pMemberNo.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblMemberNo = new JLabel("회원번호(ID)");
		pMemberNo.add(lblMemberNo);

		tfMemberNo = new JTextField();
		pMemberNo.add(tfMemberNo);
		tfMemberNo.setColumns(10);
		
				JPanel pKorName = new JPanel();
				panel_2.add(pKorName);
				pKorName.setLayout(new GridLayout(0, 2, 10, 10));
				
						JLabel lblKorName = new JLabel("한국명");
						pKorName.add(lblKorName);
						
								tfKorName = new JTextField();
								pKorName.add(tfKorName);
								tfKorName.setColumns(10);
								
										JPanel pEngName = new JPanel();
										panel_2.add(pEngName);
										pEngName.setLayout(new GridLayout(0, 2, 10, 10));
										
												JLabel lblEngName = new JLabel("영어명");
												pEngName.add(lblEngName);
												
														tfEngName = new JTextField();
														pEngName.add(tfEngName);
														tfEngName.setColumns(10);

		JPanel pPhoto = new JPanel();
		contentPane.add(pPhoto);

		btnPhoto = new JButton("사진 변경하기");
		btnPhoto.addActionListener(this);
		pPhoto.setLayout(new BorderLayout(0, 0));

		lblPhoto = new JLabel("");
		pPhoto.add(lblPhoto);
		pPhoto.add(btnPhoto, BorderLayout.SOUTH);

		JLabel lblPassword = new JLabel("현재 비밀번호 확인");
		contentPane.add(lblPassword);

		tfPassword = new JTextField();
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);

		JLabel lblNewPassword = new JLabel("새 비밀번호");
		contentPane.add(lblNewPassword);

		tfNewPassword = new JTextField();
		contentPane.add(tfNewPassword);
		tfNewPassword.setColumns(10);

		JLabel lblNewPasswordCheck = new JLabel("새 비밀번호 확인");
		contentPane.add(lblNewPasswordCheck);

		tfNewPasswordCheck = new JTextField();
		contentPane.add(tfNewPasswordCheck);
		tfNewPasswordCheck.setColumns(10);

		JLabel lblJumin = new JLabel("주민등록번호");
		contentPane.add(lblJumin);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 10, 10));

		tfJumin = new JTextField();
		panel_3.add(tfJumin);
		tfJumin.setColumns(10);
		
		lblNewLabel = new JLabel("-");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblPhone = new JLabel("전화번호");
		contentPane.add(lblPhone);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		contentPane.add(tfPhone);

		JLabel lblEmail = new JLabel("이메일");
		contentPane.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		contentPane.add(tfEmail);

		JLabel lblAddress = new JLabel("주소");
		contentPane.add(lblAddress);
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 10, 10));
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10));
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("검색");
		panel_1.add(btnNewButton);

		tfAddress = new JTextField();
		panel.add(tfAddress);
		tfAddress.setColumns(10);

		btnChange = new JButton("변경");
		btnChange.addActionListener(this);
		contentPane.add(btnChange);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);

		getMemberInfo(LoginUI.getLogin());

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnPhoto) {
			do_btnPhoto_actionPerformed(e);
		}
		if (e.getSource() == btnChange) {
			do_btnChange_actionPerformed(e);
		}
	}

	protected void do_btnChange_actionPerformed(ActionEvent arg0) {
		Member editMember = new Member();

		if (LoginUI.getLogin().getPassword().equals(tfPassword.getText().trim())) {

			editMember.setMemberNo(LoginUI.getLogin().getMemberNo());
			editMember.setPassword(LoginUI.getLogin().getPassword());
			editMember.setKorName(tfKorName.getText());
			editMember.setEngName(tfEngName.getText());
			editMember.setPhone(tfPhone.getText());
			editMember.setEmail(tfEmail.getText());
			editMember.setAddress(tfAddress.getText());
			editMember.setUniqueness(LoginUI.getLogin().getUniqueness());
			editMember.setJumin(LoginUI.getLogin().getJumin());

			if (tfNewPassword.getText().trim().equals(tfNewPasswordCheck.getText().trim())) {
				editMember.setPassword(tfNewPassword.getText().trim());
			} else if (!tfNewPassword.getText().trim().equals(tfNewPasswordCheck.getText().trim())) {
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
		}

		service.updateMember(editMember);

		Member member = service.selectMemberByNo(editMember.getMemberNo());

		if (memberInfoUI == null) {
			memberInfoUI = new MemberInfoUI();
			memberInfoUI.getMemberInfo(member);
		}

		memberInfoUI.setVisible(true);
	}

	public void getMemberInfo(Member member) {
		tfMemberNo.setText(member.getMemberNo());
		tfJumin.setText(member.getJumin());
		tfEmail.setText(member.getEmail());
		tfPhone.setText(member.getPhone());
		tfAddress.setText(member.getAddress());
		tfKorName.setText(member.getKorName());
		tfEngName.setText(member.getEngName());
		tfMemberNo.setEditable(false);
		tfJumin.setEditable(false);
		tfMemberNo.setEditable(false);
		tfMemberNo.setEditable(false);
	}

	protected void do_btnPhoto_actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
		chooser.setFileFilter(filter);

		int ret = chooser.showOpenDialog(null);

		if (ret == JFileChooser.APPROVE_OPTION) {
			pathName = chooser.getSelectedFile().getPath();
			fileName = chooser.getSelectedFile().getName();
			lblPhoto.setIcon(new ImageIcon(imgPath + fileName));
		}
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}

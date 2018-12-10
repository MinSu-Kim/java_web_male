package kr.or.yi.java_web_male.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dao.MemberMapperImpl;
import kr.or.yi.java_web_male.dto.Member;

@SuppressWarnings("serial")
public class MemberModUI extends JFrame {

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

	private Member memberInfo;

	private MemberInfoUI memberInfoUI;
	// 서비스 만들기
	private MemberMapper memberMapper;

	public MemberModUI() {
		memberMapper = new MemberMapperImpl();
		initComponents();
	}

	private void initComponents() {
		setTitle("회원정보 변경");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));

		JPanel pMemberNo = new JPanel();
		contentPane.add(pMemberNo);
		pMemberNo.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblMemberNo = new JLabel("회원번호(ID)");
		pMemberNo.add(lblMemberNo);

		tfMemberNo = new JTextField();
		pMemberNo.add(tfMemberNo);
		tfMemberNo.setColumns(10);

		JPanel pPhoto = new JPanel();
		contentPane.add(pPhoto);

		JButton btnPhoto = new JButton("사진 변경하기");
		pPhoto.add(btnPhoto);

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

		JPanel pKorName = new JPanel();
		contentPane.add(pKorName);
		pKorName.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblKorName = new JLabel("한국명");
		pKorName.add(lblKorName);

		tfKorName = new JTextField();
		pKorName.add(tfKorName);
		tfKorName.setColumns(10);

		JPanel pEngName = new JPanel();
		contentPane.add(pEngName);
		pEngName.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblEngName = new JLabel("영어명");
		pEngName.add(lblEngName);

		tfEngName = new JTextField();
		pEngName.add(tfEngName);
		tfEngName.setColumns(10);

		JLabel lblJumin = new JLabel("주민등록번호");
		contentPane.add(lblJumin);

		tfJumin = new JTextField();
		contentPane.add(tfJumin);
		tfJumin.setColumns(10);

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

		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		contentPane.add(tfAddress);

		JButton btnChange = new JButton("변경");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnChange_actionPerformed(e);
			}
		});
		contentPane.add(btnChange);

		JButton btnCancel = new JButton("취소");
		contentPane.add(btnCancel);

		tfMemberNo.setEditable(false);
		tfJumin.setEditable(false);
		tfMemberNo.setEditable(false);
		tfMemberNo.setEditable(false);

	}

	public void getMemberInfo(Member member) {
		this.memberInfo = member;
		System.out.println(member);
		tfMemberNo.setText(member.getMemberNo());
		tfJumin.setText(member.getJumin());
		tfEmail.setText(member.getEmail());
		tfPhone.setText(member.getPhone());
		tfAddress.setText(member.getAddress());
		tfKorName.setText(member.getKorName());
		tfEngName.setText(member.getEngName());
	}

	protected void do_btnChange_actionPerformed(ActionEvent arg0) {
		Member editMember = new Member();
	
		editMember.setMemberNo(this.memberInfo.getMemberNo());
		editMember.setPassword(this.memberInfo.getPassword());
		editMember.setKorName(tfKorName.getText());
		editMember.setEngName(tfEngName.getText());
		editMember.setPhone(tfPhone.getText());
		editMember.setEmail(tfEmail.getText());
		editMember.setAddress(tfAddress.getText());
		editMember.setUniqueness(this.memberInfo.getUniqueness());
		editMember.setJumin(this.memberInfo.getJumin());
		
		System.out.println(editMember);
		
		memberMapper.updateMember(editMember);

		Member member = memberMapper.selectMemberByNo(editMember.getMemberNo());

		if (memberInfoUI == null) {
			memberInfoUI = new MemberInfoUI();
			memberInfoUI.getMemberInfo(member);
		}
		memberInfoUI.setVisible(true);
	}

}

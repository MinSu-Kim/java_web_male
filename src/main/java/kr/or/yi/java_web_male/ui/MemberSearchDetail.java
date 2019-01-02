package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.scene.effect.Light.Distant;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.service.MemberUIService;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberSearchDetail extends JFrame {

	private JPanel contentPane;
	private JTextField textMemberNo;
	private JTextField textPass;
	private JTextField textKor;
	private JTextField textEng;
	private JTextField textPhone;
	private JTextField textJumin;
	private JTextField textEmail;
	private JTextField textAddress;
	private JTextField textAdmin;
	private JTextField textUni;
	private JLabel labelImg;
	private List<Member> listMember;
	private MemberUIService service;
	private String imgPath;
	private String pathName;
	private String fileName;
	private MemberSearchDetail memberSearchDetail;
	private Member member;
	private static Member loginMember;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSearchDetail frame = new MemberSearchDetail();
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
	
	public MemberSearchDetail() {
		imgPath = System.getProperty("user.dir") + "\\images\\";
		service = new MemberUIService();
		this.member = member;
		setTitle("회원상세정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 554);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel Member_Panel = new JPanel();
		panel.add(Member_Panel);
		Member_Panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		Member_Panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblMemberNo = new JLabel("회원번호");
		lblMemberNo.setBounds(0, 0, 111, 50);
		lblMemberNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblMemberNo);
		
		textMemberNo = new JTextField();
		textMemberNo.setEnabled(false);
		textMemberNo.setBounds(111, 0, 201, 50);
		panel_4.add(textMemberNo);
		textMemberNo.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		Member_Panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblPass = new JLabel("비밀번호");
		lblPass.setBounds(0, 0, 110, 50);
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblPass);
		
		textPass = new JTextField();
		textPass.setEnabled(false);
		textPass.setBounds(111, 0, 201, 50);
		panel_5.add(textPass);
		textPass.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		Member_Panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblKor = new JLabel("한글이름");
		lblKor.setBounds(0, 0, 110, 50);
		lblKor.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblKor);
		
		textKor = new JTextField();
		textKor.setEnabled(false);
		textKor.setBounds(111, 0, 201, 50);
		panel_6.add(textKor);
		textKor.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		Member_Panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblEng = new JLabel("영어이름");
		lblEng.setBounds(0, 0, 110, 50);
		lblEng.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblEng);
		
		textEng = new JTextField();
		textEng.setEnabled(false);
		textEng.setBounds(111, 0, 201, 50);
		panel_7.add(textEng);
		textEng.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		Member_Panel.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setBounds(0, 0, 111, 50);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setEnabled(false);
		textPhone.setBounds(111, 0, 201, 50);
		panel_8.add(textPhone);
		textPhone.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		Member_Panel.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblJumin = new JLabel("주민등록번호");
		lblJumin.setBounds(0, 0, 111, 50);
		lblJumin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblJumin);
		
		textJumin = new JTextField();
		textJumin.setEnabled(false);
		textJumin.setBounds(111, 0, 201, 50);
		panel_9.add(textJumin);
		textJumin.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		Member_Panel.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(0, 0, 111, 50);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEnabled(false);
		textEmail.setBounds(111, 0, 201, 50);
		panel_10.add(textEmail);
		textEmail.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		Member_Panel.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblAddress = new JLabel("주소");
		lblAddress.setBounds(0, 0, 111, 50);
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setEnabled(false);
		textAddress.setBounds(111, 0, 201, 50);
		panel_11.add(textAddress);
		textAddress.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		Member_Panel.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblAdmin = new JLabel("관리자");
		lblAdmin.setBounds(0, 0, 111, 50);
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblAdmin);
		
		textAdmin = new JTextField();
		textAdmin.setEnabled(false);
		textAdmin.setBounds(111, 0, 201, 50);
		textAdmin.setEditable(false);
		panel_13.add(textAdmin);
		textAdmin.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		Member_Panel.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel lblUni = new JLabel("특이사항");
		lblUni.setBounds(0, 0, 111, 50);
		lblUni.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(lblUni);
		
		textUni = new JTextField();
		textUni.setBounds(111, 0, 201, 50);
		panel_14.add(textUni);
		textUni.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(24, 0, 265, 254);
		panel_2.add(panel_12);
		panel_12.setLayout(null);
		
		labelImg = new JLabel("");
		labelImg.setBounds(12, 10, 250, 208);
		panel_12.add(labelImg);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 472, 312, 33);
		panel_2.add(panel_1);
		
		JButton btnUpdate = new JButton("저장");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdate_actionPerform(e);
			
			}
		});
		panel_1.add(btnUpdate);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(btnCancel);
		
		JButton btnNewButton = new JButton("탈퇴");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("newMemberNo", ("D("+textMemberNo.getText()+")").trim());
				map.put("memberNo", textMemberNo.getText());
				map.put("password", textPass.getText().substring(0, 0));
				int select = JOptionPane.showConfirmDialog(null, "정말로 탈퇴 하시겟습니까?");
				if(select==0) {
					service.deleteMemberNo(map);
					JOptionPane.showMessageDialog(null, "탈퇴 되었습니다.");
				}
				
			}
		});
		panel_1.add(btnNewButton);
	}
	//값을 받아옴
	public void setLists(Member member) {
		textMemberNo.setText(member.getMemberNo());
		textPass.setText(member.getPassword().substring(0,0)+"########");
		textKor.setText(member.getKorName());
		textEng.setText(member.getEngName());
		textPhone.setText(member.getPhone());
		textJumin.setText(member.getJumin().substring(0,7)+"*******");
		textEmail.setText(member.getEmail());
		textAddress.setText(member.getAddress());
		textAdmin.setText(((member.isAdmin())+"").trim());
		textUni.setText(member.getUniqueness());
		labelImg.setIcon(new ImageIcon(imgPath + member.getPhoto()));
	}
	private Member getList() {
		String Mno = textMemberNo.getText().trim();
		String pass = textPass.getText().trim();
		String Kor = textKor.getText().trim();
		String Eng = textEng.getText().trim();
		String Phone = textPhone.getText().trim();
		String jumin = (textJumin.getText().trim().substring(0,7)+"*******");
		String Email = textEmail.getText().trim();
//		boolean admin = textAdmin.getText() != null;
		String Address = textAddress.getText().trim();
		String Uni = textUni.getText().trim();
		String photo = fileName;
		return new Member(Mno,pass,Kor,Eng,Phone,jumin,Email,Address,photo,Uni);
	}
	private void do_btnUpdate_actionPerform(ActionEvent e) {
		Member editMem = getList();			
		service.updateDetail(editMem);
		System.out.println(editMem);
		JOptionPane.showMessageDialog(null, "저장되었습니다.");
	}
}

package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.effect.Light.Distant;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.service.MemberUIService;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private MemberSearchDetail memberSearchDetail;
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
		setTitle("회원상세정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 473);
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
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblMemberNo = new JLabel("회원번호");
		lblMemberNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblMemberNo);
		
		textMemberNo = new JTextField();
		textMemberNo.setEditable(false);
		panel_4.add(textMemberNo);
		textMemberNo.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		Member_Panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblPass = new JLabel("비밀번호");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblPass);
		
		textPass = new JTextField();
		textPass.setEditable(false);
		panel_5.add(textPass);
		textPass.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		Member_Panel.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblKor = new JLabel("한글이름");
		lblKor.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblKor);
		
		textKor = new JTextField();
		textKor.setEditable(false);
		panel_6.add(textKor);
		textKor.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		Member_Panel.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblEng = new JLabel("영어이름");
		lblEng.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblEng);
		
		textEng = new JTextField();
		textEng.setEditable(false);
		panel_7.add(textEng);
		textEng.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		Member_Panel.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblPhone);
		
		textPhone = new JTextField();
		panel_8.add(textPhone);
		textPhone.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		Member_Panel.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblJumin = new JLabel("주민등록번호");
		lblJumin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblJumin);
		
		textJumin = new JTextField();
		textJumin.setEditable(false);
		panel_9.add(textJumin);
		textJumin.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		Member_Panel.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblEmail);
		
		textEmail = new JTextField();
		panel_10.add(textEmail);
		textEmail.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		Member_Panel.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblAddress = new JLabel("주소");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblAddress);
		
		textAddress = new JTextField();
		panel_11.add(textAddress);
		textAddress.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		Member_Panel.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblAdmin = new JLabel("관리자");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblAdmin);
		
		textAdmin = new JTextField();
		textAdmin.setEditable(false);
		panel_13.add(textAdmin);
		textAdmin.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		Member_Panel.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblUni = new JLabel("특이사항");
		lblUni.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(lblUni);
		
		textUni = new JTextField();
		panel_14.add(textUni);
		textUni.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(null);
		
		labelImg = new JLabel("");
		labelImg.setBounds(39, 21, 250, 322);
		panel_12.add(labelImg);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 391, 312, 33);
		panel_12.add(panel_1);
		
		JButton btnUpdate = new JButton("수정");
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
	}
	public void setLists(Member member) {
		textMemberNo.setText(member.getMemberNo());
		textPass.setText(member.getPassword().substring(0,0)+"**********");
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
		String Pass = textPass.getText().trim();
		String Kor = textKor.getText().trim();
		String Eng = textEng.getText().trim();
		String Phone = textPhone.getText().trim();
		String jumin = textJumin.getText().trim();
		String Email = textEmail.getText().trim();
		String Address = textAddress.getText().trim();
		boolean Admin = textAdmin.getText().trim() != null;
		String Uni = textUni.getText().trim();
		return new Member(Mno,Pass,Kor,Eng,Phone,jumin,Email,Address,Admin,Uni);
	}
	private void do_btnUpdate_actionPerform(ActionEvent e) {
		Member editMem = getList();			
		service.updateMember(editMem);
		System.out.println(editMem);
		JOptionPane.showMessageDialog(null, "수정되었습니다.");
	}

}

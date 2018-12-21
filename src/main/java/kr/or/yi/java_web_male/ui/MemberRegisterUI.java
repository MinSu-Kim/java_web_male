package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.Post;
import kr.or.yi.java_web_male.service.MemberUIService;
import kr.or.yi.java_web_male.service.MyDocumentListener;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.CheckedInputStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.CardLayout;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import java.awt.Font;

public class MemberRegisterUI extends JFrame {

	private JPanel contentPane;
	private JTextField tFmemberNo;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfTel;
	private JTextField tFJu;
	private JTextField tfUni;
	private JPasswordField pass1;
	private JPasswordField pass2;
	private JTextField tfEmail;
	private JTextField tfEmail_2;
	private JTextField tfAdd;
	private PostUI postui;
	private MemberUIService service;
	private JCheckBox chckadmin;
	private PostSearchUI postsearch;
	private JTextField tfjuso;
	private JTextField tfConfirm;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberRegisterUI frame = new MemberRegisterUI();
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
	public MemberRegisterUI() {
		
		service = new MemberUIService();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 454, 494);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_no = new JPanel();
		panel.add(panel_no);
		panel_no.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblmemberNo = new JLabel("회원번호");
		lblmemberNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_no.add(lblmemberNo);
		
		tFmemberNo = new JTextField();
		panel_no.add(tFmemberNo);
		tFmemberNo.setColumns(10);
		
		JPanel panel_pass = new JPanel();
		panel.add(panel_pass);
		panel_pass.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_p = new JPanel();
		panel_pass.add(panel_p);
		panel_p.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblpassword = new JLabel("비밀번호");
		lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_p.add(lblpassword);
		
		JLabel lblconfirm = new JLabel("비밀번호 확인");
		lblconfirm.setHorizontalAlignment(SwingConstants.CENTER);
		panel_p.add(lblconfirm);
		
		JPanel panel_p2 = new JPanel();
		panel_pass.add(panel_p2);
		panel_p2.setLayout(new GridLayout(0, 2, 0, 0));
		
		pass1 = new JPasswordField();
		panel_p2.add(pass1);
		
		JPanel panel_p3 = new JPanel();
		panel_p2.add(panel_p3);
		
		pass2 = new JPasswordField();
		panel_p2.add(pass2);
		
		tfConfirm = new JTextField();
		tfConfirm.setEditable(false);
		panel_p2.add(tfConfirm);
		tfConfirm.setColumns(10);
		
		JPanel panel_kor = new JPanel();
		panel.add(panel_kor);
		panel_kor.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblKor = new JLabel("한글이름");
		lblKor.setHorizontalAlignment(SwingConstants.CENTER);
		panel_kor.add(lblKor);
		
		tfKor = new JTextField();
		panel_kor.add(tfKor);
		tfKor.setColumns(10);
		
		JPanel panel_Eng = new JPanel();
		panel.add(panel_Eng);
		panel_Eng.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblEng = new JLabel("영어이름");
		lblEng.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Eng.add(lblEng);
		
		tfEng = new JTextField();
		panel_Eng.add(tfEng);
		tfEng.setColumns(10);
		
		JPanel panel_Tel = new JPanel();
		panel.add(panel_Tel);
		panel_Tel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTel = new JLabel("전화번호");
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Tel.add(lblTel);
		
		tfTel = new JTextField();
		panel_Tel.add(tfTel);
		tfTel.setColumns(10);
		
		JPanel panel_Ju = new JPanel();
		panel.add(panel_Ju);
		panel_Ju.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblJu = new JLabel("주민등록번호");
		lblJu.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Ju.add(lblJu);
		
		tFJu = new JTextField();
		panel_Ju.add(tFJu);
		tFJu.setColumns(10);
		
		JPanel panel_Email = new JPanel();
		panel.add(panel_Email);
		panel_Email.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Email.add(lblEmail);
		
		JPanel panel_19 = new JPanel();
		panel_Email.add(panel_19);
		panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.X_AXIS));
		
		tfEmail = new JTextField();
		panel_19.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("@");
		panel_19.add(lblNewLabel_12);
		
		tfEmail_2 = new JTextField();
		panel_19.add(tfEmail_2);
		tfEmail_2.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectEmail(e);
			}
		});
		comboBox.setFont(new Font("굴림", Font.PLAIN, 10));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"선택해주세요", "naver.com", "google.com", "daum.net", "nate.com", "직접입력"}));
		panel_19.add(comboBox);
		
		JPanel panel_Add = new JPanel();
		panel.add(panel_Add);
		panel_Add.setLayout(null);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBounds(0, 0, 227, 49);
		panel_Add.add(panel_21);
		panel_21.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblAdd = new JLabel("우편번호 검색");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblAdd);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBounds(227, 0, 227, 49);
		panel_Add.add(panel_20);
		panel_20.setLayout(null);
		
		tfAdd = new JTextField();
		tfAdd.setBounds(0, 0, 142, 49);
		panel_20.add(tfAdd);
		tfAdd.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostUI post = new PostUI();
				post.setMemberRegisterUI(MemberRegisterUI.this);
				post.setVisible(true);
			}
		});
		btnSearch.setBounds(141, 0, 85, 49);
		panel_20.add(btnSearch);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbljuso = new JLabel("주소");
		lbljuso.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lbljuso);
		
		tfjuso = new JTextField();
		panel_4.add(tfjuso);
		tfjuso.setColumns(10);
		
		JPanel panel_Admin = new JPanel();
		panel.add(panel_Admin);
		panel_Admin.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblAdmin_1 = new JLabel("관리자");
		lblAdmin_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Admin.add(lblAdmin_1);
		
		chckadmin = new JCheckBox("관리");		
		chckadmin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Admin.add(chckadmin);
		
		JPanel panel_Uni = new JPanel();
		panel.add(panel_Uni);
		panel_Uni.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblUni = new JLabel("특이사항");
		lblUni.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Uni.add(lblUni);
		
		tfUni = new JTextField();
		panel_Uni.add(tfUni);
		tfUni.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(459, 5, 454, 494);
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnAdd_1 = new JButton("가입");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMember();
				JOptionPane.showMessageDialog(null, "회원이 되신걸 축하드립니다.");
				
			}
		});
		btnAdd_1.setBounds(23, 440, 70, 23);
		btnAdd_1.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_3.add(btnAdd_1);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(108, 440, 70, 23);
		panel_3.add(btnCancel);
		
		JButton btnImg = new JButton("사진추가");
		btnImg.setBounds(23, 287, 155, 23);
		panel_3.add(btnImg);
		
		JLabel lblImg = new JLabel("New label");
		lblImg.setBounds(76, 106, 57, 15);
		panel_3.add(lblImg);
		//비밀번호 중복 메서드
		pass2.getDocument().addDocumentListener(new MyDocumentListener() {
			
			@Override
			public void msg() {
				
				String pw1 = new String(pass1.getPassword());
				String pw2 = new String(pass2.getPassword());
				
				if(pw1.equals(pw2)) {
					tfConfirm.setText("비밀번호가 일치");
				}else {
					tfConfirm.setText("비밀번호가 불일치");
				}
				
			}
		});
	}
	/*public void actionPerformed(ActionEvent e) {
		selectEmail(e);
	}	*/
	private void getMember() {
		Member member = new Member();
		
		member.setPassword(new String(pass1.getPassword()));
		member.setKorName(tfKor.getText());
		member.setEngName(tfEng.getText());
		member.setPhone(tfTel.getText());
		member.setJumin(tFJu.getText());
		member.setEmail(tfEmail.getText());
		member.setAddress(tfEmail.getText()+tfjuso.getText());
		member.setAdmin(chckadmin.isSelected());
		member.setUniqueness(tfUni.getText());
		int i = 0;	
		
		String make = tfEng.getText().substring(0, 1);
		JOptionPane.showMessageDialog(null, make);
		member.setMemberNo(make);
		if(service.selectMemberByNoList(member).equals(null)){
			make = make + "0001";
		}else {
			JOptionPane.showMessageDialog(null, service.selectMemberByNoList(member).size());
			i = service.selectMemberByNoList(member).size()+1;	
			JOptionPane.showMessageDialog(null, i);
		}
		
		String mn = String.format("%s%04d",make, i);
		JOptionPane.showMessageDialog(null, mn);
		member.setMemberNo(mn);
		service.insertMember(member);
	}
	
	protected void selectEmail(ActionEvent e) {
		if(comboBox.getSelectedIndex()<5) {
			tfEmail_2.setEditable(false);
			tfEmail_2.setText((String)comboBox.getSelectedItem());
		}else {
			tfEmail_2.requestFocus();
			tfEmail_2.setText("입력하세요");
			tfEmail_2.setEditable(true);
		}
	} 
	public void setAddress(String addr) {
		this.tfAdd.setText(addr);
	}


	public void setTfjuso(String tfjuso) {
		this.tfjuso.setText(tfjuso);
	}
	
}//end of class

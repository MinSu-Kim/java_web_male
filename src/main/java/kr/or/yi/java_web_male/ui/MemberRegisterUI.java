package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.scene.image.Image;
import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.MemberRentalInfo;
import kr.or.yi.java_web_male.dto.Overdue;
import kr.or.yi.java_web_male.dto.Post;
import kr.or.yi.java_web_male.service.MemberUIService;
import kr.or.yi.java_web_male.service.MyDocumentListener;

import java.awt.GridLayout;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Dimension;

public class MemberRegisterUI extends JFrame {

	private JPanel contentPane;
	private JTextField tFmemberNo;
	private JTextField tfKor;
	private JTextField tfEng;
	private JPasswordField pass1;
	private JPasswordField pass2;
	private JTextField tfEmail;
	private JTextField tfEmail_2;
	private JTextField tfAdd;
	private String imgPath;
	private PostUI postui;
	private MemberUIService service;
	private JCheckBox chckadmin;
	private PostSearchUI postsearch;
	private JTextField tfjuso;
	private JTextField tfConfirm;
	private JComboBox comboBox;
	private JComboBox<String> TelBox;
	private JLabel lblImg;
	private JTextField tftel2;
	private JTextField tftel3;
	private JTextField tfju1;
	private String pathName;
	private String fileName;
	private JTextField tfpass;
	private static String adminpassword = "1234";
	private JPasswordField tfju2;
	private String mn;
	
	
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

	public static void setAdminpassword(String adminpassword1) {
		adminpassword = adminpassword1;
	}
	/**
	 * Create the frame.
	 */
	public MemberRegisterUI() {
		service = new MemberUIService();
		imgPath = System.getProperty("user.dir") + "\\images\\";		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 672, 586);
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
		panel_no.setLayout(null);
		
		JLabel lblmemberNo = new JLabel("회원번호");
		lblmemberNo.setBounds(0, 0, 162, 49);
		lblmemberNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_no.add(lblmemberNo);
		
		tFmemberNo = new JTextField();
		tFmemberNo.setBounds(162, 0, 292, 49);
		tFmemberNo.setHorizontalAlignment(SwingConstants.CENTER);
		tFmemberNo.setText("회원번호는 자동으로 부여됩니다.");
		tFmemberNo.setEnabled(false);
		panel_no.add(tFmemberNo);
		tFmemberNo.setColumns(10);
		
		JPanel panel_pass = new JPanel();
		panel.add(panel_pass);
		panel_pass.setLayout(null);
		
		JPanel panel_p = new JPanel();
		panel_p.setBounds(0, 0, 163, 49);
		panel_pass.add(panel_p);
		panel_p.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblpassword = new JLabel("비밀번호");
		lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_p.add(lblpassword);
		
		JLabel lblconfirm = new JLabel("비밀번호 확인");
		lblconfirm.setHorizontalAlignment(SwingConstants.CENTER);
		panel_p.add(lblconfirm);
		
		JPanel panel_p2 = new JPanel();
		panel_p2.setBounds(162, 0, 292, 49);
		panel_pass.add(panel_p2);
		panel_p2.setLayout(null);
		
		pass1 = new JPasswordField();
		pass1.setBounds(0, 0, 147, 27);
		panel_p2.add(pass1);
		
		tfpass = new JTextField();
		tfpass.setFont(new Font("굴림", Font.PLAIN, 10));
		tfpass.setBounds(147, 0, 145, 27);
		tfpass.setEditable(false);
		tfpass.setText("8자이상+특수문자,문자,숫자");
		panel_p2.add(tfpass);
		tfpass.setColumns(10);
		
		pass2 = new JPasswordField();
		pass2.setBounds(0, 27, 147, 22);
		panel_p2.add(pass2);
		
		tfConfirm = new JTextField();
		tfConfirm.setFont(new Font("굴림", Font.PLAIN, 10));
		tfConfirm.setBounds(147, 27, 145, 22);
		tfConfirm.setEditable(false);
		panel_p2.add(tfConfirm);
		tfConfirm.setColumns(10);
		
		JPanel panel_kor = new JPanel();
		panel.add(panel_kor);
		panel_kor.setLayout(null);
		
		JLabel lblKor = new JLabel("한글이름");
		lblKor.setBounds(0, 0, 163, 49);
		lblKor.setHorizontalAlignment(SwingConstants.CENTER);
		panel_kor.add(lblKor);
		
		tfKor = new JTextField();
		tfKor.setBounds(162, 0, 292, 49);
		panel_kor.add(tfKor);
		tfKor.setColumns(10);
		
		JPanel panel_Eng = new JPanel();
		panel.add(panel_Eng);
		panel_Eng.setLayout(null);
		
		JLabel lblEng = new JLabel("영어이름");
		lblEng.setBounds(0, 0, 163, 49);
		lblEng.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Eng.add(lblEng);
		
		tfEng = new JTextField();
		tfEng.setBounds(162, 0, 292, 49);
		panel_Eng.add(tfEng);
		tfEng.setColumns(10);
		
		JPanel panel_Tel = new JPanel();
		panel.add(panel_Tel);
		panel_Tel.setLayout(null);
		
		JLabel lblTel = new JLabel("전화번호");
		lblTel.setBounds(0, 0, 163, 49);
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Tel.add(lblTel);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(162, 0, 292, 49);
		panel_Tel.add(panel_5);
		panel_5.setLayout(null);
		
		TelBox = new JComboBox();
		TelBox.setBounds(0, 0, 67, 49);
		TelBox.setModel(new DefaultComboBoxModel(new String[] {"010", "011", "016", "017"}));
		panel_5.add(TelBox);
		
		JLabel label = new JLabel("-");
		label.setBounds(70, 17, 6, 15);
		panel_5.add(label);
		
		tftel2 = new JTextField();
		tftel2.setBounds(77, 0, 102, 49);
		panel_5.add(tftel2);
		tftel2.setColumns(10);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(182, 17, 6, 15);
		panel_5.add(label_1);
		
		tftel3 = new JTextField();
		tftel3.setBounds(190, 0, 102, 49);
		panel_5.add(tftel3);
		tftel3.setColumns(10);
		
		JPanel panel_Ju = new JPanel();
		panel.add(panel_Ju);
		panel_Ju.setLayout(null);
		
		JLabel lblJu = new JLabel("주민등록번호");
		lblJu.setBounds(0, 0, 163, 49);
		lblJu.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Ju.add(lblJu);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(162, 0, 292, 49);
		panel_Ju.add(panel_6);
		panel_6.setLayout(null);
		
		tfju1 = new JTextField();
		tfju1.setBounds(0, 0, 140, 49);
		panel_6.add(tfju1);
		tfju1.setColumns(10);
		
		JLabel label_2 = new JLabel("-");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(136, 17, 22, 15);
		panel_6.add(label_2);
		
		tfju2 = new JPasswordField();
		tfju2.setBounds(152, 0, 140, 49);
		tfju2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_6.add(tfju2);
		
		JPanel panel_Email = new JPanel();
		panel.add(panel_Email);
		panel_Email.setLayout(null);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(0, 0, 163, 49);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Email.add(lblEmail);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBounds(162, 0, 210, 49);
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
		comboBox.setBounds(370, 1, 84, 49);
		panel_Email.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectEmail(e);
			}
		});
		comboBox.setFont(new Font("굴림", Font.PLAIN, 10));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"선택해주세요", "naver.com", "google.com", "daum.net", "nate.com", "직접입력"}));
		
		JPanel panel_Add = new JPanel();
		panel.add(panel_Add);
		panel_Add.setLayout(null);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBounds(0, 0, 162, 49);
		panel_Add.add(panel_21);
		panel_21.setLayout(null);
		
		JLabel lblAdd = new JLabel("우편번호 검색");
		lblAdd.setBounds(0, 0, 162, 49);
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblAdd);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBounds(162, 0, 292, 49);
		panel_Add.add(panel_20);
		panel_20.setLayout(null);
		
		tfAdd = new JTextField();
		tfAdd.setBounds(0, 0, 210, 49);
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
		btnSearch.setBounds(208, 0, 84, 49);
		panel_20.add(btnSearch);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lbljuso = new JLabel("주소");
		lbljuso.setBounds(0, 0, 163, 49);
		lbljuso.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lbljuso);
		
		tfjuso = new JTextField();
		tfjuso.setBounds(161, 0, 293, 49);
		panel_4.add(tfjuso);
		tfjuso.setColumns(10);
		
		JPanel panel_Admin = new JPanel();
		panel.add(panel_Admin);
		panel_Admin.setLayout(null);
		
		JLabel lblAdmin_1 = new JLabel("관리자");
		lblAdmin_1.setBounds(0, 0, 162, 49);
		lblAdmin_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Admin.add(lblAdmin_1);
		
		chckadmin = new JCheckBox("관리");		
		chckadmin.setBounds(161, 0, 293, 49);
		chckadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String admin = JOptionPane.showInputDialog("관리번호를 입력해주세요");				
				if(admin.equals(adminpassword)) {
					chckadmin.setSelected(true);
					return;
				}else
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
					chckadmin.setSelected(false);
			}
		});
		chckadmin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Admin.add(chckadmin);
		
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
		
		JButton btnImg = new JButton("사진추가");
		btnImg.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
				chooser.setFileFilter(filter);
				int ret = chooser.showOpenDialog(null);
				
				if(ret == JFileChooser.APPROVE_OPTION) {
					pathName = chooser.getSelectedFile().getPath();
					fileName = chooser.getSelectedFile().getName();
					lblImg.setIcon(new ImageIcon(imgPath + fileName));
				}
			}
		});
		btnImg.setBounds(25, 248, 155, 23);
		panel_3.add(btnImg);
		
		lblImg = new JLabel("사진을추가해주세요");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBounds(12, 10, 178, 267);
		panel_3.add(lblImg);
		
		JButton btnAdd_1 = new JButton("가입");
		btnAdd_1.setBounds(237, 509, 100, 23);
		contentPane.add(btnAdd_1);
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					check();
					getMember();
					insertRentailInfo();
					insertOverdue();
					JOptionPane.showMessageDialog(null, "회원이 되신걸 축하드립니다.");
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
					e2.printStackTrace();
					
				}
								
			}
		});
		btnAdd_1.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(340, 509, 100, 23);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		//비밀번호 중복 메서드
		pass2.getDocument().addDocumentListener(new MyDocumentListener() {
			
			@Override
			public void msg() {
				
				String pw1 = new String(pass1.getPassword());
				String pw2 = new String(pass2.getPassword());
				String pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,}$";
				Matcher matcher = Pattern.compile(pwPattern).matcher(pw1);
				if(pw1.equals(pw2)) {
					tfConfirm.setText("비밀번호가 일치");
				}else {
					tfConfirm.setText("비밀번호가 불일치");
				}
				if(!matcher.matches()) {
					tfpass.setText("영문숫자 불일치.");
					tfpass.setFont(new Font("굴림", Font.PLAIN, 12));
				}else {
					tfpass.setText("영문숫자 일치.");
				}
			}
		});
	}
	private void getMember() {
		Member member = new Member();
		member.setPassword(new String(pass1.getPassword()).trim());
		member.setKorName(tfKor.getText().trim());
		member.setEngName(tfEng.getText().trim());
		member.setPhone((String)TelBox.getSelectedItem() + "-"+ tftel2.getText().trim()+"-"+tftel3.getText().trim());
		member.setJumin(tfju1.getText().trim()+"-"+tfju2.getText().trim());
		member.setEmail(tfEmail.getText().trim()+"@"+tfEmail_2.getText().trim());
		member.setAddress(tfAdd.getText().trim()+tfjuso.getText().trim());
		member.setAdmin(chckadmin.isSelected());
		member.setPhoto(fileName);
		int i = 0;	
		
		String make = tfEng.getText().substring(0, 1);
		member.setMemberNo(make);
		if(service.selectMemberByNoList(member).equals(null)){
			make = make + "0001";
		}else {
			i = service.selectMemberByNoList(member).size()+1;
			tFmemberNo.setText(make);
		}
			
		mn = String.format("%s%04d",make, i);
		mn = mn.toUpperCase();
		JOptionPane.showMessageDialog(null, mn);
		member.setMemberNo(mn);
		service.insertMember(member);
		
		
		
	}
	@SuppressWarnings("unlikely-arg-type")
	private void check() throws Exception {
		if(tfKor.getText().trim().equals("")) {
			tfKor.requestFocus();
			throw new Exception("한글 이름을 입력해주세요.");
		}
		if(tfEng.getText().trim().equals("")) {
			tfEng.requestFocus();
			throw new Exception("영어 이름을 입력해주세요");
		}
		if(tftel2.getText().trim().equals("")) {
			tftel2.requestFocus();
			throw new Exception("전화번호 중앙자리를!");
		}
		if(tftel3.getText().trim().equals("")) {
			tftel3.requestFocus();
			throw new Exception("전화번호 뒷자리을 입력해주세요");
		}
		String pw1 = new String(pass1.getPassword());
		String pw2 = new String(pass2.getPassword());
		String ju1 = new String(tfju1.getText());
		String ju2 = new String(tfju2.getPassword());
		String pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,}$";
		Matcher matcher = Pattern.compile(pwPattern).matcher(pw1);
		if(pw1.equals("")) {
			pass1.requestFocus();
			throw new Exception("Password를 입력해주세요");
		}
		if(pw2.equals("")) {
			pass2.requestFocus();
			throw new Exception("Password를 입력해주세요");
		}
		if(!pw2.equals(pw1)) {
			pass1.requestFocus();
			throw new Exception("Password가 일치하지않아 가입할수 없습니다.");
		}
		if(!matcher.matches()) {
			pass1.requestFocus();
			throw new Exception("Password양식에 맞지않아 가입할수 없습니다.");
		}
		if(tfju1.getText().trim().equals("")) {
			tfju1.requestFocus();
			throw new Exception("주민등록 번호를  앞자리를 입력해주세요");
		}
		if(tfju2.getText().trim().equals("")) {
			tfju2.requestFocus();
			throw new Exception("주민등록 번호 뒷자리를 입력해주세요");
		}
		if(tfEmail.getText().trim().equals("")) {
			tfEmail.requestFocus();
			throw new Exception("이메일을 입력해주세요");
		}
		if(tfEmail_2.getText().trim().equals("")) {
			tfEmail_2.requestFocus();
			throw new Exception("홈페이지를 입력해주세요");
		}
		if(tfAdd.getText().trim().equals("")) {
			tfAdd.requestFocus();
			throw new Exception("주소를 입력해주세요");
		}
		if(tfjuso.getText().trim().equals("")) {
			tfjuso.requestFocus();
			throw new Exception("주소를 입력해주세요");
		}
			Member member = new Member();
			member.setJumin(tfju1.getText()+"-"+new String(tfju2.getPassword()));		
		if(service.selectMemberByNojumin(member).size() == 0) {
			
		}else {
			tfju2.requestFocus();
			throw new Exception("이미 등록된 회원입니다.");
		}
		
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
	protected void insertRentailInfo() {
		MemberRentalInfo memberRentalInfo = new MemberRentalInfo();
		memberRentalInfo.setMemberNo(mn);
		memberRentalInfo.setGrade(1);
		memberRentalInfo.setNowTotal(3);
		memberRentalInfo.setNowTotal(0);		
		int res = service.insertMemberRentalInfo(memberRentalInfo);
			
	}
	protected void insertOverdue() {
		Overdue overdue = new Overdue();
		overdue.setMemberNo(mn);
		overdue.setRentalAuthority(true);
		overdue.setOverdueCount(0);
		overdue.setStopDate(0);
		overdue.setStopEndDate(null);
		int res = service.insertoverDue(overdue);
	}
	
	public void setAddress(String addr) {
		this.tfAdd.setText(addr);
	}
	
	public void setTfjuso(String tfjuso) {
		this.tfjuso.setText(tfjuso);
	}
}//end of class

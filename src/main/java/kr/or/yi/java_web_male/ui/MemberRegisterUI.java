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
import kr.or.yi.java_web_male.dto.Post;
import kr.or.yi.java_web_male.service.MemberUIService;
import kr.or.yi.java_web_male.service.MyDocumentListener;

import java.awt.GridLayout;
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

public class MemberRegisterUI extends JFrame {

	private JPanel contentPane;
	private JTextField tFmemberNo;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfUni;
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
	private JTextField tfju2;
	private String pathName;
	private String fileName;
	private JTextField tfpass;
	private static String adminpassword = "45685";
	
	
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
		tFmemberNo.setEnabled(false);
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
		
		tfpass = new JTextField();
		tfpass.setEditable(false);
		panel_p2.add(tfpass);
		tfpass.setColumns(10);
		
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
		
		JPanel panel_5 = new JPanel();
		panel_Tel.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		TelBox = new JComboBox();
		TelBox.setModel(new DefaultComboBoxModel(new String[] {"010", "011", "016", "017"}));
		panel_5.add(TelBox);
		
		JLabel label = new JLabel("-");
		panel_5.add(label);
		
		tftel2 = new JTextField();
		panel_5.add(tftel2);
		tftel2.setColumns(10);
		
		JLabel label_1 = new JLabel("-");
		panel_5.add(label_1);
		
		tftel3 = new JTextField();
		panel_5.add(tftel3);
		tftel3.setColumns(10);
		
		JPanel panel_Ju = new JPanel();
		panel.add(panel_Ju);
		panel_Ju.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblJu = new JLabel("주민등록번호");
		lblJu.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Ju.add(lblJu);
		
		JPanel panel_6 = new JPanel();
		panel_Ju.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		tfju1 = new JTextField();
		panel_6.add(tfju1);
		tfju1.setColumns(10);
		
		JLabel label_2 = new JLabel("-");
		panel_6.add(label_2);
		
		tfju2 = new JTextField();
		panel_6.add(tfju2);
		tfju2.setColumns(10);
		
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
				try {
					check();
					getMember();
					JOptionPane.showMessageDialog(null, "회원이 되신걸 축하드립니다.");
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
					e2.printStackTrace();
					
				}
								
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
		btnImg.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
				chooser.setFileFilter(filter);
				int ret = chooser.showOpenDialog(null);
				
				if(ret == JFileChooser.APPROVE_OPTION) {
					pathName = chooser.getSelectedFile().getPath();
					fileName = chooser.getSelectedFile().getName();
					
					System.out.println(pathName);
					System.out.println(fileName);
					lblImg.setIcon(new ImageIcon(imgPath + fileName));
				}
			}
		});
		btnImg.setBounds(23, 287, 155, 23);
		panel_3.add(btnImg);
		
		lblImg = new JLabel("사진을추가해주세요");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBounds(23, 10, 155, 267);
		panel_3.add(lblImg);
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
		member.setAddress(tfEmail.getText().trim()+tfjuso.getText().trim());
		member.setAdmin(chckadmin.isSelected());
		member.setUniqueness(tfUni.getText().trim());
		member.setPhoto(fileName);
		int i = 0;	
		
		String make = tfEng.getText().substring(0, 1);
		member.setMemberNo(make);
		if(service.selectMemberByNoList(member).equals(null)){
			make = make + "0001";
		}else {
			i = service.selectMemberByNoList(member).size()+1;
		
		}
			
		String mn = String.format("%s%04d",make, i);
		mn = mn.toUpperCase();
		JOptionPane.showMessageDialog(null, mn);
		member.setMemberNo(mn);
		service.insertMember(member);
		
	}
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

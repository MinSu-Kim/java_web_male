package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.CardLayout;

public class MemberRegisterUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("회원번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		panel_5.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12);
		
		JLabel lblNewLabel_3 = new JLabel("비밀번호 확인");
		panel_5.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		textField_9 = new JTextField();
		panel_5.add(textField_9);
		textField_9.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("한글이름");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		panel_6.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("영어이름");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		panel_7.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("전화번호");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		panel_8.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("주민등록번호");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		panel_9.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_8 = new JLabel("이메일");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		panel_10.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("주소");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		panel_11.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("검색하기");
		panel_11.add(btnNewButton_2);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("사용자");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblNewLabel_10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("관리자");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(chckbxNewCheckBox);
		
		JPanel panel_15 = new JPanel();
		panel_13.add(panel_15);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("회원");
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(chckbxNewCheckBox_1);
		
		JPanel panel_14 = new JPanel();
		panel.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_11 = new JLabel("특이사항");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(lblNewLabel_11);
		
		textField_10 = new JTextField();
		panel_14.add(textField_10);
		textField_10.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("추가");
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("사진추가");
		panel_2.add(btnNewButton_3, BorderLayout.NORTH);
	}

}

package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MemberManagerUI extends JFrame {

	private JPanel contentPane;
	private JTextField textMemberNo;
	private JTextField tfName;
	private JTextField tfTel;
	private JTextField tfBirth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManagerUI frame = new MemberManagerUI();
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
	public MemberManagerUI() {
		setTitle("회원관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblMemberNo = new JLabel("회원번호");
		lblMemberNo.setForeground(Color.RED);
		lblMemberNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblMemberNo);
		
		textMemberNo = new JTextField();
		panel_1.add(textMemberNo);
		textMemberNo.setColumns(10);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 10, 0));
		
		JCheckBox chckbxName = new JCheckBox("이름");
		chckbxName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(chckbxName);
		
		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(10);
		
		JCheckBox chckbxTel = new JCheckBox("전화번호");
		chckbxTel.setForeground(Color.RED);
		chckbxTel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(chckbxTel);
		
		tfTel = new JTextField();
		panel.add(tfTel);
		tfTel.setColumns(10);
		
		JCheckBox chckbxBirth = new JCheckBox("생년월일");
		chckbxBirth.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(chckbxBirth);
		
		tfBirth = new JTextField();
		panel.add(tfBirth);
		tfBirth.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 2, 10, 10));
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberResultUI memberresultui = new MemberResultUI();
				memberresultui.setVisible(true);
				
			}
		});
		panel_2.add(btnSearch);
		
		JButton btnUpdate = new JButton("수정");
		panel_2.add(btnUpdate);
	}
	
}

package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberInfoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public MemberInfoUI() {
		setTitle("내 정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 10, 10));

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblNewLabel = new JLabel("회원 번호");
		panel_3.add(lblNewLabel);

		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("전화번호");
		panel_3.add(lblNewLabel_1);

		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("여기엔");
		panel_3.add(lblNewLabel_2);

		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel label = new JLabel("회원 이름");
		panel_4.add(label);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_4.add(textField_3);

		JLabel label_1 = new JLabel("회원등급");
		panel_4.add(label_1);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_4.add(textField_4);

		JLabel label_2 = new JLabel("뭘넣을까");
		panel_4.add(label_2);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_4.add(textField_5);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 3, 10, 10));

		JButton btnNewButton_1 = new JButton("회원정보수정");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnNewButton_1);

		JButton btnNewButton = new JButton("도서 검색");
		panel_2.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("사엣정보");
		panel_2.add(btnNewButton_2);
	}

}

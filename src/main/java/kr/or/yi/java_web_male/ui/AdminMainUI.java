package kr.or.yi.java_web_male.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AdminMainUI extends JFrame {

	private JPanel contentPane;

	public AdminMainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));

		JButton btnNewButton_1 = new JButton("도서 관리");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("회원 관리");
		contentPane.add(btnNewButton_2);

		JButton btnNewButton = new JButton("출납 관리");
		contentPane.add(btnNewButton);
	}

}

package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTable;

public class BookAdminUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAdminUI frame = new BookAdminUI();
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
	public BookAdminUI() {
		setTitle("도서관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("도서추가");
		panel.setLayout(new GridLayout(0, 1, 10, 10));
		panel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("도서수정/삭제");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("회원관리");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("출납관리");
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 10, 10));
	}

}

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

public class BookAdminUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_3;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

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
		
		btnNewButton = new JButton("도서추가");
		btnNewButton.addActionListener(this);
		panel.setLayout(new GridLayout(0, 1, 10, 10));
		panel.add(btnNewButton);
		
		btnNewButton_3 = new JButton("도서검색");
		btnNewButton_3.addActionListener(this);
		panel.add(btnNewButton_3);
		
		btnNewButton_1 = new JButton("회원관리");
		btnNewButton_1.addActionListener(this);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("출납관리");
		btnNewButton_2.addActionListener(this);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 10, 10));
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnNewButton_3) {
			do_btnNewButton_3_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(arg0);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
	}
	protected void do_btnNewButton_3_actionPerformed(ActionEvent arg0) {
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent arg0) {
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent arg0) {
	}
}

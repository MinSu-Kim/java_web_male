package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MemberRentalInfoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textMemberNo;
	private JTextField textGrade;
	private JTextField textNowTotal;
	private JTextField textTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberRentalInfoUI frame = new MemberRentalInfoUI();
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
	public MemberRentalInfoUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblMemberNo = new JLabel("New label");
		panel.add(lblMemberNo);
		
		textMemberNo = new JTextField();
		panel.add(textMemberNo);
		textMemberNo.setColumns(10);
		
		JLabel lblGrade = new JLabel("New label");
		panel.add(lblGrade);
		
		textGrade = new JTextField();
		panel.add(textGrade);
		textGrade.setColumns(10);
		
		JLabel lblNowTotal = new JLabel("New label");
		panel.add(lblNowTotal);
		
		textNowTotal = new JTextField();
		panel.add(textNowTotal);
		textNowTotal.setColumns(10);
		
		JLabel lblTotal = new JLabel("New label");
		panel.add(lblTotal);
		
		textTotal = new JTextField();
		panel.add(textTotal);
		textTotal.setColumns(10);
	}

}

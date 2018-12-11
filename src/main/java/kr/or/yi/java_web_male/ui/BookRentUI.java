package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BookRentUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// 룩앤필 변경
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookRentUI frame = new BookRentUI();
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
	public BookRentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("도서번호");
		panel_5.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton btnNewButton = new JButton("도서검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("                                                                                   ");
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("회원번호");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		
		JButton btnNewButton_3 = new JButton("회원검색");
		panel_7.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("                                                                                   ");
		panel_7.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("대여");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnNewButton_1);
	}

}

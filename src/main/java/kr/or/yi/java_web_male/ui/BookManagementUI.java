package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookManagementUI extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JTextField tfPublisher;
	private JTextField tfAuthor;
	private JTextField tfTranslator;
	private JTextField tfPrice;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagementUI frame = new BookManagementUI();
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
	public BookManagementUI() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10));
		
		JPanel pBookNo = new JPanel();
		panel_1.add(pBookNo);
		pBookNo.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNewLabel_1 = new JLabel("도서번호");
		pBookNo.add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		pBookNo.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel pPhoto = new JPanel();
		panel_1.add(pPhoto);
		
		JLabel lblBookName = new JLabel("도서명");
		panel_1.add(lblBookName);
		
		tf = new JTextField();
		panel_1.add(tf);
		tf.setColumns(10);
		
		JLabel lblPublisher = new JLabel("출판사");
		panel_1.add(lblPublisher);
		
		tfPublisher = new JTextField();
		tfPublisher.setColumns(10);
		panel_1.add(tfPublisher);
		
		JLabel lblAuthor = new JLabel("저자");
		panel_1.add(lblAuthor);
		
		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		panel_1.add(tfAuthor);
		
		JLabel lblTranslator = new JLabel("역자");
		panel_1.add(lblTranslator);
		
		tfTranslator = new JTextField();
		tfTranslator.setColumns(10);
		panel_1.add(tfTranslator);
		
		JLabel lblPrice = new JLabel("가격");
		panel_1.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		panel_1.add(tfPrice);
		
		JButton btnOk = new JButton("추가");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfAuthor.getText().trim();
				tfTranslator.getText().trim();
				tfPublisher.getText().trim();
			}
		});
		panel_1.add(btnOk);
		
		JButton btnCancel = new JButton("취소");
		panel_1.add(btnCancel);
	}

}

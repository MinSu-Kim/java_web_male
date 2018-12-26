package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.service.LibraryUIService;
import kr.or.yi.java_web_male.service.MemberUIService;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class BookReturnUI extends JFrame {

	private JPanel contentPane;
	private JTextField textBookCode;
	private BookRentalInfo bookRentalInfo;
	private Book book;
	private LibraryUIService service;
	private MemberUIService memberUIService;

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
					BookReturnUI frame = new BookReturnUI();
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
	public BookReturnUI() {
		setTitle("도서 반납");
		service = new LibraryUIService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblBookCode = new JLabel("도서번호");
		lblBookCode.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblBookCode);
		
		textBookCode = new JTextField();
		panel_2.add(textBookCode);
		textBookCode.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 120));
		
		/*---------------------------------반납버튼 기능--------------------------------*/
		JButton btnNewButton = new JButton("반납");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//book_code
				Book book = new Book();
				book.setBookCode(textBookCode.getText());
				
				String bookcode = String.valueOf(book);
				Book books = new Book();
				books.setBookCode(bookcode);
				BookRentalInfo BookRentalInfo = new BookRentalInfo();
				BookRentalInfo.setBookCode(books);
				
				BookRentalInfo BookRentalNo = service.selectRentalNoByBookCode(BookRentalInfo);
				JOptionPane.showMessageDialog(null, BookRentalNo);
			}
		});
		panel_3.add(btnNewButton);
	}
	
	

}

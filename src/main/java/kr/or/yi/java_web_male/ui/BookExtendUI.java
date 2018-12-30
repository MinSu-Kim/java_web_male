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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class BookExtendUI extends JFrame {

	private JPanel contentPane;
	private InOutUI inOutUI;
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
					BookExtendUI frame = new BookExtendUI();
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
	public BookExtendUI() {
		setTitle("연장");
		
		service = new LibraryUIService();
		memberUIService = new MemberUIService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblBookCode = new JLabel("도서번호");
		lblBookCode.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblBookCode);
		
		textBookCode = new JTextField();
		textBookCode.setColumns(10);
		panel_1.add(textBookCode);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 120));
		
		JButton button = new JButton("연장");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//book_code
				Book book = new Book();
				book.setBookCode(textBookCode.getText());
				
				//book_code로 rental_no찾기
				BookRentalInfo BookRentalInfo = new BookRentalInfo();
				BookRentalInfo.setBookCode(book);
				System.out.println(BookRentalInfo.getBookCode());
				
				BookRentalInfo BookRentalNo = service.selectRentalNoByBookCode_returnDateNull(BookRentalInfo);
				
				
				
				int no = BookRentalNo.getRentalNo();
				
				BookRentalInfo bookRentalInfo = new BookRentalInfo();
				bookRentalInfo.setRentalNo(no);
				
				Date returnSchedule = BookRentalNo.getReturnSchedule();
				
				Calendar cal = Calendar.getInstance ( );
				cal.setTime(returnSchedule);
				cal.add ( Calendar.DATE, 7); 
				JOptionPane.showMessageDialog(null, cal);
				System.out.println( cal.get ( Calendar.YEAR ) + "년 " + ( cal.get ( Calendar.MONTH ) + 1 ) + "월 " + cal.get ( Calendar.DATE ) + "일" );
			
			
				Date d = new Date(cal.getTimeInMillis());
				
				bookRentalInfo.setReturnSchedule(d);
				
				service.updateReturnSchedule(bookRentalInfo);
			}
		});
		panel_4.add(button);
	}
	
	public void setInOutUI(InOutUI inOutUI) {
		this.inOutUI = inOutUI;
	}

}

package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.Overdue;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BookExtendUI extends JFrame {

	private JPanel contentPane;
	private InOutUI inOutUI;
	private JTextField textBookCode;
	private BookRentalInfo bookRentalInfo;
	private Book book;
	private LibraryUIService service;
	private MemberUIService memberUIService;
	private JTextField textReturnSchedule;

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
		bookRentalInfo = new BookRentalInfo();
		service = new LibraryUIService();
		memberUIService = new MemberUIService();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 118);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 424, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBookCode = new JLabel("도서번호");
		lblBookCode.setBounds(0, 0, 141, 50);
		lblBookCode.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBookCode.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblBookCode);
		
		textBookCode = new JTextField();
		textBookCode.setBounds(141, 0, 141, 50);
		textBookCode.setColumns(10);
		panel_1.add(textBookCode);
		
		JLabel label = new JLabel("");
		label.setBounds(282, 0, 141, 50);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 62, 424, 50);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblReturnSchedule = new JLabel("반납 예정일");
		lblReturnSchedule.setBounds(0, 0, 141, 50);
		lblReturnSchedule.setFont(new Font("Dialog", Font.BOLD, 16));
		lblReturnSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblReturnSchedule);
		
		textReturnSchedule = new JTextField();
		textReturnSchedule.setBounds(141, 0, 141, 50);
		textReturnSchedule.setEnabled(false);
		panel_2.add(textReturnSchedule);
		textReturnSchedule.setColumns(10);
		
		JButton btnReturnSchedule = new JButton("기존 예정일 검색");
		btnReturnSchedule.setBounds(282, 0, 141, 50);
		btnReturnSchedule.setFont(new Font("Dialog", Font.BOLD, 12));
		btnReturnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getBookRentalInfo(bookRentalInfo);
			}
		});
		panel_2.add(btnReturnSchedule);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(5, 121, 424, 196);
		contentPane.add(panel_4);
		
		
		
		JButton button = new JButton("연장");
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		button.setBounds(169, 18, 91, 53);
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
		panel_4.setLayout(null);
		panel_4.add(button);
	}
	
	public void getBookRentalInfo(BookRentalInfo bookRentalInfo) {
		Book book = new Book();
		book.setBookCode(textBookCode.getText());
		
		BookRentalInfo bookRentalInfo1 = new BookRentalInfo();
		bookRentalInfo1.setBookCode(book);
		
		BookRentalInfo no = service.selectRentalNoByBookCode_returnDateNull(bookRentalInfo1);
		bookRentalInfo1.setRentalNo(no.getRentalNo());
		
		BookRentalInfo rentalInfo = service.selectBookRentalInfoByCode(no);
		
		Date scheduleDate = rentalInfo.getReturnSchedule();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(scheduleDate);
		textReturnSchedule.setText(sdf.format(scheduleDate));
		
		
		
		
	}
	
	public void setInOutUI(InOutUI inOutUI) {
		this.inOutUI = inOutUI;
	}
}

package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.MemberRentalInfo;
import kr.or.yi.java_web_male.dto.Overdue;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;

public class BookReturnUI extends JFrame {

	private JPanel contentPane;
	private JTextField textBookCode;
	private BookRentalInfo bookRentalInfo;
	private Book book;
	private LibraryUIService service;
	private MemberUIService memberUIService;
	private InOutUI inOutUI;

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
		memberUIService = new MemberUIService();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 424, 50);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblBookCode = new JLabel("도서번호");
		lblBookCode.setBounds(0, 0, 212, 50);
		lblBookCode.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBookCode.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblBookCode);
		
		textBookCode = new JTextField();
		textBookCode.setBounds(212, 0, 212, 50);
		panel_2.add(textBookCode);
		textBookCode.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(5, 56, 424, 261);
		contentPane.add(panel_3);
		
		/*---------------------------------반납버튼 기능--------------------------------*/
		JButton btnNewButton = new JButton("반납");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.setBounds(168, 17, 97, 52);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//book_code
				Book book = new Book();
				book.setBookCode(textBookCode.getText());
				
				//book_code로 rental_no찾기
				BookRentalInfo BookRentalInfo = new BookRentalInfo();
				BookRentalInfo.setBookCode(book);
				
				BookRentalInfo BookRentalNo = service.selectRentalNoByBookCode_returnDateNull(BookRentalInfo);
				
				
				int no = BookRentalNo.getRentalNo();
				
				Date returndate = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.format(returndate);
				
				
				
				//rental_no로 return_date 수정
				BookRentalInfo bookRentalInfo = new BookRentalInfo();
				bookRentalInfo.setRentalNo(no);
				bookRentalInfo.setReturnDate(returndate);
				
				
				
				int returnUpdate = service.updateReturnDate(bookRentalInfo);
				
				//대여가능권수 +1
				String mNo = String.valueOf(BookRentalNo.getMemberNo());
				
				MemberRentalInfo memberRentalInfo = new MemberRentalInfo();
				memberRentalInfo.setMemberNo(mNo);
				
				int updateNowTotal = memberUIService.updateMemberRentalInfo2(memberRentalInfo);
				
				
				//반납한 책의 대여가능여부 변경
				 book.setRentalPossible(true);
				 int updatePossible = service.updateBookPossible(book);
				
				Date returnDate = bookRentalInfo.getReturnDate();
				Date returnSchedule = BookRentalNo.getReturnSchedule();
				
				//정지일수 계산
				Date date = new Date();
				Calendar cal = Calendar.getInstance ( );
				// 오늘날짜
				cal.setTime ( date );
				
				Calendar cal2 = Calendar.getInstance ( );
				// 반납예정일
				cal2.setTime ( returnSchedule );  
				
				int count = 0;
				while ( !cal2.after ( cal ) ) {
				count++;
				//다음날로 바뀜
				cal2.add ( Calendar.DATE, 1 );   
				System.out.println ( cal2.get ( Calendar.YEAR ) + "년 " + ( cal2.get ( Calendar.MONTH ) + 1 ) + "월 " + cal2.get ( Calendar.DATE ) + "일" );
				}
				System.out.println ( "연체일은 " + count + "일 입니다." );
				
				
				
				
				
				
				Overdue overdue = new Overdue();
				overdue.setMemberNo(mNo);
				
				Overdue stopdate = memberUIService.selectOverdueByCode(overdue);
				overdue.setStopDate(stopdate.getStopDate()+count);
				overdue.setOverdueCount(stopdate.getOverdueCount()+count);
				
				

				//정지 종료일 계산
				Date today = new Date();
				Calendar cal3 = Calendar.getInstance ( );
				cal3.setTime(today);
				cal3.add ( Calendar.DATE, stopdate.getStopDate()+count ); 
				JOptionPane.showMessageDialog(null, cal3);
				System.out.println( cal3.get ( Calendar.YEAR ) + "년 " + ( cal3.get ( Calendar.MONTH ) + 1 ) + "월 " + cal3.get ( Calendar.DATE ) + "일" );
			
			
				Date d = new Date(cal3.getTimeInMillis());
				
				
				
				int updateCount = memberUIService.updateCount(overdue);
				int updateDate = memberUIService.updateStopDate(overdue);
				if(overdue.getStopDate() > 0) {
					overdue.setStopEndDate(d);
				}else {
					overdue.setStopEndDate(new Date());
				}
				
				int updateStopEndDate = memberUIService.updateStopEndDate(overdue);
				
				//정지일수가 1일이라도 있거나 연체횟수 100넘으면 대여권한 박탈
				if(overdue.getStopDate() > 0 || overdue.getOverdueCount() > 100) {
					overdue.setRentalAuthority(false);
				}else {
					overdue.setRentalAuthority(true);
				}
				
				int updateAuthority = memberUIService.updateAuthority(overdue);
				JOptionPane.showMessageDialog(null, "반납완료"+count+"일 연체되셨습니다.");
				
				
			}
		});
		panel_3.setLayout(null);
		panel_3.add(btnNewButton);
	}
	
	public void setInOutUI(InOutUI inOutUI) {
		this.inOutUI = inOutUI;
	}

}

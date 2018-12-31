package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dao.BookRentalInfoMapper;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapperImpl;
import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.MemberRentalInfo;
import kr.or.yi.java_web_male.dto.Overdue;
import kr.or.yi.java_web_male.service.LibraryUIService;
import kr.or.yi.java_web_male.service.MemberUIService;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Dimension;
import java.awt.Font;

public class BookRentUI extends JFrame {

	private JPanel contentPane;
	private JTextField textBookCode;
	private JTextField textMemberNo;
	private JButton btnBookSearch;
	private BookRentalInfoMapper bookRentalInfoMapper;
	private BookRentalInfoMapperImpl bookRentalInfoMapperImpl;
	private BookRentalInfo bookRentalInfo;
	private Book book;
	private InOutUI inOutUI;
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
		setTitle("도서 대여");
		service = new LibraryUIService();
		memberUIService = new MemberUIService();
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 486, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel container1 = new JPanel();
		container1.setBounds(5, 5, 470, 107);
		contentPane.add(container1);
		container1.setLayout(null);
														
																JPanel bookCodePanel = new JPanel();
																bookCodePanel.setBounds(0, 0, 470, 51);
																container1.add(bookCodePanel);
																bookCodePanel.setLayout(null);
																
																		JLabel lblBookCode = new JLabel("도서번호");
																		lblBookCode.setFont(new Font("Dialog", Font.BOLD, 16));
																		lblBookCode.setBounds(0, 0, 157, 50);
																		bookCodePanel.add(lblBookCode);
																		lblBookCode.setHorizontalAlignment(SwingConstants.CENTER);
																		
																				textBookCode = new JTextField();
																				textBookCode.setBounds(157, 0, 156, 50);
																				bookCodePanel.add(textBookCode);
																				textBookCode.setColumns(10);
																				
																						btnBookSearch = new JButton("도서검색");
																						btnBookSearch.setFont(new Font("Dialog", Font.BOLD, 16));
																						btnBookSearch.setBounds(313, 0, 156, 50);
																						bookCodePanel.add(btnBookSearch);
																																
																																		JPanel memberNoPanel = new JPanel();
																																		memberNoPanel.setBounds(0, 53, 470, 51);
																																		container1.add(memberNoPanel);
																																		memberNoPanel.setLayout(null);
																																		
																																				JLabel lblMemberNo = new JLabel("회원번호");
																																				lblMemberNo.setFont(new Font("Dialog", Font.BOLD, 16));
																																				lblMemberNo.setBounds(1, 0, 156, 50);
																																				lblMemberNo.setHorizontalAlignment(SwingConstants.CENTER);
																																				memberNoPanel.add(lblMemberNo);
																																				
																																						textMemberNo = new JTextField();
																																						textMemberNo.setBounds(157, 0, 156, 50);
																																						memberNoPanel.add(textMemberNo);
																																						textMemberNo.setColumns(10);
																																						
																																								JButton btnMemberSearch = new JButton("회원검색");
																																								btnMemberSearch.setFont(new Font("Dialog", Font.BOLD, 16));
																																								btnMemberSearch.setBounds(313, 0, 156, 50);
																																								memberNoPanel.add(btnMemberSearch);
																																btnMemberSearch.addActionListener(new ActionListener() {
																																	public void actionPerformed(ActionEvent e) {
																																		MemberSearchUI msu = new MemberSearchUI();
																																		msu.setBookRentUI(BookRentUI.this);
																																		msu.setVisible(true);

																																	}
																																});
																						btnBookSearch.addActionListener(new ActionListener() {
																							public void actionPerformed(ActionEvent e) {
																								BookSearchUI bsu = new BookSearchUI();
																								bsu.setBookRentUI(BookRentUI.this);
																								bsu.setVisible(true);
																							}
																						});

		JPanel container2 = new JPanel();
		container2.setBounds(5, 123, 470, 63);
		contentPane.add(container2);

		/*-------------------------------------------대여버튼 기능-------------------------------------------*/
		JButton btnRent = new JButton("대여");
		btnRent.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRent.setBounds(178, 6, 105, 52);
		btnRent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// rental_no
				int nextRentalCode = service.nextCode();

				// rental_Date
				Date rentalsDate = new Date();
				SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd");
				sdfr.format(rentalsDate);

				// return_schedule
				Date rentalDate = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.format(rentalDate);
				rentalDate.setDate(rentalDate.getDate() + 7);

				// book_code
				Book book = new Book();
				book.setBookCode(textBookCode.getText());

				// member_no
				Member member = new Member();
				member.setMemberNo(textMemberNo.getText());

				// Member memberNo => memberRentalInfo memberNo로 형변환
				String mNo = String.valueOf(member);

				MemberRentalInfo memberRentalInfo = new MemberRentalInfo();
				memberRentalInfo.setMemberNo(mNo);

				// 대여가능권수가 0미만일때 대여불가
				MemberRentalInfo searchNowTotal = memberUIService.selectMemberNowTotalByCode(memberRentalInfo);
				if (searchNowTotal.getNowTotal() < 0) {
					JOptionPane.showMessageDialog(null, "대여가능한 권수를 초과하였습니다.");
					return;
				}

				/*------------------insert BookRentalInfo 대여정보 추가-----------------*/
				BookRentalInfo bookRentalInfo = new BookRentalInfo();
				bookRentalInfo.setRentalNo(nextRentalCode);
				bookRentalInfo.setRentalDate(rentalsDate);
				bookRentalInfo.setReturnDate(null);
				bookRentalInfo.setReturnSchedule(rentalDate);
				bookRentalInfo.setBookCode(book);
				bookRentalInfo.setMemberNo(member);

				int bookRentalInfo1 = service.insertBookRentalInfo(bookRentalInfo);
				/*-------------------------------------------------------------------*/

				// 대여한 책의 대여가능여부 변경
				book.setRentalPossible(false);
				int updatePossible = service.updateBookPossible(book);

				// 회원대여정보의 대여가능권수-1, 총대여권수+1 변경
				int updateRentalInfo = memberUIService.updateMemberRentalInfo(memberRentalInfo);

				// 등급변경
				MemberRentalInfo searchTotal = memberUIService.selectMemberTotalByCode(memberRentalInfo);
				if (searchTotal.getTotal() == 100) {
					memberUIService.updateMemberRentalInfoGrade(memberRentalInfo);
					JOptionPane.showMessageDialog(null, "등급이 []로 변경되었습니다.");
				} else if (searchTotal.getTotal() == 500) {
					memberUIService.updateMemberRentalInfoGrade(memberRentalInfo);
					JOptionPane.showMessageDialog(null, "등급이 []로 변경되었습니다.");
				} else if (searchTotal.getTotal() == 1000) {
					memberUIService.updateMemberRentalInfoGrade(memberRentalInfo);
					JOptionPane.showMessageDialog(null, "등급이 []로 변경되었습니다.");
				} else if (searchTotal.getTotal() == 5000) {
					memberUIService.updateMemberRentalInfoGrade(memberRentalInfo);
					JOptionPane.showMessageDialog(null, "등급이 []로 변경되었습니다.");
				}

				JOptionPane.showMessageDialog(null, "대여에 성공하셨습니다. 반납일을 잘 지켜주세요.");
				// 텍스트필드 비우기
				clearTf();
			}
		});

		/*------------------------------------------대여버튼 기능 끝---------------------------------------------*/
		container2.setLayout(null);

		container2.add(btnRent);
	}

	private void clearTf() {
		textBookCode.setText("");
		textMemberNo.setText("");
	}

	public void setBookCode(Book book) {
		this.textBookCode.setText(book.getBookCode());
		textBookCode.requestFocus();
	}

	public void setMemberNo(Member member) {
		this.textMemberNo.setText(member.getMemberNo());
		textMemberNo.requestFocus();
	}

	public void setInOutUI(InOutUI inOutUI) {
		this.inOutUI = inOutUI;
	}

}

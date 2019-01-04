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
	private AdminMainUI adminMainUI;
	private LibraryUIService service;
	private MemberUIService memberUIService;
	private JTextField textbookCode2;
	private JTextField textbookCode3;
	private JPanel bookCodePanel;
	private JPanel bookCode2Panel;
	private JPanel bookCode3Panel;

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

		setBounds(100, 100, 502, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel container1 = new JPanel();
		container1.setBounds(5, 5, 470, 212);
		contentPane.add(container1);
		container1.setLayout(null);

		JPanel memberNoPanel = new JPanel();
		memberNoPanel.setBounds(0, 0, 470, 51);
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
		bookCodePanel = new JPanel();
		bookCodePanel.setVisible(false);
		bookCodePanel.setBounds(0, 50, 470, 51);
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
		
		bookCode2Panel = new JPanel();
		bookCode2Panel.setVisible(false);
		bookCode2Panel.setLayout(null);
		bookCode2Panel.setBounds(0, 101, 470, 51);
		container1.add(bookCode2Panel);
		
		JLabel lblbookCode2 = new JLabel("도서번호");
		lblbookCode2.setHorizontalAlignment(SwingConstants.CENTER);
		lblbookCode2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblbookCode2.setBounds(0, 0, 157, 50);
		bookCode2Panel.add(lblbookCode2);
		
		textbookCode2 = new JTextField();
		textbookCode2.setColumns(10);
		textbookCode2.setBounds(157, 0, 156, 50);
		bookCode2Panel.add(textbookCode2);
		
		JButton btnBookSearch2 = new JButton("도서검색");
		btnBookSearch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSearchUI bsu = new BookSearchUI();
				bsu.setBookRentUI(BookRentUI.this);
				
				bsu.SetBookCoded(textbookCode2.getText());
				bsu.whatClick(2);
				bsu.setVisible(true);
				
			}
		});
		btnBookSearch2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnBookSearch2.setBounds(313, 0, 156, 50);
		bookCode2Panel.add(btnBookSearch2);
		
		bookCode3Panel = new JPanel();
		bookCode3Panel.setVisible(false);
		bookCode3Panel.setLayout(null);
		bookCode3Panel.setBounds(0, 151, 470, 51);
		container1.add(bookCode3Panel);
		
		JLabel lblbookCode3 = new JLabel("도서번호");
		lblbookCode3.setHorizontalAlignment(SwingConstants.CENTER);
		lblbookCode3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblbookCode3.setBounds(0, 0, 157, 50);
		bookCode3Panel.add(lblbookCode3);
		
		textbookCode3 = new JTextField();
		textbookCode3.setColumns(10);
		textbookCode3.setBounds(157, 0, 156, 50);
		bookCode3Panel.add(textbookCode3);
		
		JButton btnBookSearch3 = new JButton("도서검색");
		btnBookSearch3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSearchUI bsu = new BookSearchUI();
				bsu.setBookRentUI(BookRentUI.this);
				bsu.SetBookCoded(textbookCode3.getText());
				bsu.whatClick(3);
				bsu.setVisible(true);
				
			}
		});
		btnBookSearch3.setFont(new Font("Dialog", Font.BOLD, 16));
		btnBookSearch3.setBounds(313, 0, 156, 50);
		bookCode3Panel.add(btnBookSearch3);
		btnBookSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSearchUI bsu = new BookSearchUI();
				bsu.setBookRentUI(BookRentUI.this);
				bsu.SetBookCoded(textBookCode.getText());
				bsu.whatClick(1);
				bsu.setVisible(true);
			}
		});
		btnMemberSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberSearchUI msu = new MemberSearchUI();
				msu.setBookRentUI(BookRentUI.this);
				msu.setMemberCode(textMemberNo.getText());
				msu.setVisible(true);
				clearTf();
				bookCodePanel.setVisible(false);
				bookCode2Panel.setVisible(false);
				bookCode3Panel.setVisible(false);
				
				

			}
		});

		JPanel container2 = new JPanel();
		container2.setBounds(5, 236, 470, 63);
		contentPane.add(container2);

		/*-------------------------------------------대여버튼 기능-------------------------------------------*/
		JButton btnRent = new JButton("대여");
		btnRent.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRent.setBounds(187, 6, 105, 52);
		btnRent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					
					
					try {
						
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

						
						// member_no
						Member member = new Member();
						member.setMemberNo(textMemberNo.getText());

						// Member memberNo => memberRentalInfo memberNo로 형변환
						String mNo = String.valueOf(member);

						MemberRentalInfo memberRentalInfo = new MemberRentalInfo();
						memberRentalInfo.setMemberNo(mNo);
						
						
						// book_code
						Book book = new Book();
						book.setBookCode(textBookCode.getText());
						
						
						// 대여가능권수가 0미만일때 대여불가
						MemberRentalInfo searchNowTotal = memberUIService.selectMemberNowTotalByCode(memberRentalInfo);
						if (searchNowTotal.getNowTotal() < 1) {
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
						
						MemberRentalInfo searchNowTotal2 = memberUIService.selectMemberNowTotalByCode(memberRentalInfo);
						if(searchNowTotal2.getNowTotal() == 0) {
							Overdue overdue = new Overdue();
							overdue.setMemberNo(mNo);
							overdue.setRentalAuthority(false);
							memberUIService.updateAuthority(overdue);
							
							// 텍스트필드 비우기
							clearTf();
						}
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
					try {
						
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

						
						// member_no
						Member member = new Member();
						member.setMemberNo(textMemberNo.getText());

						// Member memberNo => memberRentalInfo memberNo로 형변환
						String mNo = String.valueOf(member);

						MemberRentalInfo memberRentalInfo = new MemberRentalInfo();
						memberRentalInfo.setMemberNo(mNo);
						
						
						Book book2 = new Book();
						book2.setBookCode(textbookCode2.getText());
						
						
						// 대여가능권수가 0미만일때 대여불가
						MemberRentalInfo searchNowTotal = memberUIService.selectMemberNowTotalByCode(memberRentalInfo);
						if (searchNowTotal.getNowTotal() < 1) {
							/*JOptionPane.showMessageDialog(null, "대여가능한 권수를 초과하였습니다.");*/
							return;
						}

						/*------------------insert BookRentalInfo 대여정보 추가-----------------*/
						BookRentalInfo bookRentalInfo = new BookRentalInfo();
						bookRentalInfo.setRentalNo(nextRentalCode);
						bookRentalInfo.setRentalDate(rentalsDate);
						bookRentalInfo.setReturnDate(null);
						bookRentalInfo.setReturnSchedule(rentalDate);
						bookRentalInfo.setBookCode(book2);
						bookRentalInfo.setMemberNo(member);

						int bookRentalInfo1 = service.insertBookRentalInfo(bookRentalInfo);
						/*-------------------------------------------------------------------*/

						// 대여한 책의 대여가능여부 변경
						book2.setRentalPossible(false);
						int updatePossible = service.updateBookPossible(book2);

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
						
						MemberRentalInfo searchNowTotal2 = memberUIService.selectMemberNowTotalByCode(memberRentalInfo);
						if(searchNowTotal2.getNowTotal() == 0) {
							Overdue overdue = new Overdue();
							overdue.setMemberNo(mNo);
							overdue.setRentalAuthority(false);
							memberUIService.updateAuthority(overdue);
							
							// 텍스트필드 비우기
							clearTf();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
					
					try {
						
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

						
						// member_no
						Member member = new Member();
						member.setMemberNo(textMemberNo.getText());

						// Member memberNo => memberRentalInfo memberNo로 형변환
						String mNo = String.valueOf(member);

						MemberRentalInfo memberRentalInfo = new MemberRentalInfo();
						memberRentalInfo.setMemberNo(mNo);
						
						
						
						Book book3 = new Book();
						book3.setBookCode(textbookCode3.getText());
						
						
						// 대여가능권수가 0미만일때 대여불가
						MemberRentalInfo searchNowTotal = memberUIService.selectMemberNowTotalByCode(memberRentalInfo);
						if (searchNowTotal.getNowTotal() < 1) {
							/*JOptionPane.showMessageDialog(null, "대여가능한 권수를 초과하였습니다.");*/
							return;
						}

						/*------------------insert BookRentalInfo 대여정보 추가-----------------*/
						BookRentalInfo bookRentalInfo = new BookRentalInfo();
						bookRentalInfo.setRentalNo(nextRentalCode);
						bookRentalInfo.setRentalDate(rentalsDate);
						bookRentalInfo.setReturnDate(null);
						bookRentalInfo.setReturnSchedule(rentalDate);
						bookRentalInfo.setBookCode(book3);
						bookRentalInfo.setMemberNo(member);

						int bookRentalInfo1 = service.insertBookRentalInfo(bookRentalInfo);
						/*-------------------------------------------------------------------*/

						// 대여한 책의 대여가능여부 변경
						book3.setRentalPossible(false);
						int updatePossible = service.updateBookPossible(book3);

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
						
						MemberRentalInfo searchNowTotal2 = memberUIService.selectMemberNowTotalByCode(memberRentalInfo);
						if(searchNowTotal2.getNowTotal() == 0) {
							Overdue overdue = new Overdue();
							overdue.setMemberNo(mNo);
							overdue.setRentalAuthority(false);
							memberUIService.updateAuthority(overdue);
							
							
							// 텍스트필드 비우기
							clearTf();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
					



					JOptionPane.showMessageDialog(null, "대여에 성공하셨습니다");
					// 텍스트필드 비우기
					clearTf();
					bookCodePanel.setVisible(false);
					bookCode2Panel.setVisible(false);
					bookCode3Panel.setVisible(false);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "도서번호와 회원번호를 다시 확인해 주세요");
				}

			}
		});

		/*------------------------------------------대여버튼 기능 끝---------------------------------------------*/
		container2.setLayout(null);

		container2.add(btnRent);
		
		
	}

	private void clearTf() {
		textBookCode.setText("");
		textbookCode2.setText("");
		textbookCode3.setText("");
		textMemberNo.setText("");
	}

	public void setBookCode(Book book) {
		this.textBookCode.setText(book.getBookCode());
		textBookCode.requestFocus();
	}
	public void setBookCod2(Book book) {
		this.textbookCode2.setText(book.getBookCode());
		textbookCode2.requestFocus();
	}
	public void setBookCod3(Book book) {
		this.textbookCode3.setText(book.getBookCode());
		textbookCode3.requestFocus();
	}

	public void setMemberNo(Member member) {
		this.textMemberNo.setText(member.getMemberNo());
		textMemberNo.requestFocus();
		
	}

	public void setAdminMainUI(AdminMainUI adminMainUI) {
		this.adminMainUI = adminMainUI;
	}

	public void setText() {
		try {
			Member member = new Member();
			member.setMemberNo(textMemberNo.getText());

			// Member memberNo => memberRentalInfo memberNo로 형변환
			String mNo = String.valueOf(member);

			MemberRentalInfo memberRentalInfo = new MemberRentalInfo();
			memberRentalInfo.setMemberNo(mNo);
			
			MemberRentalInfo searchNowTotal = memberUIService.selectMemberNowTotalByCode(memberRentalInfo);
			if(searchNowTotal.getNowTotal() == 0) {
				bookCodePanel.setVisible(false);
				bookCode2Panel.setVisible(false);
				bookCode3Panel.setVisible(false);
			}
			if(searchNowTotal.getNowTotal() == 1) {
				bookCodePanel.setVisible(true);
				bookCode2Panel.setVisible(false);
				bookCode3Panel.setVisible(false);
			}
			if(searchNowTotal.getNowTotal() == 2) {
				bookCodePanel.setVisible(true);
				bookCode2Panel.setVisible(true);
				bookCode3Panel.setVisible(false);
			}
			if(searchNowTotal.getNowTotal() == 3) {
				bookCodePanel.setVisible(true);
				bookCode2Panel.setVisible(true);
				bookCode3Panel.setVisible(true);
			}
		} catch (Exception e1) {
			// TODO: handle exception
		}
		
	}
}

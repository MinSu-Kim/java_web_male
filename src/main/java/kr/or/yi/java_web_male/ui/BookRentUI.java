package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.Member;

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
	private JTextField textBookCode;
	private JTextField textMemberNo;
	private JButton btnBookSearch;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel container1 = new JPanel();
		contentPane.add(container1);
		container1.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel bookPanel = new JPanel();
		container1.add(bookPanel);
		bookPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel bookCodePanel = new JPanel();
		bookPanel.add(bookCodePanel);
		bookCodePanel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblBookCode = new JLabel("도서번호");
		bookCodePanel.add(lblBookCode);
		lblBookCode.setHorizontalAlignment(SwingConstants.CENTER);

		textBookCode = new JTextField();
		bookCodePanel.add(textBookCode);
		textBookCode.setColumns(10);

		JPanel bookSearchPanel = new JPanel();
		bookPanel.add(bookSearchPanel);

		btnBookSearch = new JButton("도서검색");
		btnBookSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSearchUI bsu = new BookSearchUI();
				bsu.setBookRentUI(BookRentUI.this);
				bsu.setVisible(true);
			}
		});
		bookSearchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		bookSearchPanel.add(btnBookSearch);

		JLabel lblSpace1 = new JLabel(
				"                                                                                                                           ");
		bookSearchPanel.add(lblSpace1);

		JPanel memberPanel = new JPanel();
		container1.add(memberPanel);
		memberPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel memberNoPanel = new JPanel();
		memberPanel.add(memberNoPanel);
		memberNoPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblMemberNo = new JLabel("회원번호");
		lblMemberNo.setHorizontalAlignment(SwingConstants.CENTER);
		memberNoPanel.add(lblMemberNo);

		textMemberNo = new JTextField();
		memberNoPanel.add(textMemberNo);
		textMemberNo.setColumns(10);

		JPanel memberSearchPanel = new JPanel();
		memberPanel.add(memberSearchPanel);

		JButton btnMemberSearch = new JButton("회원검색");
		btnMemberSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberSearchUI msu = new MemberSearchUI();
				msu.setBookRentUI(BookRentUI.this);
				msu.setVisible(true);
				
			}
		});
		memberSearchPanel.add(btnMemberSearch);

		JLabel lblSpace2 = new JLabel(
				"                                                                                                                           ");
		memberSearchPanel.add(lblSpace2);

		JPanel container2 = new JPanel();
		contentPane.add(container2, BorderLayout.SOUTH);

		JButton btnRent = new JButton("대여");
		btnRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		container2.add(btnRent);
	}

	public void setBookCode(Book book) {
		this.textBookCode.setText(book.getBookCode());
		textBookCode.requestFocus();
	}

	public void setMemberNo(Member member) {
		this.textMemberNo.setText(member.getMemberNo());
		textMemberNo.requestFocus();
	}

}
package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.Publisher;
import kr.or.yi.java_web_male.service.LibraryUIService;


import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;

public class BookDetailUI extends JFrame {

	private JPanel contentPane;
	private JLabel showbookCode;
	private JLabel showpubname;
	private JLabel showauthor;
	private JLabel showtranslator;
	private JLabel showrentalPossible;
	private JLabel showprice;
	private JLabel showtotal;
	private JLabel showcategory;
	private JLabel showtitle;
	private LibraryUIService service;
	private String imgPath;
	private JPanel tablePanel;
	private JLabel labelForImg;
	private BookDetailTablePanel forTable;
	private List<BookRentalInfo> lists;
	private List<Book> listBook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookDetailUI frame = new BookDetailUI();
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
	public BookDetailUI() {
		imgPath = System.getProperty("user.dir") + "\\images\\";
		service = new LibraryUIService();
		setTitle("도서 상세정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblbookCode = new JLabel("번호 : ");
		lblbookCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblbookCode);

		showbookCode = new JLabel("");
		panel_4.add(showbookCode);

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 10, 0));

		JLabel lbltitle = new JLabel("제목 : ");
		lbltitle.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lbltitle);

		showtitle = new JLabel("");
		panel_5.add(showtitle);

		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblpubName = new JLabel("출판사 : ");
		lblpubName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblpubName);

		showpubname = new JLabel("");
		panel_6.add(showpubname);

		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblauthor = new JLabel("저자 : ");
		lblauthor.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_7.add(lblauthor);

		showauthor = new JLabel("");
		panel_7.add(showauthor);

		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lbltranslator = new JLabel("역자 : ");
		lbltranslator.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_8.add(lbltranslator);

		showtranslator = new JLabel("");
		panel_8.add(showtranslator);

		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblrentalPossible = new JLabel("대여 가능여부 : ");
		lblrentalPossible.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblrentalPossible);

		showrentalPossible = new JLabel("");
		panel_9.add(showrentalPossible);

		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10);
		panel_10.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblprice = new JLabel("가격 : ");
		lblprice.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_10.add(lblprice);

		showprice = new JLabel("");
		panel_10.add(showprice);

		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblcategory = new JLabel("장르 : ");
		lblcategory.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_11.add(lblcategory);

		showcategory = new JLabel("");
		panel_11.add(showcategory);

		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12);
		panel_12.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lbltotal = new JLabel("보유 갯수 : ");
		lbltotal.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_12.add(lbltotal);

		showtotal = new JLabel("");
		panel_12.add(showtotal);

		JLabel label = new JLabel("");
		panel.add(label);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JButton btnbookRentalInfo = new JButton("대여 정보보기");
		btnbookRentalInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Book> listsBooks = null;
				for(Book book : listBook ) {
					listsBooks.add(book);
				}
				/*lists = new ArrayList<>();*/
				Book book = new Book();
				book.setBookCode(showbookCode.getText());
				lists = service.selectBookRentalInfoByBookCode(book);			
				((BookDetailTablePanel) tablePanel).setLists(lists);				
				((BookDetailTablePanel) tablePanel).loadDatas();

			}
		});
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		panel_3.add(btnbookRentalInfo, BorderLayout.SOUTH);

		JPanel panelForImg = new JPanel();
		panel_3.add(panelForImg, BorderLayout.CENTER);

		labelForImg = new JLabel("");
		panelForImg.add(labelForImg);
		labelForImg.setIcon(new ImageIcon(imgPath + "book1.jpg"));
		contentPane.add(panel);
		tablePanel = new JPanel();
		tablePanel = new BookDetailTablePanel();
		contentPane.add(tablePanel);
		

		if (true) {
		}

	}

	public void setBookInfo(Book book, int totalBook, List<Book> lists) {
		this.listBook = lists;
		showbookCode.setText(book.getBookCode());
		showtitle.setText(book.getTitle());
		Publisher pub = new Publisher();
		pub = service.selectPublisherByNo(book.getPubNo());
		showpubname.setText(pub.getPubName());
		showauthor.setText(book.getAuthor());
		showtranslator.setText(book.getTranslator());
		String RentalPossible = "불가능";
		if (book.isRentalPossible()) {
			RentalPossible = "가능";
		}
		showrentalPossible.setText(RentalPossible);
		showprice.setText((book.getPrice() + "").trim());
		CategoryS cate = new CategoryS();
		cate.setAllCode(book.getCateSNo().getsCode(), book.getCateMNo(), book.getCateBNo());
		cate = service.selectCategoryAllCode(cate);
		showcategory.setText(cate.getsName());
		showtotal.setText((totalBook + "").trim());
		if (book.getImage() != null) {
			labelForImg.setIcon(new ImageIcon(imgPath + book.getImage()));
		}
		
	}



	

}

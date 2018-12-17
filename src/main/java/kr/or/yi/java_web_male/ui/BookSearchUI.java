package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.Publisher;
import kr.or.yi.java_web_male.service.LibraryUIService;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class BookSearchUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfAuthor;

	private JTextField tfTranslator;
	private JTextField tfTitle;
	private LibraryUIService service;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBoxCateBNo;
	private DefaultComboBoxModel<CategoryM> modelM;
	private JComboBox comboBoxCateMNo;
	private JComboBox comboBoxCateSNo;
	private CategoryB cateB;
	private CategoryM cateM;
	private CategoryM m;
	private CategoryS cateS;
	private CategoryS s;
	private Book book;
	private DefaultComboBoxModel<CategoryS> modelS;
	private JComboBox comboBoxPublisher;
	private DefaultComboBoxModel modelPublisher;
	private List<Book> lists;
	private boolean cateBview = false;
	private boolean cateMview = false;
	private boolean cateSview = false;
	private JCheckBox chckbxCategory;
	private JCheckBox chckbxPublisher;
	private JCheckBox chckbxAuthor;
	private JCheckBox chckbxTranslator;
	private JCheckBox chckbxTitle;
	private JPanel panel_2;
	private JPanel tablePanel;
	private JPanel panel_1;
	private JPanel panelForTable;
	private BookTablePanel tablePanel2;
	private DefaultComboBoxModel<CategoryB> modelB;
	private JButton btnLogin;
	private String log;
	private BookRentUI bookRentUI;
	private boolean searchwhat =true;

	private Book selectedBook;
	private BookDetailUI bookDetailUI;
	private List<Book> listBook;
	private LoginUI loginUI;
	private JButton btnlogin;
	private JTabbedPane tabbedPane;

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
					BookSearchUI frame = new BookSearchUI();
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
	public BookSearchUI() {
		setTitle("도서검색");
		setResizable(false);
		service = new LibraryUIService();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 1002);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);

		panel_1 = new JPanel();
		tabbedPane.addTab("도서번호로검색", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_5.setBorder(new TitledBorder(null, "Book Code\uB85C\uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel_1.add(panel_5, BorderLayout.NORTH);

		tfCode = new JTextField();
		panel_5.add(tfCode);
		tfCode.setColumns(10);

		JButton btnsearchbyBookCode = new JButton("검색");
		panel_5.add(btnsearchbyBookCode);
		btnsearchbyBookCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((tfCode.getText().trim()).equals("")) {
					JOptionPane.showMessageDialog(null, "코드를입력해주세요");
					return;
				}
				/* lists = new ArrayList<>(); */
				book = new Book();
				book.setBookCode(tfCode.getText().trim());
				lists = service.selectbookbybookCode(book);
				if ((((BookTablePanel) tablePanel).setLists(lists)) == false) {
					((BookTablePanel) tablePanel).loadDatas();
					((BookTablePanel) tablePanel).setPopMenu(getPopupMenu());
					JOptionPane.showMessageDialog(null, "검색결과없음");
					return;
				}
				;
				((BookTablePanel) tablePanel).loadDatas();
				((BookTablePanel) tablePanel).setPopMenu(getPopupMenu());
				searchwhat = true;
			}
		});
		btnsearchbyBookCode.setFont(new Font("굴림", Font.BOLD, 20));

		tablePanel = new BookTablePanel();

		panel_1.add(tablePanel);
		tablePanel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.SOUTH);

		if (LoginUI.getLogin() == null) {
			log = "로그인";
		} else {
			log = "로그아웃";
		}

		btnLogin = new JButton(log);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("로그아웃")) {
					/* do_Showmore_actionPerformed(e); */
					JOptionPane.showMessageDialog(null, "로그아웃");
				}
				if (e.getActionCommand().equals("로그인")) {

					JOptionPane.showMessageDialog(null, "로그인");
					// 로그인UI생성
					if (loginUI == null) {
						loginUI = new LoginUI();
					} else {
						JOptionPane.showMessageDialog(null, "이미사용중인 창입니다");
					}
					loginUI.setVisible(true);
				}

			}
		});
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_6.add(btnLogin);

		JPanel panel = new JPanel();
		tabbedPane.addTab("기타로 검색", null, panel, null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uAE30\uD0C0\uAC80\uC0C9",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 20));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 7, 0, 0));

		chckbxCategory = new JCheckBox("");
		chckbxCategory.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if (chckbxCategory.isSelected()) {
					comboBoxCateBNo.setEnabled(true);
					if (cateMview) {
						comboBoxCateMNo.setEnabled(true);
						cateBview = true;
					}
					if (cateSview) {
						comboBoxCateSNo.setEnabled(true);
					}
				} else {
					comboBoxCateBNo.setEnabled(false);
					comboBoxCateMNo.setEnabled(false);
					comboBoxCateSNo.setEnabled(false);
				}
			}
		});
		chckbxCategory.setFont(new Font("굴림체", Font.BOLD, 20));
		chckbxCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(chckbxCategory);

		JLabel lblNewLabel_6 = new JLabel("대분류");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 20));
		panel_3.add(lblNewLabel_6);

		List<CategoryB> blist = service.selectCategoryBByAll();
		CategoryB b = new CategoryB();
		b.setbName("");
		blist.add(0, b);
		modelB = new DefaultComboBoxModel<>(new Vector<>(blist));
		comboBoxCateBNo = new JComboBox(modelB);

		comboBoxCateBNo.setSelectedItem(b);
		comboBoxCateBNo.setEnabled(false);
		comboBoxCateBNo.addItemListener(new ItemListener() {

			// 대분류아이탬이 선택되었을때
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxCateBNo.getSelectedItem().equals(b)) {
					cateBview = false;
					if (m != null) {
						modelM = new DefaultComboBoxModel<>(new Vector<>());
						comboBoxCateMNo.setModel(modelM);
						comboBoxCateMNo.setEnabled(false);
						comboBoxCateSNo.setEnabled(false);
					}
					return;
				}
				cateB = (CategoryB) comboBoxCateBNo.getSelectedItem();
				// 분류번호확인
				/* JOptionPane.showInputDialog(cateB.getbCode()+"/"+cateB.getbName()); */
				cateBview = true;
				List<CategoryM> mlist = service.selectCategoryMByBNo(cateB);
				m = new CategoryM();
				m.setmName("");
				mlist.add(0, m);
				modelM = new DefaultComboBoxModel<>(new Vector<>(mlist));
				comboBoxCateMNo.setModel(modelM);
				comboBoxCateMNo.setSelectedItem(m);
				comboBoxCateMNo.setEnabled(true);
				comboBoxCateSNo.setEnabled(false);
			}
		});
		panel_3.add(comboBoxCateBNo);

		JLabel lblNewLabel_1 = new JLabel("중분류");
		lblNewLabel_1.setFont(new Font("굴림체", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);

		comboBoxCateMNo = new JComboBox();

		comboBoxCateMNo.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {
				if (comboBoxCateMNo.getSelectedItem().equals(m)) {
					cateMview = false;
					if (s != null) {
						modelS = new DefaultComboBoxModel<>(new Vector<>());
						comboBoxCateSNo.setModel(modelS);
						comboBoxCateSNo.setEnabled(false);
					}
					return;
				}
				cateM = (CategoryM) comboBoxCateMNo.getSelectedItem();

				List<CategoryS> slist = service.selectCategorySByBNoMno(cateM);
				s = new CategoryS();
				s.setsName("");
				slist.add(0, s);
				modelS = new DefaultComboBoxModel<>(new Vector<>(slist));
				comboBoxCateSNo.setModel(modelS);
				comboBoxCateMNo.setSelectedItem(s);
				comboBoxCateSNo.setEnabled(true);
				cateMview = true;
			}
		});
		comboBoxCateMNo.setEnabled(false);
		panel_3.add(comboBoxCateMNo);

		JLabel lblNewLabel_2 = new JLabel("소분류");
		lblNewLabel_2.setFont(new Font("굴림체", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);

		comboBoxCateSNo = new JComboBox();
		comboBoxCateSNo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxCateSNo.getSelectedItem().equals(s)) {
					cateSview = false;
					return;
				}
				cateS = (CategoryS) comboBoxCateSNo.getSelectedItem();
				cateSview = true;
			}
		});
		comboBoxCateSNo.setEnabled(false);
		panel_3.add(comboBoxCateSNo);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 7, 0, 0));

		chckbxPublisher = new JCheckBox("");
		chckbxPublisher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckbxPublisher.isSelected()) {
					comboBoxPublisher.setEnabled(true);
				} else {
					comboBoxPublisher.setEnabled(false);
				}
			}
		});
		chckbxPublisher.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxPublisher.setFont(new Font("굴림체", Font.BOLD, 20));
		panel_4.add(chckbxPublisher);

		JLabel lblNewLabel_5 = new JLabel("출판사");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 20));
		panel_4.add(lblNewLabel_5);

		modelPublisher = new DefaultComboBoxModel<>(new Vector<>(service.selectPublisherByAll()));
		comboBoxPublisher = new JComboBox(modelPublisher);
		comboBoxPublisher.setEnabled(false);
		panel_4.add(comboBoxPublisher);

		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 7, 0, 0));

		chckbxAuthor = new JCheckBox("");
		chckbxAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxAuthor.isSelected()) {
					tfAuthor.setEnabled(true);
				} else {
					tfAuthor.setEnabled(false);
				}
			}
		});
		chckbxAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxAuthor.setFont(new Font("굴림체", Font.BOLD, 20));
		panel_7.add(chckbxAuthor);

		JLabel lblNewLabel = new JLabel("저자");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		panel_7.add(lblNewLabel);

		tfAuthor = new JTextField();
		tfAuthor.setEnabled(false);
		tfAuthor.setToolTipText("작가를입력하세요");
		panel_7.add(tfAuthor);
		tfAuthor.setColumns(10);

		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 7, 0, 0));

		chckbxTranslator = new JCheckBox("");
		chckbxTranslator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxTranslator.isSelected()) {
					tfTranslator.setEnabled(true);
				} else {
					tfTranslator.setEnabled(false);
				}
			}
		});
		chckbxTranslator.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxTranslator.setFont(new Font("굴림체", Font.BOLD, 20));
		panel_8.add(chckbxTranslator);

		JLabel lblNewLabel_3 = new JLabel("역자");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 20));
		panel_8.add(lblNewLabel_3);

		tfTranslator = new JTextField();
		tfTranslator.setEnabled(false);
		panel_8.add(tfTranslator);
		tfTranslator.setColumns(10);

		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 7, 0, 0));

		chckbxTitle = new JCheckBox("");
		chckbxTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxTitle.isSelected()) {
					tfTitle.setEnabled(true);
				} else {
					tfTitle.setEnabled(false);
				}
			}
		});
		chckbxTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxTitle.setFont(new Font("굴림체", Font.BOLD, 20));
		panel_9.add(chckbxTitle);

		JLabel lblNewLabel_4 = new JLabel("제목");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));
		panel_9.add(lblNewLabel_4);

		tfTitle = new JTextField();
		tfTitle.setEnabled(false);
		panel_9.add(tfTitle);
		tfTitle.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("");
		panel_9.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("");
		panel_9.add(lblNewLabel_8);

		JButton button = new JButton("검색");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, Object> map = new HashMap<String, Object>();
				/* JOptionPane.showInputDialog(cateB.getbCode()); */
				if (chckbxCategory.isSelected()) {

					if (cateBview) {
						String b = (cateB.getbCode() + "").trim();
						map.put("cateBNo", b);
						if (cateMview) {
							String m = (cateM.getmCode() + "").trim();
							map.put("cateMNo", m);
							if (cateSview) {
								String s = (cateS.getsCode() + "").trim();
								map.put("cateSNo", s);

							}
						}
					}
				}
				if (chckbxPublisher.isSelected()) {
					Publisher pub = new Publisher();
					pub = (Publisher) comboBoxPublisher.getSelectedItem();
					pub = service.selectPublisherByName(pub);
					String pNo = (pub.getPubNo() + "").trim();
					map.put("pubNo", pNo);
				}
				if (chckbxAuthor.isSelected()) {
					if ((tfAuthor.getText().trim()).equals("")) {
						JOptionPane.showMessageDialog(null, "역자를입력해주세요");
						return;
					}
					map.put("author", (tfAuthor.getText()).trim());

				}
				if (chckbxTranslator.isSelected()) {
					if ((tfTranslator.getText().trim()).equals("")) {
						JOptionPane.showMessageDialog(null, "역자를입력해주세요");
						return;
					}
					map.put("translator", (tfTranslator.getText()).trim());

				}
				if (chckbxTitle.isSelected()) {
					if ((tfTitle.getText().trim()).equals("")) {
						JOptionPane.showMessageDialog(null, "제목을입력해주세요");
						return;
					}
					map.put("title", (tfTitle.getText()).trim());

				}
				if ((chckbxCategory.isSelected() || chckbxPublisher.isSelected() || chckbxAuthor.isSelected()
						|| chckbxTranslator.isSelected() || chckbxTitle.isSelected()) == false) {
					JOptionPane.showMessageDialog(null, "검색정보를 입력하세요");
					return;
				} else {

				}
				if ((chckbxCategory.isSelected() == true && cateBview == false)) {
					JOptionPane.showMessageDialog(null, "분류를 선택하세요");
					return;
				}
				lists = new ArrayList<>();
				lists = service.selectbookbyOther(map);
				/* JOptionPane.showMessageDialog(null, lists); */
				if ((((BookTablePanel) tablePanel2).setLists(lists)) == false) {
					((BookTablePanel) tablePanel2).loadDatas();
					((BookTablePanel) tablePanel2).setPopMenu(getPopupMenu());
					JOptionPane.showMessageDialog(null, "검색결과없음");
					return;
				}
				;
				((BookTablePanel) tablePanel2).loadDatas();
				((BookTablePanel) tablePanel2).setPopMenu(getPopupMenu());
				searchwhat = false;

			}
		});
		panel_9.add(button);

		JLabel lblNewLabel_9 = new JLabel("");
		panel_9.add(lblNewLabel_9);

		btnlogin = new JButton(log);
		btnlogin.addActionListener(this);
		panel_9.add(btnlogin);

		tablePanel2 = new BookTablePanel();
		tablePanel2.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					/*JOptionPane.showMessageDialog(null, "2번클릭");*/
					Book book = tablePanel2.selectedItem();
					if(book.isRentalPossible() == true) {
						JOptionPane.showMessageDialog(null, "대여 가능한 책입니다.");
						
						bookRentUI.setBookCode(book);
						BookSearchUI.this.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "대여 불가능한 책입니다.");
					}
					
				}
			}
			
		});
		JPanel panelForTable_1 = new JPanel();
		panelForTable_1.setLayout(new BorderLayout());
		panel.add(panelForTable_1);
		panelForTable_1.setLayout(new BorderLayout(0, 0));
		panelForTable_1.add(tablePanel2);
		panelForTable_1.add(tablePanel2, BorderLayout.CENTER);

	}

	private JPopupMenu getPopupMenu() {
		JPopupMenu popupMenu = new JPopupMenu();

		JMenuItem Showmore = new JMenuItem("상세정보");
		Showmore.addActionListener(this);
		popupMenu.add(Showmore);

		if (true /* Login.loginInfo.getAdmin() */) {
			JMenuItem bookRentInfo = new JMenuItem("도서대여 정보");
			bookRentInfo.addActionListener(this);
			popupMenu.add(bookRentInfo);

			JMenuItem upDate = new JMenuItem("수정");
			upDate.addActionListener(this);
			popupMenu.add(upDate);

			JMenuItem delet = new JMenuItem("삭제");
			delet.addActionListener(this);
			popupMenu.add(delet);

			JMenuItem add = new JMenuItem("추가");
			add.addActionListener(this);
			popupMenu.add(add);

		}
		return popupMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnlogin) {
			do_btnlogin_actionPerformed(e);
		}
		if (e.getActionCommand().equals("상세정보")) {
			do_Showmore_actionPerformed(e);

		}
		if (e.getActionCommand().equals("도서대여 정보")) {
			do_ShowBookrentInfo_actionPerformed(e);

		}
		if (e.getActionCommand().equals("수정")) {
			JOptionPane.showMessageDialog(null, "수정");
		}
		if (e.getActionCommand().equals("삭제")) {
			JOptionPane.showMessageDialog(null, "삭제");
		}
		if (e.getActionCommand().equals("추가")) {
			JOptionPane.showMessageDialog(null, "추가");
		}

	}

	private void do_ShowBookrentInfo_actionPerformed(ActionEvent e) {
		try {
			if (tabbedPane.getSelectedIndex() == 0) {
				selectedBook = ((BookTablePanel) tablePanel).getSelectedBookCodeAll();
			} else {
				selectedBook = tablePanel2.getSelectedBookCodeAll();
			}
			String bookCode = "";
			boolean RentalPossible = false;
			Book book = new Book();
			lists = service.selectbookbybookCode(selectedBook);
			int totalBook = lists.size();
			if (lists.size() > 1) {
				for (Book books : lists) {
					if (books.isRentalPossible()) {
						RentalPossible = true;
					}
					bookCode = bookCode + books.getBookCode() + ",";
					book = books;
				}
			} else {
				for (Book books : lists) {
					if (books.isRentalPossible()) {
						RentalPossible = true;
					}
					bookCode = bookCode + books.getBookCode();
					book = books;
				}
			}
			book.setBookCode(bookCode);
			book.setRentalPossible(RentalPossible);

			bookDetailUI = new BookDetailUI();
			bookDetailUI.setBookInfo(book, totalBook, lists);
			bookDetailUI.loadTable();
			bookDetailUI.btnbookRentalInfoHide();
			bookDetailUI.setVisible(true);
			bookDetailUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "선택하신책정보가 없습니다.");
		}
	}

	public void setBookRentUI(BookRentUI bookRentUI) {
		this.bookRentUI = bookRentUI;
		
	}


	private void do_Showmore_actionPerformed(ActionEvent e) {
		try {
			if (tabbedPane.getSelectedIndex() == 0) {
				selectedBook = ((BookTablePanel) tablePanel).getSelectedBook();
			} else {
				selectedBook = tablePanel2.getSelectedBook();
			}
			String bookCode = "";
			boolean RentalPossible = false;
			Book book = new Book();
			lists = service.selectbookbybookCode(selectedBook);
			int totalBook = lists.size();
			if (lists.size() > 1) {
				for (Book books : lists) {
					if (books.isRentalPossible()) {
						RentalPossible = true;
					}
					bookCode = bookCode + books.getBookCode() + ",";
					book = books;
				}
			} else {
				for (Book books : lists) {
					if (books.isRentalPossible()) {
						RentalPossible = true;
					}
					bookCode = bookCode + books.getBookCode();
					book = books;
				}
			}
			book.setBookCode(bookCode);
			book.setRentalPossible(RentalPossible);

			bookDetailUI = new BookDetailUI();
			bookDetailUI.setBookInfo(book, totalBook, lists);
			bookDetailUI.setVisible(true);
			bookDetailUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "선택하신책정보가 없습니다.");

		}
	}

	protected void do_btnlogin_actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("로그아웃")) {
			JOptionPane.showMessageDialog(null, "로그아웃");
		}
		if (e.getActionCommand().equals("로그인")) {

			JOptionPane.showMessageDialog(null, "로그인");
			// 로그인UI생성
			if (loginUI == null) {
				loginUI = new LoginUI();
			} else {
				JOptionPane.showMessageDialog(null, "이미사용중인 창입니다");
			}
			loginUI.setVisible(true);
		}
	}
	
	

}

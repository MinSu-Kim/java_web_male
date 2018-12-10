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

import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.Publisher;
import kr.or.yi.java_web_male.service.LibraryUIService;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class BookSearchUI extends JFrame {

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
	private CategoryS cateS;
	private Book book;
	private DefaultComboBoxModel<CategoryS> modelS;
	private JComboBox comboBoxPublisher;
	private DefaultComboBoxModel modelPublisher;
	private List<Book> lists;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		service = new LibraryUIService();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		modelB = new DefaultComboBoxModel<>(new Vector<>(service.selectCategoryBByAll()));
		
		modelM = new DefaultComboBoxModel<>(new Vector<>(service.selectCategoryMByAll()));
		
		CategoryB b = new CategoryB();
		b.setbName("");
		b.setbCode(0);
		modelB.addElement(b);
		/*CategoryM m = new CategoryM();
		m.setmName("");
		modelM.addElement(m);
		CategoryS s = new CategoryS();
		s.setsName("");*/
		

		modelS = new DefaultComboBoxModel<>(new Vector<>(service.selectCategorySByAll()));
		/*modelS.addElement(s);*/
		
		modelPublisher = new DefaultComboBoxModel<>(new Vector<>(service.selectPublisherByAll()));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
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
				lists = new ArrayList<>();
				book = new Book();
				book.setBookCode(tfCode.getText().trim());
				lists = service.selectbookbybookCode(book);
				((BookTablePanel) tablePanel).setLists(lists);
				((BookTablePanel) tablePanel).loadDatas();
			}
		});
		btnsearchbyBookCode.setFont(new Font("굴림", Font.BOLD, 20));

		tablePanel = new BookTablePanel();
		panel_1.add(tablePanel);

		panelForTable = new JPanel();

		panelForTable.setLayout(new BorderLayout());

		panelForTable.add(tablePanel, BorderLayout.CENTER);

		panel_1.add(panelForTable);

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
						/* cateBview=true; */
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

		comboBoxCateBNo = new JComboBox(modelB);
		comboBoxCateBNo.setEnabled(false);
		comboBoxCateBNo.addItemListener(new ItemListener() {
			// 대분류가 선택되었을때
			public void itemStateChanged(ItemEvent e) {
				cateB = (CategoryB) comboBoxCateBNo.getSelectedItem();
				// 분류번호확인
				/* JOptionPane.showInputDialog(cateB.getbCode()+"/"+cateB.getbName()); */
				cateMview = true;
				modelM = new DefaultComboBoxModel<>(new Vector<>(service.selectCategoryMByBNo(cateB)));
				comboBoxCateMNo.setModel(modelM);
				comboBoxCateMNo.setEnabled(true);
				comboBoxCateSNo.setEnabled(false);
			}
		});
		panel_3.add(comboBoxCateBNo);

		JLabel lblNewLabel_1 = new JLabel("중분류");
		lblNewLabel_1.setFont(new Font("굴림체", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);

		comboBoxCateMNo = new JComboBox(modelM);
		comboBoxCateMNo.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {

				cateM = (CategoryM) comboBoxCateMNo.getSelectedItem();
				/*
				 * JOptionPane.showInputDialog(cateM.getbCode().getbCode()+"/"+cateM.getmCode()+
				 * "/"+cateM.getmName());
				 */
				modelS = new DefaultComboBoxModel<>(new Vector<>(service.selectCategorySByBNoMno(cateM)));
				comboBoxCateSNo.setModel(modelS);
				comboBoxCateSNo.setEnabled(true);
				cateSview = true;

			}
		});
		comboBoxCateMNo.setEnabled(false);
		panel_3.add(comboBoxCateMNo);

		JLabel lblNewLabel_2 = new JLabel("소분류");
		lblNewLabel_2.setFont(new Font("굴림체", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);

		comboBoxCateSNo = new JComboBox(modelS);
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

		JLabel lblNewLabel_9 = new JLabel("");
		panel_9.add(lblNewLabel_9);

		JButton button = new JButton("검색");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, Object> map = new HashMap<String, Object>();
				if (chckbxCategory.isSelected()) {
					String b = (comboBoxCateBNo.getSelectedItem()+"").trim();
					map.put("cateBNo", b);

					if (cateMview) {
						String m = (comboBoxCateMNo.getSelectedItem()+"").trim();
						map.put("cateMNo", m);
						
						if (cateSview) {
							String s = (comboBoxCateSNo.getSelectedItem()+"").trim();
							map.put("cateSNo", s);
							
						}
					}
				}
				if (chckbxPublisher.isSelected()) {
					Publisher pub = new Publisher();
					pub = (Publisher) comboBoxPublisher.getSelectedItem();
					pub = service.selectPublisherByName(pub);
					String pNo = (pub.getPubNo()+"").trim();
					map.put("pubNo", pNo);
				}
				if (chckbxAuthor.isSelected()) {
					map.put("author", (tfAuthor.getText()).trim());
					
				}
				if (chckbxTranslator.isSelected()) {
					map.put("translator", (tfTranslator.getText()).trim());
					
				}
				if (chckbxTitle.isSelected()) {
					map.put("title", (tfTitle.getText()).trim());
					
				}
				if ((chckbxCategory.isSelected() || chckbxPublisher.isSelected() || chckbxAuthor.isSelected()
						|| chckbxTranslator.isSelected() || chckbxTitle.isSelected()) == false) {
					JOptionPane.showMessageDialog(null, "검색정보를 입력하세요");
				} else {

				}
				lists = new ArrayList<>();
				lists = service.selectbookbyOther(map);
				/*JOptionPane.showMessageDialog(null, lists);*/
				((BookTablePanel) tablePanel2).setLists(lists);
				((BookTablePanel) tablePanel2).loadDatas();

			}
		});
		panel_9.add(button);
		
		tablePanel2 = new BookTablePanel();
		JPanel panelForTable_1 = new JPanel();
		panelForTable_1.setLayout(new BorderLayout());
		panel.add(panelForTable_1);
		panelForTable_1.setLayout(new BorderLayout(0, 0));
		panelForTable_1.add(tablePanel2);
		panelForTable_1.add(tablePanel2, BorderLayout.CENTER);
		
		
		/*panel_1.add(tablePanel);

		panelForTable = new JPanel();

		panelForTable.setLayout(new BorderLayout());

		panelForTable.add(tablePanel, BorderLayout.CENTER);

		panel_1.add(panelForTable);*/

	}

}

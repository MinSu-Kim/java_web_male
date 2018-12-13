package kr.or.yi.java_web_male.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dao.CategoryBMapper;
import kr.or.yi.java_web_male.dao.CategoryBMapperImpl;
import kr.or.yi.java_web_male.dao.CategoryMMapper;
import kr.or.yi.java_web_male.dao.CategoryMMapperImpl;
import kr.or.yi.java_web_male.dao.CategorySMapper;
import kr.or.yi.java_web_male.dao.CategorySMapperImpl;
import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.service.LibraryUIService;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class BookInsertUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfBookCode;
	private JTextField tfBookName;
	private JTextField tfAuthor;
	private JTextField tfTrans;
	private JTextField tfPub;
	private JTextField tfPrice;

	private CategoryBMapper bMapper;
	private CategoryMMapper mMapper;
	private CategorySMapper sMapper;

	private DefaultComboBoxModel<CategoryB> modelB;
	private DefaultComboBoxModel<CategoryM> modelM;
	private DefaultComboBoxModel<CategoryS> modelS;

	private JComboBox comboCateB;
	private JComboBox comboCateM;
	private JComboBox comboCateS;

	private CategoryB cateB;
	private CategoryM cateM;
	private CategoryS cateS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInsertUI frame = new BookInsertUI();
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
	public BookInsertUI() {
		bMapper = CategoryBMapperImpl.getInstance();
		mMapper = CategoryMMapperImpl.getInstance();
		sMapper = CategorySMapperImpl.getInstance();
		initComponents();
	}

	private void initComponents() {
		setTitle("도서 추가");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 10));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblBookCode = new JLabel("도서 번호");
		panel_3.add(lblBookCode);

		tfBookCode = new JTextField();
		tfBookCode.setEditable(false);
		panel_3.add(tfBookCode);
		tfBookCode.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 10, 10));

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 10, 10));

		JLabel lblNewLabel_3 = new JLabel("도서 분류");
		panel_2.add(lblNewLabel_3);

		List<CategoryB> bList = bMapper.selectCategoryBByAll();
		
		modelB = new DefaultComboBoxModel<>(new Vector<>(bList));
		comboCateB = new JComboBox(modelB);
		comboCateB.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				cateB = (CategoryB) comboCateB.getSelectedItem();
				List<CategoryM> mList = mMapper.selectCategoryMByBNo(cateB);
				modelM = new DefaultComboBoxModel<>(new Vector<>(mList));
				comboCateM.removeAll();
				comboCateM.setModel(modelM);
				comboCateM.setEnabled(true);
				comboCateS.setEnabled(false);
			}
		});
		panel_2.add(comboCateB);

		List<CategoryM> mList = mMapper.selectCategoryMByAll();
		modelM = new DefaultComboBoxModel<>(new Vector<>(mList));
		comboCateM = new JComboBox(modelM);
		comboCateM.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				cateM = (CategoryM) comboCateM.getSelectedItem();
				List<CategoryS> sList = sMapper.selectCategorySByBNoMno(cateM);
				System.out.println(sList);
				modelS = new DefaultComboBoxModel<>(new Vector<>(sList));
				comboCateS.removeAll();
				comboCateS.setModel(modelS);
				System.out.println(modelS);
				comboCateS.setEnabled(true);
			}
		});
		comboCateM.setEnabled(false);
		panel_2.add(comboCateM);

		List<CategoryS> sList = sMapper.selectCategorySByAll();
		modelS = new DefaultComboBoxModel<>(new Vector<>(sList));
		comboCateS = new JComboBox(modelS);
		comboCateM.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				cateS = (CategoryS) comboCateS.getSelectedItem();
				System.out.println(cateS);
			}
		});
		comboCateS.setEnabled(false);
		panel_2.add(comboCateS);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblBookName = new JLabel("도서명");
		panel_1.add(lblBookName);

		tfBookName = new JTextField();
		panel_1.add(tfBookName);
		tfBookName.setColumns(10);

		JLabel lblPub = new JLabel("출판사");
		panel_1.add(lblPub);

		tfPub = new JTextField();
		tfPub.setColumns(10);
		panel_1.add(tfPub);

		JLabel lblAuthor = new JLabel("저자");
		panel_1.add(lblAuthor);

		tfAuthor = new JTextField();
		panel_1.add(tfAuthor);
		tfAuthor.setColumns(10);

		JLabel lblTrans = new JLabel("역자");
		panel_1.add(lblTrans);

		tfTrans = new JTextField();
		tfTrans.setColumns(10);
		panel_1.add(tfTrans);

		JLabel lblPrice = new JLabel("가격");
		panel_1.add(lblPrice);

		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		panel_1.add(tfPrice);

		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 10, 10));

		JButton btnInsert = new JButton("추가");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book = new Book();

				/*
				 * book.setCateBNo(cateBNo); book.setCateMNo(cateMNo); book.setCateSNo(cateSNo);
				 */

				book.setTitle(tfBookName.getText());
				book.setAuthor(tfAuthor.getText());
				book.setPubNo(null);
				book.setAuthor(tfAuthor.getText());
				book.setTranslator(tfTrans.getText());
				book.setPrice(Integer.parseInt(tfPrice.getText().trim()));

				/* tfBookCode.setText(); */
				book.setBookCode(tfBookCode.getText());
				System.out.println(book);

			}
		});
		panel_5.add(btnInsert);

		JButton btnCancel = new JButton("취소");
		panel_5.add(btnCancel);
	}
}

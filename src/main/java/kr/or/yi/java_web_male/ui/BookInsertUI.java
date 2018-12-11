package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.junit.Assert;

import kr.or.yi.java_web_male.dao.BookMapper;
import kr.or.yi.java_web_male.dao.BookMapperImpl;
import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.Publisher;
import kr.or.yi.java_web_male.service.LibraryUIService;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class BookInsertUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitle;
	private JTextField tfPublisher;
	private JTextField tfAuthor;
	private JTextField tfTranslator;
	private JTextField tfPrice;
	private JTextField tfBookCode;

	private DefaultComboBoxModel<CategoryB> modelB;
	private DefaultComboBoxModel<CategoryM> modelM;
	private DefaultComboBoxModel<CategoryS> modelS;

	private JComboBox comboBoxCateBNo;
	private JComboBox comboBoxCateMNo;
	private JComboBox comboBoxCateSNo;

	private LibraryUIService service;

	private CategoryB cateB;
	private CategoryM cateM;
	private CategoryS cateS;

	private boolean cateMview = false;
	private boolean cateSview = false;
	private BookMapper bookMapper;

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
		service = new LibraryUIService();
		bookMapper = new BookMapperImpl();
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 4, 10, 10));

		categoryComboBox(panel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10));

		JPanel pBookNo = new JPanel();
		panel_1.add(pBookNo);
		pBookNo.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblBookCode = new JLabel("도서번호");
		pBookNo.add(lblBookCode);

		tfBookCode = new JTextField();
		tfBookCode.setEditable(false);
		pBookNo.add(tfBookCode);
		tfBookCode.setColumns(10);

		JPanel pPhoto = new JPanel();
		panel_1.add(pPhoto);
		pPhoto.setLayout(new GridLayout(0, 1, 10, 10));

		JPanel panel_2 = new JPanel();
		pPhoto.add(panel_2);

		JButton btnPhoto = new JButton("사진추가");
		pPhoto.add(btnPhoto);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblTitle = new JLabel("도서명");
		panel_3.add(lblTitle);

		tfTitle = new JTextField();
		panel_3.add(tfTitle);
		tfTitle.setColumns(10);

		JLabel lblPublisher = new JLabel("출판사");
		panel_3.add(lblPublisher);

		tfPublisher = new JTextField();
		panel_3.add(tfPublisher);
		tfPublisher.setColumns(10);

		JLabel lblAuthor = new JLabel("저자");
		panel_3.add(lblAuthor);

		tfAuthor = new JTextField();
		panel_3.add(tfAuthor);
		tfAuthor.setColumns(10);

		JLabel lblTranslator = new JLabel("역자");
		panel_3.add(lblTranslator);

		tfTranslator = new JTextField();
		panel_3.add(tfTranslator);
		tfTranslator.setColumns(10);

		JLabel lblPrice = new JLabel("가격");
		panel_3.add(lblPrice);

		tfPrice = new JTextField();
		panel_3.add(tfPrice);
		tfPrice.setColumns(10);

		JButton btnOk = new JButton("추가");
		panel_3.add(btnOk);

		JButton btnCancel = new JButton("취소");
		panel_3.add(btnCancel);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("title", tfTitle.getText());
				JOptionPane.showConfirmDialog(null, cateS.getbCode().getbCode() +""+ cateS.getmCode().getmCode() +""+ cateS.getsCode() +"");
				String str = cateS.getbCode().getbCode() +""+ cateS.getmCode().getmCode() +""+ cateS.getsCode() +"";
				/* + service.selectbookbyOther(map) */;
				System.out.println(str);
				Publisher publisher = new Publisher();
				publisher.setPubNo("P001");
				Book book = new Book();

				tfBookCode.setText(str.trim());
				book.setBookCode(str);
				book.setBookNo(0);
				book.setPubNo(publisher);
				book.setTitle(tfTitle.getText().trim());
				book.setAuthor(tfAuthor.getText().trim());
				book.setTranslator(tfTranslator.getText().trim());
				book.setPrice(Integer.parseInt(tfPrice.getText().trim()));
				book.setRentalPossible(true);
				book.setImage("이미지 경로");
				book.setCateBNo(cateB);
				System.out.println(cateB);
				book.setCateMNo(cateM);
				System.out.println(cateM);
				book.setCateSNo(cateS);
				System.out.println(cateS);

				System.out.println(book);
				bookMapper.insertBook(book);
			}
		});
	}

	// 카테고리 콤보박스
	private void categoryComboBox(JPanel panel) {

		JLabel lblNewLabel = new JLabel("도서 분류");
		panel.add(lblNewLabel);

		modelB = new DefaultComboBoxModel<>(new Vector<>(service.selectCategoryBByAll()));
		JOptionPane.showMessageDialog(null, modelB);
		comboBoxCateBNo = new JComboBox(modelB);
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
		panel.add(comboBoxCateBNo);

		modelM = new DefaultComboBoxModel<>(new Vector<>(service.selectCategoryMByAll()));

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

		modelS = new DefaultComboBoxModel<>(new Vector<>(service.selectCategorySByAll()));
		panel.add(comboBoxCateMNo);

		comboBoxCateSNo = new JComboBox(modelS);
		comboBoxCateSNo.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {

				cateS = (CategoryS) comboBoxCateSNo.getSelectedItem();

				/*JOptionPane.showInputDialog(cateM.getbCode().getbCode()
						+ "/" + cateM.getmCode() + "/" + cateM.getmName());*/

			}
		});
		panel.add(comboBoxCateSNo);
	}

}

package kr.or.yi.java_web_male.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dao.BookMapper;
import kr.or.yi.java_web_male.dao.BookMapperImpl;
import kr.or.yi.java_web_male.dao.CategoryBMapper;
import kr.or.yi.java_web_male.dao.CategoryBMapperImpl;
import kr.or.yi.java_web_male.dao.CategoryMMapper;
import kr.or.yi.java_web_male.dao.CategoryMMapperImpl;
import kr.or.yi.java_web_male.dao.CategorySMapper;
import kr.or.yi.java_web_male.dao.CategorySMapperImpl;
import kr.or.yi.java_web_male.dao.PublisherMapper;
import kr.or.yi.java_web_male.dao.PublisherMapperImpl;
import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;

public class BookInsertUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfBookCode;
	private JTextField tfTitle;
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

	private BookMapper bookMapper;
	private PublisherMapper publisherMapper;

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
		bookMapper = BookMapperImpl.getInstance();
		publisherMapper = PublisherMapperImpl.getInstance();

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
				comboCateS.setEnabled(true);
			}
		});
		comboCateM.setEnabled(false);
		panel_2.add(comboCateM);

		List<CategoryS> sList = sMapper.selectCategorySByAll();
		modelS = new DefaultComboBoxModel<>(new Vector<>(sList));
		comboCateS = new JComboBox(modelS);
		comboCateS.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				cateS = (CategoryS) comboCateS.getSelectedItem();
			}
		});
		comboCateS.setEnabled(false);
		panel_2.add(comboCateS);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblBookName = new JLabel("도서명");
		panel_1.add(lblBookName);

		tfTitle = new JTextField();
		panel_1.add(tfTitle);
		tfTitle.setColumns(10);

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

				book.setTitle(tfTitle.getText());
				book.setAuthor(tfAuthor.getText());
				book.setPubNo(null);
				book.setAuthor(tfAuthor.getText());
				book.setTranslator(tfTrans.getText());
				book.setPrice(Integer.parseInt(tfPrice.getText().trim()));
				book.setCateBNo(cateB);
				book.setCateMNo(cateM);
				book.setCateSNo(cateS);

				String cn = cateB.getbCode() + "" + cateM.getmCode() + "" + cateS.getsCode() + "";
				System.out.println(cn);
				
				int i = 0, j = 0, max = 0;
				
				Map<String, Object> map = new HashMap<>();
				map.put("title", book.getTitle());
				System.out.println("확인" + bookMapper.selectbookbyOther(map));
				/*int bos = bookMapper.selectbookbyOther(map).get(0).getBookNo();
				System.out.println(bos + "는 일련번호");*/
				map.put("author", book.getAuthor());
				map.put("translator", book.getTranslator());
				System.out.println(map.get("title"));
				System.out.println(map.get("author"));
				System.out.println(map.containsKey("title"));
				
				List<Book> boog = bookMapper.selectbookbyOther(map);
				System.out.println(boog.size());
				if (bookMapper.selectbookbyOther(map).equals(null)) {
					System.out.println("존재");
					System.out.println(bookMapper.selectbookbyOther(map).size() + 1);
					i = bookMapper.selectbookbyOther(map).get(0).getBookNo();
					System.out.println(i);
					j = bookMapper.selectbookbyOther(map).size() + 1;
					System.out.println(j);
				} else {
					for (int k = 0; k < bookMapper.selectBookByAll().size(); k++) {
						max = bookMapper.selectBookByAll().get(k).getBookNo();
					}
					i = max + 1;
					j = 1;
					System.out.println("음슴");
					System.out.println(bookMapper.selectBookbyno(123));
				}

				String bc = String.format("%s%05d%02d", cn, i, j);
				System.out.println(bc);

				tfBookCode.setText(bc);

				book.setBookCode(tfBookCode.getText());
				book.setBookCode(bc);
				book.setBookNo(i);

				System.out.println(book);
			}
		});
		panel_5.add(btnInsert);

		JButton btnCancel = new JButton("취소");
		panel_5.add(btnCancel);
	}
}

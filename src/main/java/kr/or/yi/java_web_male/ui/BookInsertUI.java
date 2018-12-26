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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

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
import kr.or.yi.java_web_male.dto.Publisher;

public class BookInsertUI extends JFrame implements ActionListener {

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
	private JButton btnImage;
	private JButton btnCancel;
	private JButton btnInsert;
	
	private String pathName;
	private String fileName;

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

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);

		btnImage = new JButton("사진 변경");
		btnImage.addActionListener(this);
		panel_4.add(btnImage);

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

		btnInsert = new JButton("추가");
		btnInsert.addActionListener(this);
		panel_5.add(btnInsert);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_5.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInsert) {
			do_btnInsert_actionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnImage) {
			do_btnImage_actionPerformed(e);
		}
	}

	protected void do_btnInsert_actionPerformed(ActionEvent e) {
		Book book = new Book();
		Publisher publisher = new Publisher();
		Map<String, Object> map = new HashMap<>();
		int i = 0, j = 0, max = 0;

		String pubNo = "";

		publisher.setPubName(tfPub.getText().trim());
		
		if (publisherMapper.selectPublisherByName(publisher) != null) {
			pubNo = publisherMapper.selectPublisherByName(publisher).getPubNo();
			publisher.setPubNo(pubNo);
		} else {
			i = publisherMapper.selectPublisherByAll().size() + 1;
			pubNo = String.format("P%04d", i);
			publisher.setPubNo(pubNo);
			System.out.println(publisher.getPubNo());
			publisherMapper.insertPublisher(publisher);
		}
		
		book.setPubNo(publisher);
		book.setTitle(tfTitle.getText());
		book.setAuthor(tfAuthor.getText());
		book.setAuthor(tfAuthor.getText());
		book.setTranslator(tfTrans.getText());
		book.setPrice(Integer.parseInt(tfPrice.getText().trim()));
		book.setCateBNo(cateB);
		book.setCateMNo(cateM);
		book.setCateSNo(cateS);

		map.put("title", book.getTitle());
		map.put("author", book.getAuthor());
		map.put("translator", book.getTranslator());
		map.put("cate_b_no", book.getCateBNo().getbCode());
		map.put("cate_m_no", book.getCateMNo());
		map.put("cate_s_no", book.getCateSNo());
		map.put("pubNo", book.getPubNo());

		if (bookMapper.selectbookbyOther(map) != null) {
			if (bookMapper.selectbookbyOther(map).size() > 0) {
				i = bookMapper.selectbookbyOther(map).get(0).getBookNo();
				j = bookMapper.selectbookbyOther(map).size() + 1;
			} else {
				for (int k = 0; k < bookMapper.selectBookByAll().size(); k++) {
					if (max < bookMapper.selectBookByAll().get(k).getBookNo()) {
						max = bookMapper.selectBookByAll().get(k).getBookNo();
					}
				}
				i = max + 1;
				j = 1;
			}
		}

		String cn = cateB.getbCode() + "" + cateM.getmCode() + "" + cateS.getsCode() + "";
		String bc = String.format("%s%05d%02d", cn, i, j);

		tfBookCode.setText(bc);
		book.setBookCode(bc);
		book.setBookNo(i);

		int result = JOptionPane.showConfirmDialog(null, bc, "확인", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.CLOSED_OPTION) {

		} else if (result == JOptionPane.YES_OPTION) {
			bookMapper.insertBook(book);
		} else {
			JOptionPane.showMessageDialog(null, "");
		}
	}

	protected void do_btnCancel_actionPerformed(ActionEvent e) {
	}

	protected void do_btnImage_actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
		chooser.setFileFilter(filter);

		int ret = chooser.showOpenDialog(null);

		if (ret == JFileChooser.APPROVE_OPTION) {
			pathName = chooser.getSelectedFile().getPath();
			fileName = chooser.getSelectedFile().getName();
		}
	}
}

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
import javax.swing.ImageIcon;
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
import kr.or.yi.java_web_male.service.BookInsertService;

public class BookInsertUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfBookCode;
	private JTextField tfTitle;
	private JTextField tfAuthor;
	private JTextField tfTrans;
	private JTextField tfPub;
	private JTextField tfPrice;
	private JComboBox comboCateB;
	private JComboBox comboCateM;
	private JComboBox comboCateS;
	private JButton btnImage;
	private JButton btnCancel;
	private JButton btnInsert;
	private JLabel lblImage;
	private DefaultComboBoxModel<CategoryB> modelB;
	private DefaultComboBoxModel<CategoryM> modelM;
	private DefaultComboBoxModel<CategoryS> modelS;
	private CategoryB cateB;
	private CategoryM cateM;
	private CategoryS cateS;
	private CategoryB b;
	private CategoryM m;
	private CategoryS s;
	private boolean cateBview;
	private boolean cateMview;
	private boolean cateSview;
	private String pathName;
	private String fileName;
	private String imgPath;
	private BookSearchUI bookSearchUI;
	private BookInsertService service;

	public BookInsertUI() {
		imgPath = System.getProperty("user.dir") + "\\images\\";
		service = new BookInsertService();
		initComponents();
	}

	private void initComponents() {
		setTitle("도서 추가");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 133);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 88, 207, 45);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblBookCode = new JLabel("도서 번호");
		lblBookCode.setBounds(39, 0, 59, 36);
		panel_3.add(lblBookCode);

		tfBookCode = new JTextField();
		tfBookCode.setBounds(110, 0, 98, 35);
		tfBookCode.setEditable(false);
		panel_3.add(tfBookCode);
		tfBookCode.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(219, 0, 207, 133);
		panel.add(panel_4);

		btnImage = new JButton("사진 추가");
		btnImage.setBounds(42, 110, 126, 23);
		btnImage.addActionListener(this);
		panel_4.add(btnImage);
		panel_4.setLayout(null);

		lblImage = new JLabel("");
		lblImage.setBounds(42, 0, 126, 106);
		panel_4.add(lblImage);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 148, 424, 36);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("도서 분류");
		lblNewLabel_3.setBounds(41, 0, 58, 34);
		panel_2.add(lblNewLabel_3);

		List<CategoryB> blist = service.selectCategoryBByAll();
		b = new CategoryB();
		b.setbName("");
		blist.add(0, b);
		modelB = new DefaultComboBoxModel<>(new Vector<>(blist));
		comboCateB = new JComboBox(modelB);
		comboCateB.setBounds(109, 0, 98, 34);
		comboCateB.setSelectedItem(b);
		comboCateB.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (comboCateB.getSelectedItem().equals(b)) {
					cateBview = false;
					if (m != null) {
						modelM = new DefaultComboBoxModel<>(new Vector<>());
						comboCateB.setModel(modelM);
						comboCateB.setEnabled(false);
						comboCateB.setEnabled(false);
					}
					return;
				}
				cateB = (CategoryB) comboCateB.getSelectedItem();
				cateBview = true;
				List<CategoryM> mList = service.selectCategoryMByBNo(cateB);
				m = new CategoryM();
				m.setmName("");
				mList.add(0, m);
				modelM = new DefaultComboBoxModel<>(new Vector<>(mList));
				comboCateM.setModel(modelM);
				comboCateM.setSelectedItem(m);
				comboCateM.setEnabled(true);
				comboCateS.setEnabled(false);
			}
		});
		panel_2.add(comboCateB);

		comboCateM = new JComboBox();
		comboCateM.setBounds(217, 0, 98, 34);
		comboCateM.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (comboCateM.getSelectedItem().equals(m)) {
					cateMview = false;
					if (s != null) {
						modelS = new DefaultComboBoxModel<>(new Vector<>());
						comboCateS.setModel(modelS);
						comboCateS.setEnabled(false);
					}
					return;
				}
				cateM = (CategoryM) comboCateM.getSelectedItem();
				List<CategoryS> slist = service.selectCategorySByBNoMno(cateM);
				s = new CategoryS();
				s.setsName("");
				slist.add(0, s);
				modelS = new DefaultComboBoxModel<>(new Vector<>(slist));
				comboCateS.setModel(modelS);
				comboCateM.setSelectedItem(s);
				comboCateS.setEnabled(true);
				cateMview = true;
			}
		});
		comboCateM.setEnabled(false);
		panel_2.add(comboCateM);

		List<CategoryS> sList = service.selectCategorySByAll();
		modelS = new DefaultComboBoxModel<>(new Vector<>(sList));
		comboCateS = new JComboBox();
		comboCateS.setBounds(325, 0, 98, 34);
		comboCateS.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (comboCateS.getSelectedItem().equals(s)) {
					cateSview = false;
					return;
				}
				cateS = (CategoryS) comboCateS.getSelectedItem();
				cateSview = true;
			}
		});
		comboCateS.setEnabled(false);
		panel_2.add(comboCateS);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 194, 424, 133);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblBookName = new JLabel("도서명");
		lblBookName.setBounds(41, 1, 164, 18);
		panel_1.add(lblBookName);

		tfTitle = new JTextField();
		tfTitle.setBounds(217, 1, 207, 18);
		panel_1.add(tfTitle);
		tfTitle.setColumns(10);

		JLabel lblPub = new JLabel("출판사");
		lblPub.setBounds(41, 29, 164, 18);
		panel_1.add(lblPub);

		tfPub = new JTextField();
		tfPub.setBounds(217, 29, 207, 18);
		tfPub.setColumns(10);
		panel_1.add(tfPub);

		JLabel lblAuthor = new JLabel("저자");
		lblAuthor.setBounds(41, 57, 166, 18);
		panel_1.add(lblAuthor);

		tfAuthor = new JTextField();
		tfAuthor.setBounds(217, 57, 207, 18);
		panel_1.add(tfAuthor);
		tfAuthor.setColumns(10);

		JLabel lblTrans = new JLabel("역자");
		lblTrans.setBounds(41, 85, 166, 18);
		panel_1.add(lblTrans);

		tfTrans = new JTextField();
		tfTrans.setBounds(217, 85, 207, 18);
		tfTrans.setColumns(10);
		panel_1.add(tfTrans);

		JLabel lblPrice = new JLabel("가격");
		lblPrice.setBounds(41, 113, 164, 18);
		panel_1.add(lblPrice);

		tfPrice = new JTextField();
		tfPrice.setBounds(217, 113, 207, 18);
		tfPrice.setColumns(10);
		panel_1.add(tfPrice);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(5, 337, 424, 39);
		contentPane.add(panel_5);

		btnInsert = new JButton("추가");
		btnInsert.setBounds(37, 0, 155, 39);
		btnInsert.addActionListener(this);
		panel_5.setLayout(null);
		panel_5.add(btnInsert);

		btnCancel = new JButton("취소");
		btnCancel.setBounds(241, 0, 155, 39);
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

		if (!tfPub.getText().equals("")) {
			publisher.setPubName(tfPub.getText().trim());
			if (service.selectPublisherByName(publisher) != null) {
				pubNo = service.selectPublisherByName(publisher).getPubNo();
				publisher.setPubNo(pubNo);
			} else {
				i = service.selectPublisherByAll().size() + 1;
				pubNo = String.format("P%04d", i);
				publisher.setPubNo(pubNo);
				service.insertPublisher(publisher);
			}
		} else {
			JOptionPane.showMessageDialog(null, "출판사를 입력해주세요.");
		}

		book.setPubNo(publisher);
		book.setTitle(tfTitle.getText());
		book.setAuthor(tfAuthor.getText());
		book.setAuthor(tfAuthor.getText());
		book.setTranslator(tfTrans.getText());
		book.setPrice(Integer.parseInt(tfPrice.getText().trim()));
		book.setRentalPossible(true);
		book.setImage(fileName);
		book.setCateBNo(cateB);
		book.setCateMNo(cateM);
		book.setCateSNo(cateS);

		map.put("title", book.getTitle());
		map.put("author", book.getAuthor());
		map.put("translator", book.getTranslator());
		map.put("cate_b_no", book.getCateBNo().getbCode());
		map.put("cate_m_no", book.getCateMNo().getmCode());
		map.put("cate_s_no", book.getCateSNo().getsCode());
		map.put("pubNo", book.getPubNo().getPubNo());

		if (service.selectbookbyOther(map) != null) {
			if (service.selectbookbyOther(map).size() > 0) {
				i = service.selectbookbyOther(map).get(0).getBookNo();
				j = service.selectbookbyOther(map).size() + 1;
			} else {
				for (int k = 0; k < service.selectBookByAll().size(); k++) {
					if (max < service.selectBookByAll().get(k).getBookNo()) {
						max = service.selectBookByAll().get(k).getBookNo();
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
		
		if (tfTitle.getText().equals("") || tfAuthor.getText().equals("") || tfTrans.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "도서 정보가 누락되었습니다.");
		} else {
			int result = JOptionPane.showConfirmDialog(null, "해당 정보로 도서를 추가합니다.", "Sysyem Message", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.CLOSED_OPTION) {

			} else if (result == JOptionPane.YES_OPTION) {
				service.insertBook(book);
			} else {
			}
		}
	}

	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		dispose();
	}

	protected void do_btnImage_actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
		chooser.setFileFilter(filter);
		int ret = chooser.showOpenDialog(null);

		if (ret == JFileChooser.APPROVE_OPTION) {
			pathName = chooser.getSelectedFile().getPath();
			fileName = chooser.getSelectedFile().getName();
			lblImage.setIcon(new ImageIcon(imgPath + fileName));
		}
	}
}

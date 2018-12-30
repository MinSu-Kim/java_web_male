package kr.or.yi.java_web_male.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
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

public class BookUpdateUI extends JFrame implements ActionListener {

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
	private JButton btnupdate;
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

	private Book book;
	public BookUpdateUI(Book book) {
		this.book = book;
		System.out.println(book);
		System.out.println("확인" + book.getPubNo());
		imgPath = System.getProperty("user.dir") + "\\images\\";
		service = new BookInsertService();
		initComponents(book);
	}

	private void initComponents(Book book) {
		setTitle("도서 수정");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		tfBookCode.setText(book.getBookCode());

		panel_3.add(tfBookCode);
		tfBookCode.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 10, 10));

		btnImage = new JButton("사진 수정");
		btnImage.addActionListener(this);

		lblImage = new JLabel("사진 수정");
		panel_4.add(lblImage);
		panel_4.add(btnImage);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 10, 10));

		JLabel lblNewLabel_3 = new JLabel("도서 분류");
		panel_2.add(lblNewLabel_3);

		List<CategoryB> blist = new ArrayList<>();
		b = new CategoryB();
		b.setbName(book.getCateBNo().getbName());
		blist.add(0, b);
		modelB = new DefaultComboBoxModel<>(new Vector<>(blist));
		comboCateB = new JComboBox(modelB);
		comboCateB.setSelectedItem(b);
		comboCateB.setEnabled(false);

		List<CategoryM> mList = new ArrayList<>();
		m = new CategoryM();
		m.setmName(book.getCateMNo().getmName());
		mList.add(0, m);
		modelM = new DefaultComboBoxModel<>(new Vector<>(mList));
		comboCateM = new JComboBox(modelM);
		comboCateM.setSelectedItem(m);
		comboCateM.setEnabled(false);

		List<CategoryS> slist = new ArrayList<>();
		s = new CategoryS();
		s.setsName(book.getCateSNo().getsName());
		slist.add(0, s);
		modelS = new DefaultComboBoxModel<>(new Vector<>(slist));
		comboCateS = new JComboBox(modelS);
		comboCateS.setSelectedItem(s);
		comboCateS.setEnabled(false);
		panel_2.add(comboCateB);
		panel_2.add(comboCateM);
		panel_2.add(comboCateS);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblBookName = new JLabel("도서명");
		panel_1.add(lblBookName);

		tfTitle = new JTextField();
		panel_1.add(tfTitle);
		tfTitle.setColumns(10);
		tfTitle.setText(book.getTitle());
		JLabel lblPub = new JLabel("출판사");
		panel_1.add(lblPub);

		tfPub = new JTextField();
		tfPub.setColumns(10);
		tfPub.setText(book.getPubNo().getPubName());

		panel_1.add(tfPub);

		JLabel lblAuthor = new JLabel("저자");
		panel_1.add(lblAuthor);

		tfAuthor = new JTextField();
		panel_1.add(tfAuthor);
		tfAuthor.setText(book.getAuthor());
		tfAuthor.setColumns(10);

		JLabel lblTrans = new JLabel("역자");
		panel_1.add(lblTrans);

		tfTrans = new JTextField();
		tfTrans.setText(book.getTranslator());
		tfTrans.setColumns(10);
		panel_1.add(tfTrans);

		JLabel lblPrice = new JLabel("가격");
		panel_1.add(lblPrice);

		tfPrice = new JTextField();
		tfPrice.setColumns(10);

		tfPrice.setText(book.getPrice() + "");
		panel_1.add(tfPrice);

		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 10, 10));

		btnupdate = new JButton("수정");
		btnupdate.addActionListener(this);
		panel_5.add(btnupdate);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_5.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnupdate) {
			do_btnUpdate_actionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnImage) {
			do_btnImage_actionPerformed(e);
		}
	}

	private void do_btnUpdate_actionPerformed(ActionEvent e) {
		Publisher publisher = new Publisher();
		int i = 0;
		String pubNo = "";

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

		book.setPubNo(publisher);
		book.setTitle(tfTitle.getText());
		book.setAuthor(tfAuthor.getText());
		book.setTranslator(tfTrans.getText());
		book.setPrice(Integer.parseInt(tfPrice.getText().trim()));
		book.setRentalPossible(true);
		book.setImage(fileName);
		
		System.out.println(book);
	
		
		
		
		try {
			service.updatetBook(book);
			int result = JOptionPane.showConfirmDialog(null, "수정이 완료되었습니다.목록으로 돌아가시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.CLOSED_OPTION) {

			} else if (result == JOptionPane.YES_OPTION) {
				dispose();
			}

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "수정에 실패하였습니다.");
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

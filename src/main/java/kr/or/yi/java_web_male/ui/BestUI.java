package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_male.InitScene;
import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookBest10;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.MemberBest10;
import kr.or.yi.java_web_male.service.BestUIService;
import kr.or.yi.java_web_male.service.LibraryUIService;
import javax.swing.border.EtchedBorder;

public class BestUI extends JFrame implements ItemListener, ActionListener {

	private JPanel contentPane;
	private JSpinner bspinnerYear;
	private JSpinner bspinnerMonth;
	private DefaultComboBoxModel<CategoryB> modelB;
	private DefaultComboBoxModel<CategoryM> modelM;
	private DefaultComboBoxModel<CategoryS> modelS;
	private List<Book> BookLists;
	private List<BookBest10> Best10BookLists;
	private LibraryUIService service;

	private boolean bookCateBview;
	private boolean bookCateMview;
	private boolean bookCateSview;
	private boolean memCateBview;
	private boolean memCateMview;
	private boolean memCateSview;
	private CategoryB B;
	private CategoryM M;
	private CategoryS S;
	private CategoryB bookCateB;
	private CategoryM bookCateM;
	private CategoryS bookCateS;
	private CategoryB memCateB;
	private CategoryM memCateM;
	private CategoryS memCateS;
	private JComboBox bCBCateB;
	private JComboBox bCBCateM;
	private JComboBox bCBCateS;
	private JComboBox<String> BCBKindsCate;
	private DefaultComboBoxModel nullModel = new DefaultComboBoxModel<>(new Vector<>());
	private JSpinner mspinnerYear;
	private JSpinner mspinnerMonth;
	private JComboBox mCBKindsCate;
	private JComboBox mCBCateB;
	private JComboBox mCBCateM;
	private JComboBox mCBCateS;

	private DefaultComboBoxModel MmodelB;
	private JComboBox<String> BCBKindsDate;
	private JComboBox<String> MCBKindsDate;
	private JButton btnBook;
	private JButton btnmember;
	private BestUIService bestService;
	private BestUIBookTablePanel panelForBTable;
	private TitledBorder titledBorder;
	private BookDetailUI bookDetailUI;
	private BookBest10PanelBarChart pBarChart;
	private MemberBest10PanelBarChart panelForMTable;
	private String year;
	private String now;
	private String last;
	private List<BookBest10> best10BookListsLast;
	private List<MemberBest10> best10MemberListsLast;
	private List<MemberBest10> best10MemberListsNow;
	private CatePanelLineChartBest pLineChart;
	private PanelPieChartbest10 panelPieChartbest10;
	private JButton btnChangegraph;
	private JPanel panel_10;
	private List<List<BookBest10>> listlists;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BestUI frame = new BestUI();
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
	public BestUI() {
		service = new LibraryUIService();
		bestService = new BestUIService();
		String[] KindsDatestrArr = { "년별", "월별", "전체" };
		DefaultComboBoxModel<String> Datemodel = new DefaultComboBoxModel<>(KindsDatestrArr);
		String[] KindsCatestrArr = { "전체", "장르별" };
		DefaultComboBoxModel<String> Catemodel = new DefaultComboBoxModel<>(KindsCatestrArr);
		List<CategoryB> blist = service.selectCategoryBByAll();
		B = new CategoryB();
		B.setbName("");
		blist.add(0, B);
		modelB = new DefaultComboBoxModel<>(new Vector<>(blist));
		MmodelB = new DefaultComboBoxModel<>(new Vector<>(blist));

		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		year = "";
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		year = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1);
		if(((cal.get(Calendar.MONTH)+1+"").trim()).length()==1) {
			year = cal.get(Calendar.YEAR) + "-0" + (cal.get(Calendar.MONTH) + 1);
		}
		map.put("rentalDate", year);
		Best10BookLists = bestService.selectBookBest10ByMap(map);
		List<String> bookCodes = new ArrayList<>();
		for (BookBest10 best10 : Best10BookLists) {
			bookCodes.add(best10.getBookCode().getBookCode());
		}

		DefaultComboBoxModel<String> MDatemodel = new DefaultComboBoxModel<>(KindsDatestrArr);

		DefaultComboBoxModel<String> CatemodelM = new DefaultComboBoxModel<>(KindsCatestrArr);

		setTitle("Best");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 841);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Book Best10!",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_16 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_16.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_16);

		JLabel lblNewLabel = new JLabel("분류방법을선택하세요(년,월)");
		panel_16.add(lblNewLabel);
		BCBKindsDate = new JComboBox<>(Datemodel);
		BCBKindsDate.setSelectedIndex(1);
		BCBKindsDate.addItemListener(this);
		panel_16.add(BCBKindsDate);

		bspinnerYear = new JSpinner();
		bspinnerYear.setModel(new SpinnerDateModel(new Date(), null, new Date(), Calendar.DAY_OF_MONTH));
		bspinnerYear.setEditor(new JSpinner.DateEditor(bspinnerYear, "yyyy"));

		JPanel panel_17 = new JPanel();
		panel_5.add(panel_17);
		FlowLayout flowLayout_1 = (FlowLayout) panel_17.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);

		panel_17.add(bspinnerYear);

		bspinnerMonth = new JSpinner();
		bspinnerMonth.setModel(new SpinnerDateModel(new Date(1545107289098L), null, null, Calendar.DAY_OF_MONTH));
		bspinnerMonth.setEditor(new JSpinner.DateEditor(bspinnerMonth, "MM"));
		bspinnerMonth.setEnabled(true);
		panel_17.add(bspinnerMonth);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_18 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_18.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_18);

		JLabel lblNewLabel_2 = new JLabel("분류방법을선택하세요(장르)");
		panel_18.add(lblNewLabel_2);
		BCBKindsCate = new JComboBox<>(Catemodel);
		BCBKindsCate.addItemListener(this);
		panel_18.add(BCBKindsCate);

		JPanel panel_19 = new JPanel();
		panel_3.add(panel_19);
		panel_19.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNewLabel_3 = new JLabel("대");
		panel_19.add(lblNewLabel_3);
		bCBCateB = new JComboBox(modelB);

		bCBCateB.setMaximumRowCount(10);
		bCBCateB.setEnabled(false);
		bCBCateB.setSelectedItem(B);
		bCBCateB.addItemListener(this);
		panel_19.add(bCBCateB);

		JLabel lblNewLabel_1 = new JLabel("중");
		panel_19.add(lblNewLabel_1);

		bCBCateM = new JComboBox();

		bCBCateM.setMaximumRowCount(10);
		bCBCateM.setEnabled(false);
		bCBCateM.addItemListener(this);
		panel_19.add(bCBCateM);

		JLabel lblNewLabel_12 = new JLabel("소");
		panel_19.add(lblNewLabel_12);

		bCBCateS = new JComboBox();
		bCBCateS.setMaximumRowCount(10);
		bCBCateS.setEnabled(false);
		bCBCateS.addItemListener(this);
		panel_19.add(bCBCateS);

		btnBook = new JButton("검색");
		btnBook.addActionListener(this);
		panel_19.add(btnBook);
		bCBCateB.setEnabled(false);
		bCBCateB.setSelectedItem(B);

		panelForBTable = new BestUIBookTablePanel();
		titledBorder = new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"\uC774\uBC88\uB2EC Best10!", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelForBTable.setBorder(titledBorder);

		panelForBTable.setLists(Best10BookLists);
		panelForBTable.loadDatas();

		panelForBTable.setPopMenu(getPopupMenu());
		panel.add(panelForBTable, BorderLayout.CENTER);
		panelForBTable.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		pBarChart = new BookBest10PanelBarChart();
		
		now = ("("+cal.get(Calendar.YEAR) + "년)"+(cal.get(Calendar.MONTH) + 1) +"월").trim();
		
		Platform.runLater(() -> {pBarChart.setChartDataThis(Best10BookLists,now);});
		
		last = ("("+cal.get(Calendar.YEAR) + "년)"+cal.get(Calendar.MONTH) + "월").trim();
		year = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH));
		if(((cal.get(Calendar.MONTH)+1+"").trim()).length()==1) {
			year = cal.get(Calendar.YEAR) + "-0" + (cal.get(Calendar.MONTH));
		}
		map.put("bookCodes", bookCodes);
		map.put("rentalDate", year);		
		best10BookListsLast = bestService.selectBookBest10ByMap(map);
		
		Platform.runLater(() -> {pBarChart.setChartDataLast(best10BookListsLast,last);});
		Platform.runLater(() -> initFX(pBarChart));

		
		panel_1.add(pBarChart, BorderLayout.CENTER);

		

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\uB2E4\uB3C5\uC655!", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_14 = new JPanel();
		panel_11.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_26 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_26.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_14.add(panel_26);

		JLabel label = new JLabel("분류방법을선택하세요(년,월)");
		panel_26.add(label);
		MCBKindsDate = new JComboBox<>(MDatemodel);
		MCBKindsDate.setSelectedIndex(1);
		MCBKindsDate.addItemListener(this);

		panel_26.add(MCBKindsDate);

		JPanel panel_27 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_27.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_14.add(panel_27);

		mspinnerYear = new JSpinner();
		mspinnerYear.setModel(new SpinnerDateModel(new Date(), null, new Date(), Calendar.DAY_OF_MONTH));
		mspinnerYear.setEditor(new JSpinner.DateEditor(mspinnerYear, "yyyy"));
		panel_27.add(mspinnerYear);

		mspinnerMonth = new JSpinner();
		mspinnerMonth.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		mspinnerMonth.setEditor(new JSpinner.DateEditor(mspinnerMonth, "MM"));
		mspinnerMonth.setEnabled(true);
		panel_27.add(mspinnerMonth);

		JPanel panel_28 = new JPanel();
		panel_11.add(panel_28);
		panel_28.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_29 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_29.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_28.add(panel_29);

		JLabel label_1 = new JLabel("분류방법을선택하세요(장르)");
		panel_29.add(label_1);
		mCBKindsCate = new JComboBox(CatemodelM);
		mCBKindsCate.addItemListener(this);
		panel_29.add(mCBKindsCate);

		JPanel panel_30 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_30.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel_28.add(panel_30);

		JLabel label_2 = new JLabel("대");
		panel_30.add(label_2);

		mCBCateB = new JComboBox(MmodelB);
		mCBCateB.setEnabled(false);
		mCBCateB.addItemListener(this);
		panel_30.add(mCBCateB);

		JLabel label_3 = new JLabel("중");
		panel_30.add(label_3);

		mCBCateM = new JComboBox();
		mCBCateM.setEnabled(false);
		mCBCateM.addItemListener(this);
		panel_30.add(mCBCateM);

		JLabel label_4 = new JLabel("소");
		panel_30.add(label_4);

		mCBCateS = new JComboBox();
		mCBCateS.addItemListener(this);
		mCBCateS.setEnabled(false);
		panel_30.add(mCBCateS);

		btnmember = new JButton("검색");
		btnmember.addActionListener(this);
		panel_30.add(btnmember);

		
		Map<String, Object> MemberMap = new HashMap<String, Object>();
		
		Date Memberdate = new Date();
		year = "";
		cal.setTime(Memberdate);
		
		year = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1);
		if(((cal.get(Calendar.MONTH)+1+"").trim()).length()==1) {
			year = cal.get(Calendar.YEAR) + "-0" + (cal.get(Calendar.MONTH) + 1);
		}
		MemberMap.put("rentalDate", year);
				
		best10MemberListsNow = bestService.selectMemberBest10ByMap(MemberMap);
		
		
		
		List<String> memberNos = new ArrayList<>();
		for (MemberBest10 best10 : best10MemberListsNow) {
			memberNos.add(best10.getMemberNo().getMemberNo());
		}
		MemberMap.put("memberNos", memberNos);
		
		
		
		
		
		now = ("("+cal.get(Calendar.YEAR) + "년)"+(cal.get(Calendar.MONTH) + 1) +"월").trim();
		
		
		last = ("("+cal.get(Calendar.YEAR) + "년)"+cal.get(Calendar.MONTH) + "월").trim();
		year = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH));
		if(((cal.get(Calendar.MONTH)+1+"").trim()).length()==1) {
			year = cal.get(Calendar.YEAR) + "-0" + (cal.get(Calendar.MONTH));
		}

		MemberMap.put("rentalDate", year);		
		best10MemberListsLast = bestService.selectMemberBest10ByMap(MemberMap);
		
		
		
		panelForMTable = new MemberBest10PanelBarChart();
		panel_9.add(panelForMTable, BorderLayout.CENTER);

		Platform.runLater(() -> {panelForMTable.setChartDataThis(best10MemberListsNow,now);});
		Platform.runLater(() -> {panelForMTable.setChartDataLast(best10MemberListsLast,last);});
		Platform.runLater(() -> initFX(panelForMTable));
		
		
		panel_10 = new JPanel();
		contentPane.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		
		Calendar cal2 = Calendar.getInstance();
		Map<String, Object> mapForCateChart = new HashMap<String, Object>();
		List<String> days = new ArrayList<>();
		listlists = new ArrayList<>();
		List<BookBest10> best10s = new ArrayList<>();
		String rentalDate = "";
		/*List<String> cates = new ArrayList<>();*/
		Date whennow = new Date();
		cal2.setTime(whennow);
		for (int i = 0; i < 6; i++) {
			
			if(((cal2.get(Calendar.MONTH)-i+"").trim()).length()==1) {
				days.add( (cal2.get(Calendar.YEAR) + "-0" + (cal2.get(Calendar.MONTH) + 1 - i)));
				/*rentalDate = (cal2.get(Calendar.YEAR) + "-0" + (cal2.get(Calendar.MONTH) + 1 - i));*/
			}else {
				days.add((cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH) + 1 - i)));
			}
		}
		for(int i = 0 ; i <10 ; i++ ) {
			mapForCateChart.put("cateBNo",i);
			mapForCateChart.put("days", days);
			best10s = bestService.selectBookByMap(mapForCateChart);
			listlists.add(best10s);
		}
		
		
		pLineChart = new CatePanelLineChartBest();
		
		
		
		Platform.runLater(() -> {pLineChart.setList(listlists);}); 	
		
		panel_10.add(pLineChart, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_10.add(panel_4, BorderLayout.SOUTH);
		
		btnChangegraph = new JButton("파이그래프보기");
		btnChangegraph.addActionListener(this);
		panel_4.add(btnChangegraph);
		
		Platform.runLater(() -> initFX(pLineChart));
	}

	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == MCBKindsDate) {
			do_MCBKindsDate_itemStateChanged(e);
		}
		if (e.getSource() == BCBKindsDate) {
			do_BCBKindsDate_itemStateChanged(e);
		}
		if (e.getSource() == mCBCateS) {
			do_mCBCateS_itemStateChanged(e);
		}
		if (e.getSource() == mCBKindsCate) {
			do_mCBKindsCate_itemStateChanged(e);
		}
		if (e.getSource() == mCBCateM) {
			do_mCBCateM_itemStateChanged(e);
		}
		if (e.getSource() == mCBCateB) {
			do_mCBCateB_itemStateChanged(e);
		}
		if (e.getSource() == BCBKindsCate) {
			do_BCBKindsCate_itemStateChanged(e);
		}
		if (e.getSource() == bCBCateS) {
			do_bCBCateS_itemStateChanged(e);
		}
		if (e.getSource() == bCBCateM) {
			do_bCBCateM_itemStateChanged(e);
		}
		if (e.getSource() == bCBCateB) {
			do_bCBCateB_itemStateChanged(e);
		}
	}

	protected void do_bCBCateB_itemStateChanged(ItemEvent e) {
		if (bCBCateB.getSelectedItem().equals(B)) {
			bookCateBview = false;
			if (M != null) {

				bCBCateM.setModel(nullModel);
				bCBCateM.setEnabled(false);
				bCBCateS.setModel(nullModel);
				bCBCateS.setEnabled(false);
			}
			return;
		}
		bookCateB = (CategoryB) bCBCateB.getSelectedItem();

		bookCateBview = true;
		List<CategoryM> mlist = service.selectCategoryMByBNo(bookCateB);
		M = new CategoryM();
		M.setmName("");
		mlist.add(0, M);
		modelM = new DefaultComboBoxModel<>(new Vector<>(mlist));
		bCBCateM.setModel(modelM);
		bCBCateM.setSelectedItem(M);
		bCBCateM.setEnabled(true);
		bCBCateS.setEnabled(false);
	}

	protected void do_bCBCateM_itemStateChanged(ItemEvent e) {
		if (bCBCateM.getSelectedItem().equals(M)) {
			bookCateMview = false;
			if (S != null) {

				bCBCateS.setModel(nullModel);
				bCBCateS.setEnabled(false);
			}
			return;
		}
		bookCateM = (CategoryM) bCBCateM.getSelectedItem();

		List<CategoryS> slist = service.selectCategorySByBNoMno(bookCateM);
		S = new CategoryS();
		S.setsName("");
		slist.add(0, S);
		modelS = new DefaultComboBoxModel<>(new Vector<>(slist));
		bCBCateS.setModel(modelS);
		bCBCateM.setSelectedItem(S);
		bCBCateS.setEnabled(true);
		bookCateMview = true;
	}

	protected void do_bCBCateS_itemStateChanged(ItemEvent e) {
		if (bCBCateS.getSelectedItem().equals(S)) {
			bookCateSview = false;
			return;
		}
		bookCateS = (CategoryS) bCBCateS.getSelectedItem();
		bookCateSview = true;
	}

	protected void do_BCBKindsCate_itemStateChanged(ItemEvent e) {
		if (BCBKindsCate.getSelectedItem().equals("장르별")) {
			bCBCateB.setEnabled(true);
			return;
		}
		if (BCBKindsCate.getSelectedItem().equals("전체")) {
			bCBCateB.setEnabled(false);
			bCBCateM.setEnabled(false);
			bCBCateS.setEnabled(false);
			return;
		}
	}

	protected void do_mCBCateB_itemStateChanged(ItemEvent e) {
		if (mCBCateB.getSelectedItem().equals(B)) {
			memCateBview = false;
			if (M != null) {
				mCBCateM.setModel(nullModel);
				mCBCateS.setModel(nullModel);
				mCBCateM.setEnabled(false);
				mCBCateS.setEnabled(false);
			}
			return;
		}
		memCateB = (CategoryB) mCBCateB.getSelectedItem();

		memCateBview = true;
		List<CategoryM> mlist = service.selectCategoryMByBNo(memCateB);
		M = new CategoryM();
		M.setmName("");
		mlist.add(0, M);
		modelM = new DefaultComboBoxModel<>(new Vector<>(mlist));
		mCBCateM.setModel(modelM);
		mCBCateM.setSelectedItem(M);
		mCBCateM.setEnabled(true);
		mCBCateS.setEnabled(false);
	}

	protected void do_mCBCateM_itemStateChanged(ItemEvent e) {
		if (mCBCateM.getSelectedItem().equals(M)) {
			memCateMview = false;
			if (S != null) {

				mCBCateS.setModel(nullModel);
				mCBCateS.setEnabled(false);
			}
			return;
		}
		memCateM = (CategoryM) mCBCateM.getSelectedItem();

		List<CategoryS> slist = service.selectCategorySByBNoMno(memCateM);
		S = new CategoryS();
		S.setsName("");
		slist.add(0, S);
		modelS = new DefaultComboBoxModel<>(new Vector<>(slist));
		mCBCateS.setModel(modelS);
		mCBCateM.setSelectedItem(S);
		mCBCateS.setEnabled(true);
		memCateMview = true;
	}

	protected void do_mCBKindsCate_itemStateChanged(ItemEvent e) {
		if (mCBKindsCate.getSelectedItem().equals("장르별")) {
			mCBCateB.setEnabled(true);
			return;
		}
		if (mCBKindsCate.getSelectedItem().equals("전체")) {
			mCBCateB.setEnabled(false);
			mCBCateM.setEnabled(false);
			mCBCateS.setEnabled(false);
			return;
		}
	}

	protected void do_mCBCateS_itemStateChanged(ItemEvent e) {
		if (mCBCateS.getSelectedItem().equals(S)) {
			memCateSview = false;
			return;
		}
		memCateS = (CategoryS) mCBCateS.getSelectedItem();
		memCateSview = true;
	}

	protected void do_BCBKindsDate_itemStateChanged(ItemEvent e) {
		if (BCBKindsDate.getSelectedItem().equals("년별")) {
			bspinnerYear.setEnabled(true);
			bspinnerMonth.setEnabled(false);
		}
		if (BCBKindsDate.getSelectedItem().equals("월별")) {
			bspinnerYear.setEnabled(true);
			bspinnerMonth.setEnabled(true);

		}
		if (BCBKindsDate.getSelectedItem().equals("전체")) {
			bspinnerYear.setEnabled(false);
			bspinnerMonth.setEnabled(false);
		}
	}

	protected void do_MCBKindsDate_itemStateChanged(ItemEvent e) {
		if (MCBKindsDate.getSelectedItem().equals("년별")) {
			mspinnerYear.setEnabled(true);
			mspinnerMonth.setEnabled(false);
		}
		if (MCBKindsDate.getSelectedItem().equals("월별")) {
			mspinnerYear.setEnabled(true);
			mspinnerMonth.setEnabled(true);

		}
		if (MCBKindsDate.getSelectedItem().equals("전체")) {
			mspinnerYear.setEnabled(false);
			mspinnerMonth.setEnabled(false);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnChangegraph) {
			do_btnChangegraph_actionPerformed(e);
		}
		if (e.getSource() == btnmember) {
			do_btnmember_actionPerformed(e);
		}
		if (e.getSource() == btnBook) {
			do_btnBook_actionPerformed(e);
		}
		if (e.getActionCommand().equals("상새정보보기")) {
			do_Bookdtail_actionPerformed(e);
		}
	}

	protected void do_btnBook_actionPerformed(ActionEvent e) {
		String title = "";
		String year = "";
		String lastYear = "";
		Date date;
		Calendar cal = Calendar.getInstance();
		Map<String, Object> nowMap = new HashMap<String, Object>();
		Map<String, Object> lastMap = new HashMap<String, Object>();
		if (bspinnerYear.isEnabled()) {
			date = (Date) bspinnerYear.getValue();
			cal.setTime(date);
			year = cal.get(Calendar.YEAR) + "-";
			lastYear = year;
			title = cal.get(Calendar.YEAR) + "년";
			nowMap.put("rentalDate", year);
			lastMap.put("rentalDate", lastYear);
			if(BCBKindsDate.getSelectedItem()=="년별") {						
				lastYear = (Integer.parseInt((cal.get(Calendar.YEAR))+"")-1)+"-";
				lastMap.put("rentalDate", lastYear);
			}
			if(BCBKindsDate.getSelectedItem()=="월별") {
				date = (Date) bspinnerMonth.getValue();
				cal.setTime(date);
				if(Integer.parseInt((cal.get(Calendar.MONTH)+1) +"")==1) {
					date = (Date) bspinnerYear.getValue();
					cal.setTime(date);
					lastYear = (Integer.parseInt((cal.get(Calendar.YEAR))+"")-1)+"-";
				}
				
			}
			
			now = year;
			
			last = lastYear;
		}
		if (bspinnerMonth.isEnabled()) {
			date = (Date) bspinnerMonth.getValue();
			cal.setTime(date);
						
			if(((cal.get(Calendar.MONTH)+1+"").trim()).length()==1) {
				year = year +"0"+ (cal.get(Calendar.MONTH)+1);				
			}else {
				year = year + (cal.get(Calendar.MONTH) + 1);
			}
			title = title + (cal.get(Calendar.MONTH) + 1) + "월 ";
			nowMap.put("rentalDate", year);
			if(BCBKindsDate.getSelectedItem()=="월별") {
				if(Integer.parseInt((cal.get(Calendar.MONTH)+1) +"")==1) {
					lastYear = lastYear + "12";					
				}else {
					
					if(((cal.get(Calendar.MONTH)+"").trim()).length()==1) {
						lastYear = lastYear + "0" + (cal.get(Calendar.MONTH));
					}else {
						lastYear = lastYear + (cal.get(Calendar.MONTH));
					}
				}
				lastMap.put("rentalDate", lastYear);
			}
			now = year;
			last = lastYear;
			
		}
		if (BCBKindsCate.getSelectedItem().equals("장르별")) {
			try {
				if (bookCateB.getbName().equals("")) {
					JOptionPane.showMessageDialog(null, "장르를선택해주세요");
					return;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "장르를선택해주세요");
				return;
			}

		}

		if (bookCateBview) {
			String b = (bookCateB.getbCode() + "").trim();
			title = title + " " + bookCateB.getbName();
			nowMap.put("cateBNo", b);
			lastMap.put("cateBNo", b);
		}
		if (bookCateMview) {
			String m = (bookCateM.getmCode() + "").trim();
			title = title + ">" + bookCateM.getmName() + "";
			nowMap.put("cateMNo", m);
			lastMap.put("cateMNo", m);
		}
		if (bookCateSview) {
			String s = (bookCateS.getsCode() + "").trim();
			title = title + ">" + bookCateS.getsName() + "";
			nowMap.put("cateSNo", s);
			lastMap.put("cateSNo", s);
		}
		Best10BookLists = bestService.selectBookBest10ByMap(nowMap);
		
		List<String> bookCodes = new ArrayList<>();
		for(int i=0; i<Best10BookLists.size(); i++) {		
			bookCodes.add(Best10BookLists.get(i).getBookCode().getBookCode());						
		}
		lastMap.put("bookCodes", bookCodes);
		
		try {
			best10BookListsLast = bestService.selectBookBest10ByMap(lastMap);
		} catch (Exception e2) {
			/*JOptionPane.showMessageDialog(null,"지난달 기록이없습니다.");*/
			lastMap.remove("bookCodes");
			best10BookListsLast = bestService.selectBookBest10ByMap(lastMap);
		}
		
		if(BCBKindsDate.getSelectedItem()=="전체") {			
			now = "전체";
		}else {
			Platform.runLater(() -> {pBarChart.setChartDataLast(best10BookListsLast,last);});
		}
		title = title + "Book Best10!";
		pBarChart.setTitle(title);
		Platform.runLater(() -> {pBarChart.setChartDataThis(Best10BookLists,now);});		
		
		Platform.runLater(() -> initFX(pBarChart));
		
		
		titledBorder = new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), title,
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelForBTable.setBorder(titledBorder);
		panelForBTable.revalidate();
		panelForBTable.setLists(Best10BookLists);
		panelForBTable.loadDatas();

	}

	protected void do_btnmember_actionPerformed(ActionEvent e) {
		String title = "";
		String year = "";
		String lastYear = "";
		Date date;
		Calendar cal = Calendar.getInstance();
		Map<String, Object> nowMap = new HashMap<String, Object>();
		Map<String, Object> lastMap = new HashMap<String, Object>();
		if (mspinnerYear.isEnabled()) {
			date = (Date) mspinnerYear.getValue();
			cal.setTime(date);
			year = cal.get(Calendar.YEAR) + "-";
			lastYear = year;
			title = cal.get(Calendar.YEAR) + "년";
			nowMap.put("rentalDate", year);
			lastMap.put("rentalDate", lastYear);
			if(MCBKindsDate.getSelectedItem()=="년별") {						
				lastYear = (Integer.parseInt((cal.get(Calendar.YEAR))+"")-1)+"-";
				lastMap.put("rentalDate", lastYear);
			}
			if(MCBKindsDate.getSelectedItem()=="월별") {
				date = (Date) mspinnerMonth.getValue();
				cal.setTime(date);
				if(Integer.parseInt((cal.get(Calendar.MONTH)+1) +"")==1) {
					date = (Date) mspinnerYear.getValue();
					cal.setTime(date);
					lastYear = (Integer.parseInt((cal.get(Calendar.YEAR))+"")-1)+"-";
				}
				
			}
			
			now = year;
			
			last = lastYear;
		}
		if (mspinnerMonth.isEnabled()) {
			date = (Date) mspinnerMonth.getValue();
			cal.setTime(date);
						
			if(((cal.get(Calendar.MONTH)+1+"").trim()).length()==1) {
				year = year +"0"+ (cal.get(Calendar.MONTH)+1);				
			}else {
				year = year + (cal.get(Calendar.MONTH) + 1);
			}
			title = title + (cal.get(Calendar.MONTH) + 1) + "월 ";
			nowMap.put("rentalDate", year);
			if(MCBKindsDate.getSelectedItem()=="월별") {
				if(Integer.parseInt((cal.get(Calendar.MONTH)+1) +"")==1) {
					lastYear = lastYear + "12";					
				}else {
					
					if(((cal.get(Calendar.MONTH)+"").trim()).length()==1) {
						lastYear = lastYear + "0" + (cal.get(Calendar.MONTH));
					}else {
						lastYear = lastYear + (cal.get(Calendar.MONTH));
					}
				}
				lastMap.put("rentalDate", lastYear);
			}
			now = year;
			last = lastYear;
			
		}
		if (mCBKindsCate.getSelectedItem().equals("장르별")) {
			try {
				if (memCateB.getbName().equals("")) {
					JOptionPane.showMessageDialog(null, "장르를선택해주세요");
					return;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "장르를선택해주세요");
				return;
			}

		}

		if (memCateBview) {
			String b = (memCateB.getbCode() + "").trim();
			title = title + " " + memCateB.getbName();
			nowMap.put("cateBNo", b);
			lastMap.put("cateBNo", b);
		}
		if (memCateMview) {
			String m = (memCateM.getmCode() + "").trim();
			title = title + ">" + memCateM.getmName() + "";
			nowMap.put("cateMNo", m);
			lastMap.put("cateMNo", m);
		}
		if (memCateSview) {
			String s = (memCateS.getsCode() + "").trim();
			title = title + ">" + memCateS.getsName() + "";
			nowMap.put("cateSNo", s);
			lastMap.put("cateSNo", s);
		}
		best10MemberListsNow = bestService.selectMemberBest10ByMap(nowMap);
		
		List<String> memberNos = new ArrayList<>();
		for(MemberBest10 memberBest10 : best10MemberListsNow) {		
			memberNos.add(memberBest10.getMemberNo().getMemberNo());						
		}
		lastMap.put("memberNos", memberNos);
		
		try {
			best10MemberListsLast = bestService.selectMemberBest10ByMap(lastMap);
		} catch (Exception e2) {
			/*JOptionPane.showMessageDialog(null,"지난달 기록이없습니다.");*/
			lastMap.remove("memberNos");
			best10MemberListsLast = bestService.selectMemberBest10ByMap(lastMap);
		}
		
		if(MCBKindsDate.getSelectedItem()=="전체") {			
			now = "전체";
		}else {
			Platform.runLater(() -> {panelForMTable.setChartDataLast(best10MemberListsLast,last);});
		}
		title = title + "Best 회원 TOP10!";
		panelForMTable.setTitle(title);
		Platform.runLater(() -> {panelForMTable.setChartDataThis(best10MemberListsNow,now);});	
						
		Platform.runLater(() -> initFX(panelForMTable));
			
	}

	private void do_Bookdtail_actionPerformed(ActionEvent e) {

		try {
			Book selectedBook = panelForBTable.getSelectedBookBest();
			String bookCode = "";
			boolean RentalPossible = false;
			Book book = new Book();

			BookLists = service.selectbookbybookCode(selectedBook);
			int totalBook = BookLists.size();
			if (BookLists.size() > 1) {
				for (Book books : BookLists) {
					if (books.isRentalPossible()) {
						RentalPossible = true;
					}
					bookCode = bookCode + books.getBookCode() + ",";
					book = books;
				}
			} else {
				for (Book books : BookLists) {
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
			bookDetailUI.setBookInfo(book, totalBook, BookLists);
			bookDetailUI.setVisible(true);
			bookDetailUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "선택하신책정보가 없습니다.");

		}

	}

	private JPopupMenu getPopupMenu() {
		JPopupMenu popupMenu = new JPopupMenu();

		JMenuItem mntmAdd = new JMenuItem("상새정보보기");
		mntmAdd.addActionListener(this);
		popupMenu.add(mntmAdd);

		return popupMenu;
	}

	protected void do_btnChangegraph_actionPerformed(ActionEvent e) {
		if(btnChangegraph.getText().equals("라인그래프보기")==false) {
			btnChangegraph.setText("라인그래프보기");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			Date date = new Date();
			year = "";
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);			
			year = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1);
			map.put("date", year);
			/*double sum = bestService.*//////////////////////////////////////////////////////////////////////////////
			
			panelPieChartbest10 = new PanelPieChartbest10();
			panel_10.remove(pLineChart);
			/*pLineChart.remove();*/		
			panel_10.add(panelPieChartbest10, BorderLayout.CENTER);
			Platform.runLater(() -> initFX(panelPieChartbest10));
		}else {
			btnChangegraph.setText("파이그래프보기");
			pLineChart = new CatePanelLineChartBest();
			panel_10.remove(panelPieChartbest10);
			Platform.runLater(() -> {pLineChart.setList(listlists);});			
			panel_10.add(pLineChart, BorderLayout.CENTER);
			Platform.runLater(() -> initFX(pLineChart));
		}
		/*panelPieChartbest10 = new PanelPieChartbest10();
		panel_10.remove(pLineChart);*/
		/*pLineChart.remove();*/
		
		/*panel_10.add(panelPieChartbest10, BorderLayout.CENTER);
		Platform.runLater(() -> initFX(panelPieChartbest10));*/
	}
}

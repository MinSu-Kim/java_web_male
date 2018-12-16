package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.service.LibraryUIService;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class BestUI extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JSpinner bspinnerYear;
	private JSpinner bspinnerMonth;
	private DefaultComboBoxModel<CategoryB> modelB;
	private DefaultComboBoxModel<CategoryM> modelM;
	private DefaultComboBoxModel<CategoryS> modelS;
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
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setTitle("Best");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC774\uBC88\uB2EC Best10!", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		JPanel panelForBTable = new JPanel();
		panel.add(panelForBTable, BorderLayout.CENTER);
		panelForBTable.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_5.add(panel_16);
		
		JLabel lblNewLabel = new JLabel("분류방법을선택하세요(년,월)");
		panel_16.add(lblNewLabel);
		
		String[] KindsDatestrArr = {"년별", "월별", "전체"};
		DefaultComboBoxModel<String> Datemodel = new DefaultComboBoxModel<>(KindsDatestrArr);
		BCBKindsDate = new JComboBox<>(Datemodel);
		BCBKindsDate.addItemListener(this);
		panel_16.add(BCBKindsDate);
		BCBKindsDate.setSelectedIndex(1);
		
		JPanel panel_17 = new JPanel();
		panel_5.add(panel_17);
		
		bspinnerYear = new JSpinner();
		bspinnerYear.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		bspinnerYear.setEditor(new JSpinner.DateEditor(bspinnerYear,"yyyy"));
		panel_17.add(bspinnerYear);
		
		bspinnerMonth = new JSpinner();
		bspinnerMonth.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		bspinnerMonth.setEditor(new JSpinner.DateEditor(bspinnerMonth,"MM"));
		bspinnerMonth.setEnabled(true);
		panel_17.add(bspinnerMonth);
		
		bspinnerYear.setVisible(false);
		bspinnerMonth.setVisible(false);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_6.add(panel_18);
		
		JLabel lblNewLabel_2 = new JLabel("분류방법을선택하세요(장르)");
		panel_18.add(lblNewLabel_2);
		
		String[] KindsCatestrArr = {"전체","장르별"};
		DefaultComboBoxModel<String> Catemodel = new DefaultComboBoxModel<>(KindsCatestrArr);
		BCBKindsCate = new JComboBox<>(Catemodel);		
		BCBKindsCate.addItemListener(this);
		panel_18.add(BCBKindsCate);
		
		
		JPanel panel_19 = new JPanel();
		panel_6.add(panel_19);
		panel_19.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JLabel lblNewLabel_3 = new JLabel("대");
		panel_19.add(lblNewLabel_3);
		
		
		List<CategoryB> blist = service.selectCategoryBByAll();
		B = new CategoryB();
		B.setbName("");
		blist.add(0, B);
		modelB = new DefaultComboBoxModel<>(new Vector<>(blist));		
		bCBCateB = new JComboBox(modelB);
		bCBCateB.setEnabled(false);
		bCBCateB.setSelectedItem(B);
		bCBCateB.addItemListener(this);
		panel_19.add(bCBCateB);
		
		JLabel lblNewLabel_1 = new JLabel("중");
		panel_19.add(lblNewLabel_1);
		
		bCBCateM = new JComboBox();
		bCBCateM.setEnabled(false);
		bCBCateM.addItemListener(this);
		panel_19.add(bCBCateM);
		
		JLabel lblNewLabel_12 = new JLabel("소");
		panel_19.add(lblNewLabel_12);
		
		bCBCateS = new JComboBox();
		bCBCateS.setEnabled(false);
		bCBCateS.addItemListener(this);
		panel_19.add(bCBCateS);
		
		JButton btnBook = new JButton("검색");
		panel_19.add(btnBook);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNewLabel_10 = new JLabel("그래프");
		panel_7.add(lblNewLabel_10);
		
		JPanel panelForBGrap = new JPanel();
		panel_1.add(panelForBGrap, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "\uC774\uB2EC\uC758 \uB2E4\uB3C5\uC655", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		contentPane.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11, BorderLayout.NORTH);
		
		JPanel panelForMTable = new JPanel();
		panel_9.add(panelForMTable, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_9.add(panel_13, BorderLayout.EAST);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_13.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_26 = new JPanel();
		panel_14.add(panel_26);
		
		JLabel label = new JLabel("분류방법을선택하세요(년,월)");
		panel_26.add(label);
		
		
		DefaultComboBoxModel<String> MDatemodel = new DefaultComboBoxModel<>(KindsDatestrArr);
		MCBKindsDate = new JComboBox<>(MDatemodel);		
		MCBKindsDate.addItemListener(this);
		MCBKindsDate.setSelectedIndex(1);				
		panel_26.add(MCBKindsDate);
		
		JPanel panel_27 = new JPanel();
		panel_14.add(panel_27);
				
		mspinnerYear = new JSpinner();
		mspinnerYear.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		mspinnerYear.setEditor(new JSpinner.DateEditor(mspinnerYear,"yyyy"));
		panel_27.add(mspinnerYear);
		
		mspinnerMonth = new JSpinner();
		mspinnerMonth.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		mspinnerMonth.setEditor(new JSpinner.DateEditor(mspinnerMonth,"MM"));
		mspinnerMonth.setEnabled(true);
		panel_27.add(mspinnerMonth);
		
		
		JPanel panel_28 = new JPanel();
		panel_13.add(panel_28);
		panel_28.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_29 = new JPanel();
		panel_28.add(panel_29);
		
		JLabel label_1 = new JLabel("분류방법을선택하세요(장르)");
		panel_29.add(label_1);
		
		DefaultComboBoxModel<String> CatemodelM = new DefaultComboBoxModel<>(KindsCatestrArr);
		mCBKindsCate = new JComboBox(CatemodelM);
		mCBKindsCate.addItemListener(this);
		panel_29.add(mCBKindsCate);
		
		JPanel panel_30 = new JPanel();
		panel_28.add(panel_30);
		
		JLabel label_2 = new JLabel("대");
		panel_30.add(label_2);
				
		MmodelB = new DefaultComboBoxModel<>(new Vector<>(blist));
		
		mCBCateB = new JComboBox(MmodelB);
		mCBCateB.setEnabled(false);
		mCBCateB.addItemListener(this);
		bCBCateB.setEnabled(false);
		bCBCateB.setSelectedItem(B);
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
		
		JButton btnmember = new JButton("검색");
		panel_30.add(btnmember);
		
		JPanel panel_10 = new JPanel();
		contentPane.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_10.add(panel_15, BorderLayout.NORTH);
		
		JLabel lblNewLabel_11 = new JLabel("그래프");
		panel_15.add(lblNewLabel_11);
		
		JPanel panelForMGrap = new JPanel();
		panel_10.add(panelForMGrap, BorderLayout.CENTER);
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
		if(BCBKindsDate.getSelectedItem().equals("년별")) {
			bspinnerYear.setVisible(true);
			bspinnerMonth.setVisible(false);
		}
		if(BCBKindsDate.getSelectedItem().equals("월별")) {			
			
			
		}
		if(BCBKindsDate.getSelectedItem().equals("전체")) {
			bspinnerYear.setVisible(false);
			bspinnerMonth.setVisible(false);
		}
	}
	protected void do_MCBKindsDate_itemStateChanged(ItemEvent e) {
		if(MCBKindsDate.getSelectedItem().equals("년별")) {
			mspinnerYear.setVisible(true);
			mspinnerMonth.setVisible(false);
		}
		if(MCBKindsDate.getSelectedItem().equals("월별")) {
		
			
		}
		if(MCBKindsDate.getSelectedItem().equals("전체")) {
			mspinnerYear.setVisible(false);
			mspinnerMonth.setVisible(false);
		}
	}
}

package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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

import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.service.LibraryUIService;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
	private JComboBox comboBoxCatMNo;

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
		setBounds(100, 100, 795, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uAE30\uD0C0\uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JRadioButton RadioSelectOther = new JRadioButton("");
		buttonGroup.add(RadioSelectOther);
		panel.add(RadioSelectOther, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 20));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 7, 0, 0));
		
		JCheckBox chckbxCategory = new JCheckBox("");
		chckbxCategory.setFont(new Font("굴림체", Font.BOLD, 20));
		chckbxCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(chckbxCategory);
		
		JLabel lblNewLabel_6 = new JLabel("대분류");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 20));
		panel_3.add(lblNewLabel_6);
		
		
		DefaultComboBoxModel<CategoryB> modelB = new DefaultComboBoxModel<>(new Vector<>(service.selectCategoryBByAll()));
		
		comboBoxCateBNo = new JComboBox(modelB);
		comboBoxCateBNo.addItemListener(new ItemListener() {
			//대분류가 선택되었을때
			public void itemStateChanged(ItemEvent e) {
				CategoryB cateB = (CategoryB) comboBoxCateBNo.getSelectedItem();
				//분류번호확인
				/*JOptionPane.showInputDialog(cateB.getbCode()+"/"+cateB.getbName());*/
				
				int i =cateB.getbCode();
				modelM = new DefaultComboBoxModel<>(new Vector<>(service.selectCategoryMByBNo(cateB)));
				comboBoxCatMNo.setModel(modelM);
			}
		});
		panel_3.add(comboBoxCateBNo);
		
		JLabel lblNewLabel_1 = new JLabel("중분류");
		lblNewLabel_1.setFont(new Font("굴림체", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);
		
		
		
		modelM = new DefaultComboBoxModel<>(new Vector<>(service.selectCategoryMByAll()));
		
		comboBoxCatMNo = new JComboBox(modelM);
		panel_3.add(comboBoxCatMNo);
		
		JLabel lblNewLabel_2 = new JLabel("소분류");
		lblNewLabel_2.setFont(new Font("굴림체", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);
		
		DefaultComboBoxModel<CategoryS> modelS = new DefaultComboBoxModel<>(new Vector<>(service.selectCategorySByAll()));
		
		JComboBox comboBoxCateSNo = new JComboBox(modelS);
		panel_3.add(comboBoxCateSNo);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 7, 0, 0));
		
		JCheckBox chckbxPublisher = new JCheckBox("");
		chckbxPublisher.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxPublisher.setFont(new Font("굴림체", Font.BOLD, 20));
		panel_4.add(chckbxPublisher);
		
		JLabel lblNewLabel_5 = new JLabel("출판사");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 20));
		panel_4.add(lblNewLabel_5);
		
		JComboBox comboBoxPublisher = new JComboBox();
		panel_4.add(comboBoxPublisher);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 7, 0, 0));
		
		JCheckBox chckbxAuthor = new JCheckBox("");
		chckbxAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxAuthor.setFont(new Font("굴림체", Font.BOLD, 20));
		panel_7.add(chckbxAuthor);
		
		JLabel lblNewLabel = new JLabel("저자");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		panel_7.add(lblNewLabel);
		
		tfAuthor = new JTextField();
		tfAuthor.setToolTipText("작가를입력하세요");
		panel_7.add(tfAuthor);
		tfAuthor.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 7, 0, 0));
		
		JCheckBox chckbxTranslator = new JCheckBox("");
		chckbxTranslator.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxTranslator.setFont(new Font("굴림체", Font.BOLD, 20));
		panel_8.add(chckbxTranslator);
		
		JLabel lblNewLabel_3 = new JLabel("역자");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 20));
		panel_8.add(lblNewLabel_3);
		
		tfTranslator = new JTextField();
		panel_8.add(tfTranslator);
		tfTranslator.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 7, 0, 0));
		
		JCheckBox chckbxTitle = new JCheckBox("");
		chckbxTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxTitle.setFont(new Font("굴림체", Font.BOLD, 20));
		panel_9.add(chckbxTitle);
		
		JLabel lblNewLabel_4 = new JLabel("제목");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));
		panel_9.add(lblNewLabel_4);
		
		tfTitle = new JTextField();
		panel_9.add(tfTitle);
		tfTitle.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_5.setBorder(new TitledBorder(null, "Book Code\uB85C\uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_5);
		
		JRadioButton RadioSelectCode = new JRadioButton("코드");
		buttonGroup.add(RadioSelectCode);
		panel_5.add(RadioSelectCode);
		
		tfCode = new JTextField();
		panel_5.add(tfCode);
		tfCode.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_6);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		panel_6.add(btnNewButton);
	}

}

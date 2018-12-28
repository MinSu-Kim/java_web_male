package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.yi.java_web_male.dto.BookBest10;
import kr.or.yi.java_web_male.dto.OverduePopup;
import kr.or.yi.java_web_male.service.OverduePopUpUIService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OverduePopUpUI extends JFrame implements ActionListener {
	
	private NonEditableModel model;
	private JScrollPane scrollPane;	
	private JPanel contentPane;
	private JTable table;
	private int rank =0;
	private List<OverduePopup> lists;
	private OverduePopUpUIService service;
	private JButton btnClose;
	private JCheckBox chckbxToday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OverduePopUpUI frame = new OverduePopUpUI();
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
	public OverduePopUpUI() {
		setTitle("연체자 명단");
		service = new OverduePopUpUIService();
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		lists = service.selectAll();
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"이름", "도서명", "대여일자", "반납예정일", "연체일수", "전화번호"
				}
			));
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한 row만 선택가능
			table.setPreferredScrollableViewportSize(table.getPreferredSize());
		scrollPane.setViewportView(table);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnClose = new JButton("닫기");
		btnClose.addActionListener(this);
		panel.add(btnClose);
		
		chckbxToday = new JCheckBox("오늘 하루동안 보이지 않게 하기");
		panel.add(chckbxToday);
		loadDatas();
	}
	public void loadDatas() {
		model = new NonEditableModel(getDatas(), getColumnNames());
		table.setModel(model);
	}
	public Object[][] getDatas() {
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = getOverduePopupArray(lists.get(i));
		}
		return datas;
		
	}
	public String[] getColumnNames() {
		return new String[] { "이름", "도서명", "대여일자", "반납예정일", "연체일수", "전화번호"};
	}
	private Object[] getOverduePopupArray(OverduePopup overduePopup) {
			        
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");     

		return new Object[] { overduePopup.korName.getKorName(),overduePopup.title.getTitle(),date.format(overduePopup.rentalDate.getRentalDate()),date.format(overduePopup.returnSchedule.getReturnSchedule()),overduePopup.overday,overduePopup.phone.getPhone() };
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClose) {
			do_btnClose_actionPerformed(e);
		}
	}
	protected void do_btnClose_actionPerformed(ActionEvent e) {
		if (chckbxToday.isSelected()) {
			service.updatedat();
			
		}
		dispose();
	}
}

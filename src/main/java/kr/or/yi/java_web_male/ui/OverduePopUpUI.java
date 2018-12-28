package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.yi.java_web_male.dto.BookBest10;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class OverduePopUpUI extends JFrame {
	
	private List<BookBest10> lists;
	private NonEditableModel model;
	private JScrollPane scrollPane;	
	private JPanel contentPane;
	private JTable table;
	private int rank =0;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblList = new JLabel("연체자 명단");
		contentPane.add(lblList, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
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
		
		JButton btnClose = new JButton("닫기");
		panel.add(btnClose);
		
		JCheckBox chckbxToday = new JCheckBox("오늘 하루동안 보이지 않게 하기");
		panel.add(chckbxToday);
	}
	public void loadDatas() {
		model = new NonEditableModel(getDatas(), getColumnNames());
		table.setModel(model);
	}
	public Object[][] getDatas() {
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = getBookBest10Array(lists.get(i));
		}
		return datas;
		
	}
	public String[] getColumnNames() {
		return new String[] { "이름", "도서명", "대여일자", "반납예정일", "연체일수", "전화번호"};
	}
	private Object[] getBookBest10Array(BookBest10 bb10) {
		rank = rank + 1;
		bb10.getAuthor().getAuthor();
		return new Object[] { rank, bb10.getBookCode().getBookCode(),bb10.getTitle().getTitle(), bb10.getAuthor().getAuthor(), bb10.getPubName().getPubName(),bb10.getRanking() };
	}

}

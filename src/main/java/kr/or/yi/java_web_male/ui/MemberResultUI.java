package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.List;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.yi.java_web_male.dto.Member;

public class MemberResultUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private List<Member> list;
	public void setLists(List<Member> list) {
		this.list = list;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberResultUI frame = new MemberResultUI();
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
	public MemberResultUI() {
		setTitle("검색결과");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBackground(Color.MAGENTA);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("굴림", Font.PLAIN, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("검색결과");
		panel.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));*/
		contentPane.add(table, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
	}
	public void loadData() {
		table.setModel(new DefaultTableModel(
				getdatas(),
				getCoulum()
				));
	}
	private Object[] getCoulum() {
		return new String[] {"이름","전화번호","생년월일"};
	}

	private Object[][] getdatas() {
		Object[][] datas = new Object[list.size()][];
		for(int i=0; i<list.size(); i++) {
			datas[i]=getRow(list.get(i));
		}
		return datas;
	}

	private Object[] getRow(Member member) {
		return new Object[] {member.getKorName(),member.getPhone(),member.getJumin()};
	}

}

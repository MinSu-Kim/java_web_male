package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.service.MemberUIService;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberSearchUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private MemberSearchResult Slist;
	private MemberUIService service;
	private BookRentUI bookRentUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSearchUI frame = new MemberSearchUI();
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
	
	
	public MemberSearchUI() {
		service = new MemberUIService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel Result_panel = new JPanel();
		contentPane.add(Result_panel, BorderLayout.CENTER);
		
		JPanel Search_panel = new JPanel();
		contentPane.add(Search_panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("검색조건");
		Search_panel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"회원번호", "이름", "생년월일"}));
		Search_panel.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		Search_panel.add(textField);
		
		JButton button = new JButton("검색");
		Search_panel.add(button);
		
		Slist = new MemberSearchResult();
		Slist.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					Member member = Slist.selectedItem();
					bookRentUI.setMemberNo(member);
					MemberSearchUI.this.dispose();
					
				}
			}
			
		});
		
		
		
		Slist.setLists(service.selectMemberByAll());
		Slist.loadData();
		contentPane.add(Slist);
	}
	
	public void setBookRentUI(BookRentUI bookRentUI) {
		this.bookRentUI = bookRentUI;
		
	}

}

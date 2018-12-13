package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ComboBox;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.service.MemberUIService;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class MemberSearchUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private MemberSearchResult Slist;
	private MemberUIService service;
	private JPanel ResultPanel;
	private JComboBox<String> comboBox;
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
		
		JPanel Searchpanel = new JPanel();
		contentPane.add(Searchpanel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("검색조건");
		Searchpanel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"회원번호", "이름", "전화번호"}));
		Searchpanel.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		Searchpanel.add(textField);
		
		Slist = new MemberSearchResult();
		contentPane.add(Slist, BorderLayout.CENTER);
		
		JButton button = new JButton("검색");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textField.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "입력해주세요");
					return;
				}
				try {
					if(comboBox.getSelectedItem().equals("회원번호")) {
						searchNo();
					}else if(comboBox.getSelectedItem().equals("이름")) {
						searchName();
					}else if(comboBox.getSelectedItem().equals("전화번호")){
						searchPhone();
					}
				}catch(NullPointerException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");					
				}
							
				
			}

			private void searchNo() {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("memberNo", ((String)textField.getText()));
				Member member = service.searchMemberNo(map);
				List<Member> list = new ArrayList<>();
				list.add(member);
				Slist.setLists(list);
				Slist.loadData();
			}
			private void searchName(){
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("korName", ((String)textField.getText()));
				Member member = service.searchMemberName(map);
				List<Member> list = new ArrayList<>();
				list.add(member);
				Slist.setLists(list);
				Slist.loadData();
			}
			private void searchPhone() {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("phone", ((String)textField.getText()));
				Member member = service.searchMemberPhone(map);
				List<Member> list = new ArrayList<>();
				list.add(member);
				Slist.setLists(list);
				Slist.loadData();
			}
		});
		Searchpanel.add(button);
		
		
		
	/*	Slist = new MemberSearchResult();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("memberNo", "3");
		Member member = service.searchMemberNo(map);
		List<Member> list = new ArrayList<>();
		list.add(member);
		Slist.setLists(list);
=======
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
>>>>>>> branch 'master' of https://github.com/MinSu-Kim/java_web_male.git
		Slist.loadData();
		contentPane.add(Slist);*/
	}
	
	public void setBookRentUI(BookRentUI bookRentUI) {
		this.bookRentUI = bookRentUI;
		
	}

}

package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.PopupMenu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import javafx.scene.control.ComboBox;
import kr.or.yi.java_web_male.dao.OverdueMapper;
import kr.or.yi.java_web_male.dao.OverdueMapperImpl;
import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.Overdue;
import kr.or.yi.java_web_male.service.MemberUIService;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class MemberSearchUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private MemberSearchResult Slist;
	private MemberUIService service;
	private JPanel ResultPanel;
	private JComboBox<String> comboBox;
	private BookRentUI bookRentUI;
	private MemberSearchDetail memberDetailUI;
	private Overdue overdue;
	private OverdueMapper overdueMapper;
	private MemberRent memberRent;
	private JPanel pContent;
	private JPanel p_rent;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */

	public MemberSearchUI() {
		setTitle("회원검색");
		overdueMapper = OverdueMapperImpl.getInstance();
		service = new MemberUIService();
		memberDetailUI = new MemberSearchDetail();
		memberRent = new MemberRent();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel Searchpanel = new JPanel();
		contentPane.add(Searchpanel, BorderLayout.NORTH);

		JLabel label = new JLabel("검색조건");
		Searchpanel.add(label);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "회원번호", "이름", "전화번호" }));
		Searchpanel.add(comboBox);

		textField = new JTextField();
		textField.setColumns(10);
		Searchpanel.add(textField);

		Slist = new MemberSearchResult();

		contentPane.add(Slist, BorderLayout.CENTER);
		Slist.setLists(service.selectMemberByAll());
		Slist.loadData();
		Slist.setPopupMenu(getPopupMenu());
		JButton button = new JButton("검색");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textField.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "입력해주세요");
					cleartf();
					return;
				}
				try {
					if (comboBox.getSelectedItem().equals("회원번호")) {
						searchNo();
					} else if (comboBox.getSelectedItem().equals("이름")) {
						searchName();
					} else if (comboBox.getSelectedItem().equals("전화번호")) {
						searchPhone();
					}
				} catch (NullPointerException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
				}

			}

			private void cleartf() {
				// TODO Auto-generated method stub
				
			}
		});// end of action
		Searchpanel.add(button);
		
		btnNewButton = new JButton("초기화");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Slist.setLists(service.selectMemberByAll());
				Slist.loadData();
				
				if (p_rent.getComponents().length == 1) {
					p_rent.remove(0);
				}
			}
		});
		Searchpanel.add(btnNewButton);
		Slist.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if(e.getClickCount()==2) {
					/*JOptionPane.showMessageDialog(null, "2번클릭");*/
					Member member = Slist.selectedItem();
					/*
					 * Overdue의 memberNo(String형태)의 값이 member(Member형태)인 rentalAuthority의 값이 false면
					 * 실행 안되도록 설정
					 */
					String mNo = String.valueOf(member);
					Overdue overdue = new Overdue();
					overdue.setMemberNo(mNo);
					Overdue overdue1 = overdueMapper.selectOverdueByMemberNo(overdue);
					if (overdue1.isRentalAuthority() == true) {
						JOptionPane.showMessageDialog(null, "대여 가능한 회원입니다.");
						bookRentUI.setMemberNo(member);
						bookRentUI.setText();
						MemberSearchUI.this.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "대여 불가능한 회원입니다.");
						return;
					}

				}
			}

		});
		Slist.setPopupMenu(getPopupMenu());

		pContent = new JPanel();
		Slist.add(pContent, BorderLayout.SOUTH);
		pContent.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		p_rent = new JPanel();
		pContent.add(p_rent);
	}

	private void searchNo() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("memberNo", textField.getText());
		List<Member> member = service.searchMemberNo(map);
		List<Member> list = new ArrayList<>();
		list.addAll(member);
		Slist.setLists(list);
		Slist.loadData();
	}

	private void searchName() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("korName", textField.getText());
		List<Member> member = service.searchMemberName(map);
		List<Member> list = new ArrayList<>();
		list.addAll(member);
		Slist.setLists(list);
		Slist.loadData();

	}

	private void searchPhone() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("phone", textField.getText());
		List<Member> member = service.searchMemberPhone(map);
		List<Member> list = new ArrayList<>();
		list.addAll(member);
		Slist.setLists(list);
		Slist.loadData();
	}
	private JPopupMenu getPopupMenu() {
		JPopupMenu popupMenu = new JPopupMenu();

		JMenuItem mntDetail = new JMenuItem("상세보기");
		mntDetail.addActionListener(menuListener);
		popupMenu.add(mntDetail);

		JMenuItem mntRent = new JMenuItem("도서대여보기");
		mntRent.addActionListener(menuListener);
		popupMenu.add(mntRent);
		return popupMenu;
	}

	ActionListener menuListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("상세보기")) {
				do_showMemberDetail(e);
				memberDetailUI.setVisible(true);
			} else {
				do_showMemberRent(e);
				MemberSearchUI.this.revalidate();/// 화면을 새로추가해줌
				JOptionPane.showMessageDialog(null, e.getActionCommand());
			}

		}

		private void do_showMemberDetail(ActionEvent e) {
			Member mem = Slist.getSelectedMember();
			memberDetailUI.setLists(service.selectMemberByNo(mem));
		}

		private void do_showMemberRent(ActionEvent e) {

			Member mem = Slist.getSelectedMember();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("memberNo", String.valueOf(mem));
			List<Member> Rlist = service.searchMembernoRent(map);
			MemberRent p = new MemberRent();
			if (p_rent.getComponents().length == 1) {
				p_rent.remove(0);
			}
			p_rent.add(p);
			p.setLists(Rlist);
			p.loadData();
		}

	};
	private JButton btnNewButton;

	public void setBookRentUI(BookRentUI bookRentUI) {
		this.bookRentUI = bookRentUI;
	}

	public void setMemberCode(String MemCoded) {
		// TODO Auto-generated method stub
		textField.setText(MemCoded);
	}

}// end of class;

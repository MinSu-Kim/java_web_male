package kr.or.yi.java_web_male.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

import org.omg.CORBA.UnionMember;

@SuppressWarnings("serial")
public class AdminMainUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnBookInsert;
	private JButton btnBookSearch;
	private JButton btnMemberAdmin;
	private JButton btnRentAdmin;
	private JButton btnLogout;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnUpdate;
	private JButton btnExtendAdmin;
	private JButton btnReturnAdmin;
	private JButton btnOverdue;
	private Map<String, JFrame> uiMaps;
	private JPanel panel_2;
	private JButton btnNewButton;

	public AdminMainUI() {
		uiMaps = new HashMap<>();
		uiMaps.put("bookInsertUI", new BookInsertUI());
		uiMaps.put("bookSearchUI", new BookSearchUI());
		uiMaps.put("memberInfoUI", new MemberInfoUI());
		uiMaps.put("bookRentUI", new BookRentUI());
		uiMaps.put("bookReturnUI", new BookReturnUI());
		uiMaps.put("bookExtendUI", new BookExtendUI());
		uiMaps.put("loginUI", new LoginUI());
		uiMaps.put("overduePopUpUI", new OverduePopUpUI());
		uiMaps.put("memberSearchUI", new MemberSearchUI());
		uiMaps.put("rentalInfoUI", new RentalInfoUI());

		initComponents();
	}

	private void initComponents() {
		setResizable(false);
		setTitle("[관리자] " + LoginUI.getLogin().getKorName() + "님 환영합니다.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(5, 5, 424, 156);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 10, 10));

		btnBookInsert = new JButton("도서 추가");
		panel_3.add(btnBookInsert);

		btnBookSearch = new JButton("도서 검색");
		panel_3.add(btnBookSearch);

		btnMemberAdmin = new JButton("회원 관리");
		panel_3.add(btnMemberAdmin);

		panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "\uB300\uC5EC\uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 10, 0));

		btnRentAdmin = new JButton("도서 대여");
		panel_2.add(btnRentAdmin);

		btnReturnAdmin = new JButton("도서 반납");
		panel_2.add(btnReturnAdmin);

		btnExtendAdmin = new JButton("도서 연장");
		panel_2.add(btnExtendAdmin);
		btnExtendAdmin.addActionListener(this);
		btnReturnAdmin.addActionListener(this);
		btnRentAdmin.addActionListener(this);
		btnMemberAdmin.addActionListener(this);
		btnBookSearch.addActionListener(this);
		btnBookInsert.addActionListener(this);

		panel_1 = new JPanel();
		panel_1.setBounds(5, 171, 424, 33);
		contentPane.add(panel_1);

		btnLogout = new JButton("로그아웃");
		btnLogout.setBounds(331, 5, 81, 23);
		btnLogout.addActionListener(this);
		panel_1.setLayout(null);

		btnOverdue = new JButton("연체자 명단");
		btnOverdue.addActionListener(this);
		btnOverdue.setBounds(129, 5, 97, 23);
		panel_1.add(btnOverdue);
		panel_1.add(btnLogout);

		btnUpdate = new JButton("정보수정");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(238, 5, 81, 23);
		panel_1.add(btnUpdate);

		btnNewButton = new JButton("대여 정보");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(27, 5, 90, 23);
		panel_1.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnOverdue) {
			do_btnOverdue_actionPerformed(e);
		}
		if (e.getSource() == btnUpdate) {
			do_btnUpdate_actionPerformed(e);
		}
		if (e.getSource() == btnLogout) {
			do_btnLogout_actionPerformed(e);
		}
		if (e.getSource() == btnRentAdmin) {
			do_btnRentAdmin_actionPerformed(e);
		}
		if (e.getSource() == btnReturnAdmin) {
			do_btnRenturnAdmin_actionPerformed(e);
		}
		if (e.getSource() == btnExtendAdmin) {
			do_btnExtendAdmin_actionPerformed(e);
		}
		if (e.getSource() == btnMemberAdmin) {
			do_btnMemberAdmin_actionPerformed(e);
		}
		if (e.getSource() == btnBookSearch) {
			do_btnBookSearch_actionPerformed(e);
		}
		if (e.getSource() == btnBookInsert) {
			do_btnBookInsert_actionPerformed(e);
		}
	}

	protected void do_btnBookInsert_actionPerformed(ActionEvent e) {
		uiMaps.get("bookInsertUI").setVisible(true);
	}

	protected void do_btnBookSearch_actionPerformed(ActionEvent e) {
		uiMaps.get("bookSearchUI").setVisible(true);
	}

	protected void do_btnMemberAdmin_actionPerformed(ActionEvent e) {
		uiMaps.get("memberSearchUI").setVisible(true);
	}

	protected void do_btnRentAdmin_actionPerformed(ActionEvent e) {
		uiMaps.get("bookRentUI").setVisible(true);
	}

	protected void do_btnRenturnAdmin_actionPerformed(ActionEvent e) {
		uiMaps.get("bookReturnUI").setVisible(true);
	}

	protected void do_btnExtendAdmin_actionPerformed(ActionEvent e) {
		uiMaps.get("bookExtendUI").setVisible(true);
	}

	protected void do_btnLogout_actionPerformed(ActionEvent e) {
		LoginUI.memberLogOut();
		this.setVisible(false);
		setInvisibles();
		uiMaps.get("loginUI").setVisible(true);
	}

	private void setInvisibles() {
		for (String s : uiMaps.keySet()) {
			uiMaps.get(s).setVisible(false);
		}
	}

	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		uiMaps.get("memberInfoUI").setVisible(true);
	}

	protected void do_btnOverdue_actionPerformed(ActionEvent e) {
		uiMaps.get("overduePopUpUI").setVisible(true);
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		uiMaps.get("rentalInfoUI").setVisible(true);
	}
}

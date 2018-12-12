package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.ui.LoginUI;

@SuppressWarnings("serial")
public class MemberInfoUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfMemberNo;
	private JTextField tfPhone;
	private JTextField tfAddress;
	private JTextField tfKorName;
	private JTextField tfGrade;
	private JTextField tfEngName;
	
	private BookSearchUI bookSearchUI;
	private MemberModUI memberModUI;
	private MemberDetailUI memberDetailUI;
	
	public MemberInfoUI() {
		initComponent();

		System.out.println("다른 클래스에서 호출" + LoginUI.getLogin());
	}

	private void initComponent() {
		setTitle("내 정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 10, 10));

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblMemberNo = new JLabel("회원 번호");
		panel_3.add(lblMemberNo);

		tfMemberNo = new JTextField();
		panel_3.add(tfMemberNo);
		tfMemberNo.setColumns(10);

		JLabel lblPhone = new JLabel("전화번호");
		panel_3.add(lblPhone);

		tfPhone = new JTextField();
		panel_3.add(tfPhone);
		tfPhone.setColumns(10);

		JLabel lblAddress = new JLabel("여기엔");
		panel_3.add(lblAddress);

		tfAddress = new JTextField();
		panel_3.add(tfAddress);
		tfAddress.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblKorName = new JLabel("회원 이름");
		panel_4.add(lblKorName);

		tfKorName = new JTextField();
		tfKorName.setColumns(10);
		panel_4.add(tfKorName);

		JLabel lblGrade = new JLabel("회원등급");
		panel_4.add(lblGrade);

		tfGrade = new JTextField();
		tfGrade.setColumns(10);
		panel_4.add(tfGrade);

		JLabel lblEngName = new JLabel("뭘넣을까");
		panel_4.add(lblEngName);

		tfEngName = new JTextField();
		tfEngName.setColumns(10);
		panel_4.add(tfEngName);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 3, 10, 10));
		
		

		JButton btnMod = new JButton("회원정보수정");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnMod_actionPerformed(e);
			}
		});
		panel_2.add(btnMod);

		JButton btnSearch = new JButton("도서 검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		panel_2.add(btnSearch);

		JButton btnDetail = new JButton("사엣정보");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDetail_actionPerformed(e);
			}
		});
		panel_2.add(btnDetail);
		
		getMemberInfo(LoginUI.getLogin());
	}

	public void getMemberInfo(Member member) {
		tfMemberNo.setText(member.getMemberNo());
		tfPhone.setText(member.getPhone());
		tfAddress.setText(member.getAddress());
		tfKorName.setText(member.getKorName());
		tfEngName.setText(member.getEngName());
		
		tfMemberNo.setEditable(false);
		tfPhone.setEditable(false);
		tfAddress.setEditable(false);
		tfKorName.setEditable(false);
		tfEngName.setEditable(false);
		tfGrade.setEditable(false);
	}
	
	// 회원정보수정 이동
	protected void do_btnMod_actionPerformed(ActionEvent arg0) {
		if (memberModUI == null) {
			memberModUI = new MemberModUI();
		}
		memberModUI.setVisible(true);
	}
	
	// 도서검색 이동
	protected void do_btnSearch_actionPerformed(ActionEvent arg0) {
		if (bookSearchUI == null) {
			bookSearchUI = new BookSearchUI();
		}
		bookSearchUI.setVisible(true);
	}
	
	// 상세정보
	protected void do_btnDetail_actionPerformed(ActionEvent arg0) {
		if (memberDetailUI == null) {
			memberDetailUI = new MemberDetailUI();
		}
		memberDetailUI.setVisible(true);
	}

}

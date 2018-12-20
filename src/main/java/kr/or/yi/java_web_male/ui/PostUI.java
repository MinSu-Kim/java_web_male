package kr.or.yi.java_web_male.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import javafx.scene.text.Text;
import kr.or.yi.java_web_male.dto.Post;

public class PostUI extends JFrame {

	private JPanel contentPane;
	private JTextField textPostCode;
	private JTextField textAddress;
	private JTextField textDetailAddress;
	private MemberRegisterUI memberRegisterUI;
	private PostListPanel pList;
	private Post doro;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PostUI() {
		pList = new PostListPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel PostCodePanel = new JPanel();
		contentPane.add(PostCodePanel);
		PostCodePanel.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel PostCodeLblPanel = new JPanel();
		PostCodePanel.add(PostCodeLblPanel);
		PostCodeLblPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel space1 = new JLabel("");
		PostCodeLblPanel.add(space1);
		
		JLabel LblPostCode = new JLabel("우편번호");
		PostCodeLblPanel.add(LblPostCode);
		LblPostCode.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel PostCodeTextPanel = new JPanel();
		PostCodePanel.add(PostCodeTextPanel);
		PostCodeTextPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		textPostCode = new JTextField();
		PostCodeTextPanel.add(textPostCode);
		textPostCode.setColumns(10);
		
		JButton BtnPostCodeSearch = new JButton("우편번호 검색");
		
		/*버튼기능*/
		BtnPostCodeSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostSearchUI psu = new PostSearchUI();
				psu.setPostUI(PostUI.this);
				psu.setVisible(true);
			}
		});
		
		PostCodeTextPanel.add(BtnPostCodeSearch);
		
		JPanel AddressPanel = new JPanel();
		contentPane.add(AddressPanel);
		AddressPanel.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel AddressLblPanel = new JPanel();
		AddressPanel.add(AddressLblPanel);
		AddressLblPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel LblAddress = new JLabel("주소");
		AddressLblPanel.add(LblAddress);
		LblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel AddressTextPanel = new JPanel();
		AddressPanel.add(AddressTextPanel);
		AddressTextPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		textAddress = new JTextField();
		AddressTextPanel.add(textAddress);
		textAddress.setColumns(10);
		
		JPanel DetailAddressPanel = new JPanel();
		contentPane.add(DetailAddressPanel);
		DetailAddressPanel.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel DetailAddressLblPanel = new JPanel();
		DetailAddressPanel.add(DetailAddressLblPanel);
		DetailAddressLblPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel LblDetailAddress = new JLabel("세부주소");
		DetailAddressLblPanel.add(LblDetailAddress);
		LblDetailAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel DetailAddressTextPanel = new JPanel();
		DetailAddressPanel.add(DetailAddressTextPanel);
		DetailAddressTextPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		textDetailAddress = new JTextField();
		DetailAddressTextPanel.add(textDetailAddress);
		textDetailAddress.setColumns(10);
		
		JPanel BtnPanel = new JPanel();
		contentPane.add(BtnPanel);
		BtnPanel.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel BtnLblPanel = new JPanel();
		BtnPanel.add(BtnLblPanel);
		BtnLblPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel space2 = new JLabel("");
		BtnLblPanel.add(space2);
		space2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel BtnButtonPanel = new JPanel();
		BtnPanel.add(BtnButtonPanel);
		BtnButtonPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton BtnOk = new JButton("등록");
		BtnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,String.format("%s%s,%s",textPostCode.getText(), textAddress.getText(),textDetailAddress.getText()));
				
				memberRegisterUI.setAddress(String.format("%s%s,%s",textPostCode.getText(), textAddress.getText(),textDetailAddress.getText()));
				dispose();
			}
		});
		BtnButtonPanel.add(BtnOk);
	}



	public void setMemberRegisterUI(MemberRegisterUI memberRegisterUI) {
		this.memberRegisterUI = memberRegisterUI;
	}



	public void setAddress(Post post) {
		textPostCode.setText(post.getZipcode());
		textAddress.setText(post.toString());
		textAddress.requestFocus();
	}

}

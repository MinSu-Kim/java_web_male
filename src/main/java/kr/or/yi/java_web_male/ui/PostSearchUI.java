package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_male.dto.Post;
import kr.or.yi.java_web_male.service.PostUIService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PostSearchUI extends JFrame {

	private JPanel contentPane;
	private PostListPanel postList;
	private PostUIService service;
	private JComboBox BoxSido;
	private Post doro;
	private PostUI postUI;
	
	
	public PostSearchUI() {
		setResizable(false);
		service = new PostUIService();
		setTitle("우편번호 검색");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel LblSido = new JLabel("시도");
		panel.add(LblSido);
		
		String[] strArr = { "강원도", "경기도", "경상남도", "경상북도", "광주광역시", "대구광역시", "대전광역시", "부산광역시", "서울특별시", "세종특별자치시",
	            "울산광역시", "인천광역시", "전라남도", "전라북도", "제주특별자치도", "충청남도", "충청북도" };
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(strArr);
	     BoxSido = new JComboBox<>(model);
		BoxSido.setSelectedIndex(-1);
		panel.add(BoxSido);
		
		
	      
	      
		
		JLabel LblDoro = new JLabel("도로명");
		panel.add(LblDoro);
		
		JTextField TextDoro = new JTextField();
		panel.add(TextDoro);
		TextDoro.setColumns(10);
		
		JButton BtnSearch = new JButton("검색");
		BtnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*try {*/
					doro = new Post();
					 doro.setSido((String)BoxSido.getSelectedItem());
					 doro.setDoro(TextDoro.getText().trim());
					 postList.setLists(service.selectPostByDoro(doro));
					 postList.loadData();
//					 postList.selectedItem(selectedIndex);
/*				} catch (SQLException e1) {
					e1.printStackTrace();
				}*/
					
			}
		});
		
		
		panel.add(BtnSearch);
		
		postList = new PostListPanel();
		postList.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Post post = postList.selectedItem();
				postUI.setAddress(post);
				PostSearchUI.this.dispose();
			}
			
		});
		contentPane.add(postList, BorderLayout.CENTER);
		
		
	}

	public void setPostUI(PostUI postUI) {
		this.postUI = postUI;
	}

	
}

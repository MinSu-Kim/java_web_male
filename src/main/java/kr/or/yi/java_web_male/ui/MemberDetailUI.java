package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_male.InitScene;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapper;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapperImpl;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.Member;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MemberDetailUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<BookRentalInfo> lists;
	private PanelPieChart pPieChart;
	private PanelLineChart pLineChart;

	private BookRentalInfoMapper bookRentalInfoMapper;

	public MemberDetailUI() {
		LoginUI.getLogin();
		bookRentalInfoMapper = BookRentalInfoMapperImpl.getInstance();
		lists = bookRentalInfoMapper.selectBookRentalMemberInfo(LoginUI.getLogin());
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 10));

		JPanel pList = new JPanel();
		pList.setBorder(new TitledBorder(null, "\uB098\uC758 \uB300\uC5EC\uC774\uB825", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(pList);
		pList.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pList.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		loadDatas();
		scrollPane.setViewportView(table);

		pLineChart = new PanelLineChart();

		pLineChart.setBorder(new TitledBorder(null, "\uB098\uC758 \uB3C5\uC11C\uB7C9", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(pLineChart);

		pPieChart = new PanelPieChart();
		pPieChart.setBorder(new TitledBorder(null, "\uB098\uC758 \uC120\uD638\uC7A5\uB974", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(pPieChart);

		Platform.runLater(() -> initFX(pLineChart));
		Platform.runLater(() -> initFX(pPieChart));
	}

	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}

	private void loadDatas() {
		table.setModel(new DefaultTableModel(getDatas(), getColumnNames()));
	}

	private Object[][] getDatas() {
		Member member = LoginUI.getLogin();
		lists = bookRentalInfoMapper.selectBookRentalMemberInfo(member);
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = getMemberRentalInfo(lists.get(i));
		}
		return datas;
	}

	private Object[] getMemberRentalInfo(BookRentalInfo bookRentalInfo) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		String bookCode = bookRentalInfo.getBookCode().getBookCode();
		String title = bookRentalInfo.getBookCode().getTitle();
		String publisher = bookRentalInfo.getPublisher().getPubName();
		String author = bookRentalInfo.getBookCode().getAuthor();
		Date rentalDate = bookRentalInfo.getRentalDate();
		Date returnSchedule = bookRentalInfo.getReturnSchedule();
		return new Object[] { bookCode, title, publisher, author, date.format(rentalDate),
				date.format(returnSchedule) };
	}

	private String[] getColumnNames() {
		return new String[] { "도서코드", "도서명", "출판사", "저자", "대여일자", "반납기한", "반납일자", "반납여부" };
	}

}

package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MemberDetailUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private PieChart pieChart;

	public MemberDetailUI() {
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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column",
				"New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);

		JPanel pLineChart = new JPanel();

		pLineChart.setBorder(new TitledBorder(null, "\uB098\uC758 \uB3C5\uC11C\uB7C9", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(pLineChart);

		JPanel pPieChart = new JPanel();
		initAndShowGUI();
		pPieChart.setBorder(new TitledBorder(null, "\uB098\uC758 \uC120\uD638\uC7A5\uB974", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(pPieChart);
	}

	public static void initAndShowGUI() {
		JFrame frame = new JFrame("Swing and JavaFX");
		frame.setBounds(1120, 50, 600, 600);

		final JFXPanel fxPanel = new JFXPanel();

		frame.add(fxPanel, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JButton btnAdd = new JButton("추가");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Platform.runLater(() -> {
					ObservableList<Data> answer = getChartData();
					PieChart.Data d1 = new PieChart().Data("NIO", 21);
					PieChart.Data d2 = new PieChart().Data("IO", 20);
					answer.addAll(d1, d2);
					piechart
				});
			}

			private ObservableList<Data> getChartData() {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}

}

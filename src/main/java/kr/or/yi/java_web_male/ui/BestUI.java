package kr.or.yi.java_web_male.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class BestUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BestUI frame = new BestUI();
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
	public BestUI() {
		setTitle("Best");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_4 = new JLabel("이번달Best10!");
		panel_2.add(lblNewLabel_4);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_5.add(panel_16);
		
		JLabel lblNewLabel = new JLabel("분류방법을선택하세요(년,월)");
		panel_16.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		panel_16.add(comboBox);
		
		JPanel panel_17 = new JPanel();
		panel_5.add(panel_17);
		
		JSpinner spinner = new JSpinner();
		spinner.setEnabled(false);
		panel_17.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setEnabled(false);
		panel_17.add(spinner_1);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_6.add(panel_18);
		
		JLabel lblNewLabel_2 = new JLabel("분류방법을선택하세요(장르)");
		panel_18.add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_18.add(comboBox_2);
		
		JPanel panel_19 = new JPanel();
		panel_6.add(panel_19);
		
		JLabel lblNewLabel_3 = new JLabel("대");
		panel_19.add(lblNewLabel_3);
		
		JComboBox comboBox_3 = new JComboBox();
		panel_19.add(comboBox_3);
		
		JLabel lblNewLabel_1 = new JLabel("중");
		panel_19.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_19.add(comboBox_1);
		
		JLabel lblNewLabel_12 = new JLabel("소");
		panel_19.add(lblNewLabel_12);
		
		JComboBox comboBox_8 = new JComboBox();
		panel_19.add(comboBox_8);
		
		JButton btnBook = new JButton("검색");
		panel_19.add(btnBook);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNewLabel_10 = new JLabel("그래프");
		panel_7.add(lblNewLabel_10);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11, BorderLayout.NORTH);
		
		JLabel lblNewLabel_5 = new JLabel("이달의 다독왕!");
		panel_11.add(lblNewLabel_5);
		
		JPanel panel_12 = new JPanel();
		panel_9.add(panel_12, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_9.add(panel_13, BorderLayout.EAST);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_13.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_26 = new JPanel();
		panel_14.add(panel_26);
		
		JLabel label = new JLabel("분류방법을선택하세요(년,월)");
		panel_26.add(label);
		
		JComboBox comboBox_9 = new JComboBox();
		panel_26.add(comboBox_9);
		
		JPanel panel_27 = new JPanel();
		panel_14.add(panel_27);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setEnabled(false);
		panel_27.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setEnabled(false);
		panel_27.add(spinner_3);
		
		JPanel panel_28 = new JPanel();
		panel_13.add(panel_28);
		panel_28.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_29 = new JPanel();
		panel_28.add(panel_29);
		
		JLabel label_1 = new JLabel("분류방법을선택하세요(장르)");
		panel_29.add(label_1);
		
		JComboBox comboBox_10 = new JComboBox();
		panel_29.add(comboBox_10);
		
		JPanel panel_30 = new JPanel();
		panel_28.add(panel_30);
		
		JLabel label_2 = new JLabel("대");
		panel_30.add(label_2);
		
		JComboBox comboBox_11 = new JComboBox();
		panel_30.add(comboBox_11);
		
		JLabel label_3 = new JLabel("중");
		panel_30.add(label_3);
		
		JComboBox comboBox_12 = new JComboBox();
		panel_30.add(comboBox_12);
		
		JLabel label_4 = new JLabel("소");
		panel_30.add(label_4);
		
		JComboBox comboBox_13 = new JComboBox();
		panel_30.add(comboBox_13);
		
		JButton btnmember = new JButton("검색");
		panel_30.add(btnmember);
		
		JPanel panel_10 = new JPanel();
		contentPane.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_10.add(panel_15, BorderLayout.NORTH);
		
		JLabel lblNewLabel_11 = new JLabel("그래프");
		panel_15.add(lblNewLabel_11);
	}

}

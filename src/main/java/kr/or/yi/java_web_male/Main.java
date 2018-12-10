package kr.or.yi.java_web_male;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	public static void main(String[] args) {
		// 룩앤필 변경
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
	}
}

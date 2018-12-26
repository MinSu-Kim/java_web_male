package kr.or.yi.java_web_male.ui;

import kr.or.yi.java_web_male.InitScene;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapper;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapperImpl;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.CategoryB;

import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

@SuppressWarnings("serial")
public class PanelPieChart extends JFXPanel implements InitScene {

	private PieChart pieChart;
	private BookRentalInfoMapper bookRentalInfoMapper;
	private List<BookRentalInfo> lists;
	private CategoryB b;

	@Override
	public Scene createScene() {
		bookRentalInfoMapper = BookRentalInfoMapperImpl.getInstance();
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);

		pieChart = new PieChart();
		pieChart.setPrefSize(500, 250);
		pieChart.setData(getChartData());
		pieChart.setTitle("Pie Chart");
		pieChart.setLegendVisible(true); // 범례 표시 유무
		pieChart.setLegendSide(Side.BOTTOM);// 범례 위치
		pieChart.setLabelLineLength(30); // 원의 둘레 가장자리와 라벨간의 거리 지정
		pieChart.setClockwise(true); // 시계방향 배치여부
		pieChart.setLabelsVisible(true); // 레이블 표시여부

//		pieChart.getData().forEach(data -> data.nameProperty().bind(Bindings.concat(data.getName(), " ", data.pieValueProperty(), " %")));
		for (Data d : pieChart.getData()) {
			d.nameProperty().bind(Bindings.concat(d.getName(), " ", d.pieValueProperty(), " %"));
		}

		root.getChildren().add(pieChart);

		return scene;
	}

	private ObservableList<Data> getChartData() {
		ObservableList<Data> list = FXCollections.observableArrayList();
		lists = bookRentalInfoMapper.selectBookRentalMemberInfo(LoginUI.getLogin());
		System.out.println(lists);
		list.addAll(new PieChart.Data(b.getbName(), 10),
				new PieChart.Data("1", 31),
				new PieChart.Data("2", 10),
				new PieChart.Data("3", 10),
				new PieChart.Data("4", 10),
				new PieChart.Data("5", 10),
				new PieChart.Data("6", 10),
				new PieChart.Data("7", 10),
				new PieChart.Data("8", 10),
				new PieChart.Data("9", 10));
		return list;
	}
}

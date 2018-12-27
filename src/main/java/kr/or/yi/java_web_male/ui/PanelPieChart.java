package kr.or.yi.java_web_male.ui;

import kr.or.yi.java_web_male.InitScene;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapper;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapperImpl;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.CategoryB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		lists = bookRentalInfoMapper.selectRentalBookInfoByCategoryB(LoginUI.getLogin());

		int[] cateArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		for (int i = 0; i < lists.size(); i++) {
			switch (lists.get(i).getBookCode().getCateBNo().getbName()) {
			case "총류":
				cateArr[0]++;
				break;
			case "철학":
				cateArr[1]++;
				break;
			case "종교":
				cateArr[2]++;
				break;
			case "사회과학":
				cateArr[3]++;
				break;
			case "자연과학":
				cateArr[4]++;
				break;
			case "기술과학":
				cateArr[5]++;
				break;
			case "예술":
				cateArr[6]++;
				break;
			case "언어":
				cateArr[7]++;
				break;
			case "문학":
				cateArr[8]++;
				break;
			case "역사":
				cateArr[9]++;
				break;
			}
		}
		
		list.addAll(
				new PieChart.Data("총류", cateArr[0]),
				new PieChart.Data("철학", cateArr[1]),
				new PieChart.Data("종교", cateArr[2]),
				new PieChart.Data("사회과학", cateArr[3]),
				new PieChart.Data("자연과학", cateArr[4]),
				new PieChart.Data("기술과학", cateArr[5]),
				new PieChart.Data("예술", cateArr[6]),
				new PieChart.Data("언어", cateArr[7]),
				new PieChart.Data("문학", cateArr[8]),
				new PieChart.Data("역사", cateArr[9]));
		return list;
	}
}
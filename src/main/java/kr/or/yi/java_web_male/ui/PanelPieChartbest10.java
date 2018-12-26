package kr.or.yi.java_web_male.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import kr.or.yi.java_web_male.InitScene;
import kr.or.yi.java_web_male.dto.BookBest10;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PanelPieChartbest10 extends JFXPanel implements InitScene{
	public PanelPieChartbest10() {
	}

	private PieChart pieChart;
	private List<BookBest10> bookList;
	
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		pieChart = new PieChart();
		pieChart.setPrefSize(600, 350);
		pieChart.setData(getChartData());
		pieChart.setTitle("이번달장르별 대여량");
		pieChart.setLegendVisible(true);	// 범례 표시 유무
		pieChart.setLegendSide(Side.BOTTOM);// 범례 위치
		pieChart.setLabelLineLength(30);	// 원의 둘레 가장자리와 라벨간의 거리 지정
		pieChart.setClockwise(true); 		// 시계방향 배치여부
		pieChart.setLabelsVisible(true);	// 레이블 표시여부
		
				
//		pieChart.getData().forEach(data -> data.nameProperty().bind(Bindings.concat(data.getName(), " ", data.pieValueProperty(), " %")));
		for(Data d : pieChart.getData()) {
			d.nameProperty().bind(Bindings.concat(d.getName(), " ", d.pieValueProperty(), " %"));
		}
		
		root.getChildren().add(pieChart);

		return scene;
	}
	
	private ObservableList<Data> getChartData() {
		ObservableList<Data> list = FXCollections.observableArrayList();
		double sum = 0;
		List<Data> data = new ArrayList<>();
		for (BookBest10 best10 : bookList) {
			Data chart = new PieChart.Data("",0);
			chart.setName(best10.getCateBNo().getbName()+"("+ best10.getRanking() +"회)");			
			chart.setPieValue(best10.getRanking());
			data.add(chart);
			sum = sum + chart.getPieValue();
		}
		
		for (Data dat : data) {
			
			dat.setPieValue(Math.round((dat.getPieValue()/sum*100)*100)/100.0);
			list.addAll(dat);
		}
		
		return list;
	}

	public void addChartData(String title, int count) {
		Data d = new PieChart.Data(title, count);
		pieChart.getData().add(d);
		d.nameProperty().bind(Bindings.concat(d.getName(), " ", d.pieValueProperty(), " %"));
	}
	
	public void delChartData(String title) {
		ObservableList<Data> list =  pieChart.getData();
		for(int i=0; i<list.size(); i++) {
			Data d = list.get(i);
			String[] strD = d.getName().split(" ");
			if (strD[0].equals(title)) {
				pieChart.getData().remove(i);
				break;
			}
		}
	}
	
	public void updateChartData(String title, int count) {
		ObservableList<Data> list =  pieChart.getData();
		
		for(int i = 0; i<list.size(); i++) {
			Data s = list.get(i);
			String[] strD = s.getName().split(" ");
			if (strD[0].equals(title)) {
				s.setPieValue(count);
				break;
			}
		}
	}
	
	public void addAllChartData() {
		pieChart.setData(getChartData());
	}
	
	public void deleteAllData() {
		pieChart.getData().clear();
	}

	public void setList(List<BookBest10> list) {
		this.bookList = list;
		
	}
}

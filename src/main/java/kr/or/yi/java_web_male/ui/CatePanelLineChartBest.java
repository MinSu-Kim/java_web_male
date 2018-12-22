package kr.or.yi.java_web_male.ui;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import kr.or.yi.java_web_male.InitScene;
import kr.or.yi.java_web_male.dto.BookBest10;
import kr.or.yi.java_web_male.dto.Student;

@SuppressWarnings("serial")
public class CatePanelLineChartBest extends JFXPanel implements InitScene{

	private LineChart<String, Number> lineChart;
	private CategoryAxis xAxis;
	private List<BookBest10> best10BookLists;
	private List<List<BookBest10>> listlists;
	
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		xAxis = new CategoryAxis();
		xAxis.setLabel("날짜");
		
				
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("대여량");

		lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setPrefSize(600, 350);
		lineChart.setData(getChartData());
		lineChart.setTitle("카태고리별 대여량(6개월단위)");
		lineChart.setLegendVisible(true);	// 범례 표시 유무
		lineChart.setLegendSide(Side.BOTTOM);// 범례 위치

		root.getChildren().add(lineChart);

		return scene;
	}
	
	private ObservableList<XYChart.Series<String, Number>> getChartData() {
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		
		for (List<BookBest10> best10s : listlists) {
			list.add(getChartData(best10s));
		}
		
		return list;
	}
	
	public XYChart.Series<String, Number> getChartData(List<BookBest10> best10s) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		for(BookBest10 best10 : best10s) {
			dataSeries.setName(best10.getCateBNo().getbName());
			dataSeries.getData().add(new XYChart.Data<>(best10.getRentalDate(), best10.getRanking()));
		}
				
		return dataSeries;
	}
	
	/*public void addChartData(Student std) {
		lineChart.getData().add(getChartData(std));
	}
*/
	public void addAllChartData() {
		lineChart.setData(getChartData());
	}
	
	public void deleteAllData() {
		lineChart.getData().clear();
	}
	
	public void delChartData(Student std) {
		ObservableList<Series<String, Number>> list = lineChart.getData();
		Iterator<Series<String, Number>>  it = list.iterator();
		while(it.hasNext()) {
			Series<String, Number> s = it.next();
			if (s.getName().equals(std.getStdName())) {
				lineChart.getData().remove(s);
				break;
			}
		}
	}
	
	/*public void updateChartData(Student std) {
		ObservableList<Series<String, Number>> list = lineChart.getData();
		for(int i = 0; i<list.size(); i++) {
			Series<String, Number> s = list.get(i);
			if (s.getName().equals(std.getStdName())) {
				s.getData().set(0, new XYChart.Data<>("사전", std.getKorScore()));
				s.getData().set(1, new XYChart.Data<>("중간", std.getEngScore()));
				s.getData().set(2, new XYChart.Data<>("기말", std.getMathScore()));	
				break;
			}
		}
	}

	public void addSeries(String subj, int...score) {
		xAxis.setAutoRanging(false); 
		ObservableList<String> cList = xAxis.getCategories();
		cList.add(subj);
				
		ObservableList<Series<String, Number>> list = lineChart.getData();
		for(int i=0; i<list.size(); i++) {
			Series<String, Number> s = list.get(i);
			s.getData().add(new XYChart.Data<>(subj, score[i]));
		}
	}*/

	public void setList(List<List<BookBest10>> listlists) {
		this.listlists =listlists;
		
	}

	
}

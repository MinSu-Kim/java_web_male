
package kr.or.yi.java_web_male.ui;

import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.paint.Color;
import kr.or.yi.java_web_male.InitScene;
import kr.or.yi.java_web_male.dto.BookBest10;
import kr.or.yi.java_web_male.dto.MemberBest10;
import kr.or.yi.java_web_male.dto.Student;

@SuppressWarnings("serial")
public class MemberBest10PanelBarChart extends JFXPanel implements InitScene{
	public MemberBest10PanelBarChart() {
	}

	private BarChart<String, Number> barChart;
	private List<MemberBest10> best10MemberListsNow;
	private List<MemberBest10> Best10MemberListsLast;
	private String now = "이번달";
	private String last = "저번달";
	private String title = "이번달 Best 회원 TOP10!";
	
	
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root, Color.ALICEBLUE);
		root.setAutoSizeChildren(true);
		
		//막 대형 차트의 X 축과 Y 축을 정의하고 레이블을 설정
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("회원번호");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("대여 횟수");

		barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle(title);
		
		barChart.setPrefSize(600, 220);
		barChart.setData(getChartData());
		
		root.getChildren().add(barChart);

		return scene;
	}
	
	/*public void deleteAllData() {
		barChart.getData().clear();
	}
	
	public void delChartData(Student std) {
		ObservableList<Series<String, Number>> list = barChart.getData();
		Iterator<Series<String, Number>>  it = list.iterator();
		while(it.hasNext()) {
			Series<String, Number> s = it.next();
			if (s.getName().equals(std.getStdName())) {
				barChart.getData().remove(s);
				break;
			}
		}
	}
	
	public void updateChartData(Student std) {
		ObservableList<Series<String, Number>> list = barChart.getData();
		
		for(int i = 0; i<list.size(); i++) {
			Series<String, Number> s = list.get(i);
			if (s.getName().equals(std.getStdName())) {
				s.getData().set(0, new XYChart.Data<>("국어", std.getKorScore()));
				s.getData().set(1, new XYChart.Data<>("영어", std.getEngScore()));
				s.getData().set(2, new XYChart.Data<>("수학", std.getMathScore()));	
				break;
			}
		}
	}
		
	public void addAllChartData() {
		barChart.setData(getChartData());
	}*/
	
	public XYChart.Series<String, Number> getChartDataNow(List<MemberBest10> list, String day) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		dataSeries.setName(day);
		for (MemberBest10 best10 : list) {
			dataSeries.getData().add(new XYChart.Data<>("("+best10.getMemberNo().getMemberNo()+")", best10.getRanking()));
		}
				
		return dataSeries;
	}
	
	private ObservableList<XYChart.Series<String, Number>> getChartData() {
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();

		list.add(getChartDataNow(best10MemberListsNow,now));
		if(Best10MemberListsLast.size() != 0) {
			list.add(getChartDataNow(Best10MemberListsLast,last));
		}		
					
		return list;
	}

	public void setChartDataThis(List<MemberBest10> memberBest10s,String day) {
		this.best10MemberListsNow = memberBest10s;
		now = day;

	}

	public void setChartDataLast(List<MemberBest10> memberBest10s,String day) {
		this.Best10MemberListsLast = memberBest10s;
		last = day;
		
	}
	public void setTitle(String title) {
		this.title = title;
		
	}

	

}

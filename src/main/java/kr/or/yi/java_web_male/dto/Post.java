package kr.or.yi.java_web_male.dto;

public class Post {
	private String zipcode;
	private String sido;
	private String sigungu ;
	private String eupmyeon ;
	private String doro ;
	private int building1; 
	private int building2 ;
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getEupmyeon() {
		return eupmyeon;
	}
	public void setEupmyeon(String eupmyeon) {
		this.eupmyeon = eupmyeon;
	}
	public String getDoro() {
		return doro;
	}
	public void setDoro(String doro) {
		this.doro = doro;
	}
	public int getBuilding1() {
		return building1;
	}
	public void setBuilding1(int building1) {
		this.building1 = building1;
	}
	public int getBuilding2() {
		return building2;
	}
	public void setBuilding2(int building2) {
		this.building2 = building2;
	}
	@Override
	public String toString() {
		return String.format("Post [zipcode=%s, sido=%s, sigungu=%s, eupmyeon=%s, doro=%s, building1=%s, building2=%s]",
				zipcode, sido, sigungu, eupmyeon, doro, building1, building2);
	}
	
	
	
}

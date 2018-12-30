package kr.or.yi.java_web_male.dto;

public class Publisher {
	private String pubNo;
	private String pubName;

	public Publisher() {
	}

	public String getPubNo() {
		return pubNo;
	}

	public void setPubNo(String pubNo) {
		this.pubNo = pubNo;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

	@Override
	public String toString() {
		return String.format("Publisher [pubNo=%s, pubName=%s]", pubNo, pubName);
	}


	

}

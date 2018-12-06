package kr.or.yi.java_web_male.dto;

public class Publisher {
	private String publisherNo;
	private String name;
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPublisherNo() {
		return publisherNo;
	}
	public void setPublisherNo(String publisherNo) {
		this.publisherNo = publisherNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Publisher(String publisherNo, String name) {
		super();
		this.publisherNo = publisherNo;
		this.name = name;
	}
	
}

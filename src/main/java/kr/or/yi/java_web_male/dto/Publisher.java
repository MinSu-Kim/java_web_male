package kr.or.yi.java_web_male.dto;

public class Publisher {
	private String publisherNo;
	private String name;

	public Publisher() {}

	public Publisher(String publisherNo, String name) {
		this.publisherNo = publisherNo;
		this.name = name;
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

	@Override
	public String toString() {
		return String.format("Publisher [publisherNo=%s, name=%s]", publisherNo, name);
	}

}

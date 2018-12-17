package kr.or.yi.java_web_male.dto;

public class BookBest10 {
	private String bc;
	private Book title;
	private Book author;
	private Publisher pubName;
	private int ranking;
	
	@Override
	public String toString() {
		return "Best10 [bc=" + bc + ", title=" + title + ", author=" + author + ", pubName=" + pubName + ", ranking="
				+ ranking + "]";
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public BookBest10() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBc() {
		return bc;
	}
	public void setBc(String bc) {
		this.bc = bc;
	}
	public Book getTitle() {
		return title;
	}
	public void setTitle(Book title) {
		this.title = title;
	}
	public Book getAuthor() {
		return author;
	}
	public void setAuthor(Book author) {
		this.author = author;
	}
	public Publisher getPubName() {
		return pubName;
	}
	public void setPubName(Publisher pubName) {
		this.pubName = pubName;
	}
	
	
	
}

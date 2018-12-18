package kr.or.yi.java_web_male.dto;

public class BookBest10 {
	private Book bookCode;
	private Book title;
	private Book author;
	private Publisher pubName;
	private int ranking;
	private String rentalDate;
	private CategoryB cateBNo;
	private CategoryM cateMNo;
	private CategoryS cateSNo;
	
	
	
	
	
	@Override
	public String toString() {
		return "BookBest10 [bc=" + bookCode + ", title=" + title + ", author=" + author + ", pubName=" + pubName
				+ ", ranking=" + ranking + ", rentalDate=" + rentalDate + ", cateBNo=" + cateBNo + ", cateMNo="
				+ cateMNo + ", cateSNo=" + cateSNo + "]";
	}
	public CategoryB getCateBNo() {
		return cateBNo;
	}
	public void setCateBNo(CategoryB cateBNo) {
		this.cateBNo = cateBNo;
	}
	public CategoryM getCateMNo() {
		return cateMNo;
	}
	public void setCateMNo(CategoryM cateMNo) {
		this.cateMNo = cateMNo;
	}
	public CategoryS getCateSNo() {
		return cateSNo;
	}
	public void setCateSNo(CategoryS cateSNo) {
		this.cateSNo = cateSNo;
	}
	
	public String getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
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
	
	
	public Book getBookCode() {
		return bookCode;
	}
	public void setBookCode(Book bookCode) {
		this.bookCode = bookCode;
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

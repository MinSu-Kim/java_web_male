package kr.or.yi.java_web_male.dto;

public class Book {
	
	private String bookCode;
	private int bookNo;
	private Publisher pubNo;
	private String author;
	private String translator;
	private String title;
	private int price;
	private boolean rentalPossible;
	private String image;
	private CategoryS cateSNo;
	private CategoryM cateMNo;
	private CategoryB cateBNo;
	public String getBookCode() {
		return bookCode;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookCode, int bookNo, Publisher publisherNo, String writter, String translator, String title,
			int priece, boolean rentable, String image, CategoryS categorynoS, CategoryM categorynoM,
			CategoryB categorynoB) {
		super();
		this.bookCode = bookCode;
		this.bookNo = bookNo;
		this.pubNo = publisherNo;
		this.author = writter;
		this.translator = translator;
		this.title = title;
		this.price = priece;
		this.rentalPossible = rentable;
		this.image = image;
		this.cateSNo = categorynoS;
		this.cateMNo = categorynoM;
		this.cateBNo = categorynoB;
	}
	
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public Publisher getPublisherNo() {
		return pubNo;
	}
	public void setPublisherNo(Publisher publisherNo) {
		this.pubNo = publisherNo;
	}
	public String getWritter() {
		return author;
	}
	public void setWritter(String writter) {
		this.author = writter;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPriece() {
		return price;
	}
	public void setPriece(int priece) {
		this.price = priece;
	}
	public boolean isRentable() {
		return rentalPossible;
	}
	public void setRentable(boolean rentable) {
		this.rentalPossible = rentable;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public CategoryS getCategorynoS() {
		return cateSNo;
	}
	public void setCategorynoS(CategoryS categorynoS) {
		this.cateSNo = categorynoS;
	}
	public CategoryM getCategorynoM() {
		return cateMNo;
	}
	public void setCategorynoM(CategoryM categorynoM) {
		this.cateMNo = categorynoM;
	}
	public CategoryB getCategorynoB() {
		return cateBNo;
	}
	public void setCategorynoB(CategoryB categorynoB) {
		this.cateBNo = categorynoB;
	}
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookNo=" + bookNo + ", publisherNo=" + pubNo + ", writter="
				+ author + ", translator=" + translator + ", title=" + title + ", priece=" + price + ", rentable="
				+ rentalPossible + ", image=" + image + ", categorynoS=" + cateSNo + ", categorynoM=" + cateMNo
				+ ", categorynoB=" + cateBNo + "]";
	}
	
	
	
}

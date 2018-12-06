package kr.or.yi.java_web_male.dto;

public class Book {
	private String bookCode;
	private int bookNo;
	private String publisherNo;
	private String writter;
	private String translator;
	private String title;
	private int priece;
	private boolean rentable;
	private String image;
	private CategoryS categorynoS;
	private CategoryM categorynoM;
	private CategoryB categorynoB;
	public String getBookCode() {
		return bookCode;
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
	public String getPublisherNo() {
		return publisherNo;
	}
	public void setPublisherNo(String publisherNo) {
		this.publisherNo = publisherNo;
	}
	public String getWritter() {
		return writter;
	}
	public void setWritter(String writter) {
		this.writter = writter;
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
		return priece;
	}
	public void setPriece(int priece) {
		this.priece = priece;
	}
	public boolean isRentable() {
		return rentable;
	}
	public void setRentable(boolean rentable) {
		this.rentable = rentable;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public CategoryS getCategorynoS() {
		return categorynoS;
	}
	public void setCategorynoS(CategoryS categorynoS) {
		this.categorynoS = categorynoS;
	}
	public CategoryM getCategorynoM() {
		return categorynoM;
	}
	public void setCategorynoM(CategoryM categorynoM) {
		this.categorynoM = categorynoM;
	}
	public CategoryB getCategorynoB() {
		return categorynoB;
	}
	public void setCategorynoB(CategoryB categorynoB) {
		this.categorynoB = categorynoB;
	}
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookNo=" + bookNo + ", publisherNo=" + publisherNo + ", writter="
				+ writter + ", translator=" + translator + ", title=" + title + ", priece=" + priece + ", rentable="
				+ rentable + ", image=" + image + ", categorynoS=" + categorynoS + ", categorynoM=" + categorynoM
				+ ", categorynoB=" + categorynoB + "]";
	}
	
	
	
}

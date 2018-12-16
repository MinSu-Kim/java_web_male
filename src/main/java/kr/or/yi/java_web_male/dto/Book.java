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
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Book(String bookCode, int bookNo, Publisher pubNo, String author, String translator, String title, int price,
			boolean rentalPossible, String image, CategoryS cateSNo, CategoryM cateMNo, CategoryB cateBNo) {
		super();
		this.bookCode = bookCode;
		this.bookNo = bookNo;
		this.pubNo = pubNo;
		this.author = author;
		this.translator = translator;
		this.title = title;
		this.price = price;
		this.rentalPossible = rentalPossible;
		this.image = image;
		this.cateSNo = cateSNo;
		this.cateMNo = cateMNo;
		this.cateBNo = cateBNo;
	}


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


	public Publisher getPubNo() {
		return pubNo;
	}


	public void setPubNo(Publisher pubNo) {
		this.pubNo = pubNo;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public boolean isRentalPossible() {
		return rentalPossible;
	}


	public void setRentalPossible(boolean rentalPossible) {
		this.rentalPossible = rentalPossible;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public CategoryS getCateSNo() {
		return cateSNo;
	}


	public void setCateSNo(CategoryS cateSNo) {
		this.cateSNo = cateSNo;
	}


	public CategoryM getCateMNo() {
		return cateMNo;
	}


	public void setCateMNo(CategoryM cateMNo) {
		this.cateMNo = cateMNo;
	}


	public CategoryB getCateBNo() {
		return cateBNo;
	}


	public void setCateBNo(CategoryB cateBNo) {
		this.cateBNo = cateBNo;
	}


	@Override
	public String toString() {
		return "Book [ bookNo=" + bookNo + ", pubNo=" + pubNo + ", author=" + author+ ", translator=" + translator + ", title=" + title + ", price=" + price + ", rentalPossible="
				+ rentalPossible + ", image=" + image + ", cateSNo=" + cateSNo + ", cateMNo=" + cateMNo + ", cateBNo="
				+ cateBNo + "]";
	}


	

}

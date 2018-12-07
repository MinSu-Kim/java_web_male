package kr.or.yi.java_web_male.dto;

public class Book {

	private String bookCode;
	private int bookNo;
	private Publisher publisherNo;
	private String writter;
	private String translator;
	private String title;
	private int priece;
	private boolean rentable;
	private String image;
	private CategoryS categorynoS;
	private CategoryM categorynoM;
	private CategoryB categorynoB;

	public Book() {}

	public Book(String bookCode, int bookNo, Publisher publisherNo, String writter, String translator, String title,
			int priece, boolean rentable, String image, CategoryS categorynoS, CategoryM categorynoM,
			CategoryB categorynoB) {
		this.bookCode = bookCode;
		this.bookNo = bookNo;
		this.publisherNo = publisherNo;
		this.writter = writter;
		this.translator = translator;
		this.title = title;
		this.priece = priece;
		this.rentable = rentable;
		this.image = image;
		this.categorynoS = categorynoS;
		this.categorynoM = categorynoM;
		this.categorynoB = categorynoB;
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

	public Publisher getPublisherNo() {
		return publisherNo;
	}

	public void setPublisherNo(Publisher publisherNo) {
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
		return String.format(
				"Book [bookCode=%s, bookNo=%s, publisherNo=%s, writter=%s, translator=%s, title=%s, priece=%s, rentable=%s, image=%s, categorynoS=%s, categorynoM=%s, categorynoB=%s]",
				bookCode, bookNo, publisherNo, writter, translator, title, priece, rentable, image, categorynoS,
				categorynoM, categorynoB);
	}

}

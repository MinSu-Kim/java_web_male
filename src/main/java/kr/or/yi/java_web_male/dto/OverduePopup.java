package kr.or.yi.java_web_male.dto;

import java.util.Date;

public class OverduePopup {
	public Member korName;
	public Book title;
	public BookRentalInfo rentalDate;
	public BookRentalInfo returnSchedule;
	public Member phone;
	public Date returnDate;
	public int overday;
	public Member getKorName() {
		return korName;
	}
	public void setKorName(Member korName) {
		this.korName = korName;
	}
	public Book getTitle() {
		return title;
	}
	public void setTitle(Book title) {
		this.title = title;
	}
	public BookRentalInfo getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(BookRentalInfo rentalDate) {
		this.rentalDate = rentalDate;
	}
	public BookRentalInfo getReturnSchedule() {
		return returnSchedule;
	}
	public void setReturnSchedule(BookRentalInfo returnSchedule) {
		this.returnSchedule = returnSchedule;
	}
	public Member getPhone() {
		return phone;
	}
	public void setPhone(Member phone) {
		this.phone = phone;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getOverday() {
		return overday;
	}
	public void setOverday(int overday) {
		this.overday = overday;
	}
	public OverduePopup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OverduePopup(Member korName, Book title, BookRentalInfo rentalDate, BookRentalInfo returnSchedule,
			Member phone, Date returnDate, int overday) {
		super();
		this.korName = korName;
		this.title = title;
		this.rentalDate = rentalDate;
		this.returnSchedule = returnSchedule;
		this.phone = phone;
		this.returnDate = returnDate;
		this.overday = overday;
	}
	@Override
	public String toString() {
		return "OverduePopup [korName=" + korName + ", title=" + title + ", rentalDate=" + rentalDate
				+ ", returnSchedule=" + returnSchedule + ", phone=" + phone + ", returnDate=" + returnDate
				+ ", overday=" + overday + "]";
	}
	
	
	
}

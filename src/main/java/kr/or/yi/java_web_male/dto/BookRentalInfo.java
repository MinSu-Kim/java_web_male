package kr.or.yi.java_web_male.dto;

import java.util.Date;

public class BookRentalInfo {
	private int rentalNo;
	private Date rentalDate;
	private Date returnDate;
	private Date returnSchedule;
	private Member member_no;
	private Book bookNo;
	
	
	
	public BookRentalInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookRentalInfo(int rentalNo, Date rentalDate, Date returnDate, Date returnSchedule, Member member_no,
			Book bookNo) {
		super();
		this.rentalNo = rentalNo;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.returnSchedule = returnSchedule;
		this.member_no = member_no;
		this.bookNo = bookNo;
	}
	
	public int getRentalNo() {
		return rentalNo;
	}
	public void setRentalNo(int rentalNo) {
		this.rentalNo = rentalNo;
	}
	public Date getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Date getReturnSchedule() {
		return returnSchedule;
	}
	public void setReturnSchedule(Date returnSchedule) {
		this.returnSchedule = returnSchedule;
	}
	public Member getMemberNo() {
		return member_no;
	}
	public void setMemberNo(Member memberNo) {
		this.member_no = memberNo;
	}
	public Book getBookNo() {
		return bookNo;
	}
	public void setBookNo(Book bookNo) {
		this.bookNo = bookNo;
	}
	
	@Override
	public String toString() {
		return "BookRentalInfo [rentalNo=" + rentalNo + ", rentalDate=" + rentalDate + ", returnDate=" + returnDate
				+ ", returnSchedule=" + returnSchedule +",memberNo="+member_no+ ", bookNo=" + bookNo + "]";
	}
	
	
	
	
}

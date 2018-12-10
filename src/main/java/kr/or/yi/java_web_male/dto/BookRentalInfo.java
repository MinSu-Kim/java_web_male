package kr.or.yi.java_web_male.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("BookRentalInfo")
public class BookRentalInfo {
	private int rentalNo;
	private Date rentalDate;
	private Date returnDate;
	private Date returnSchedule;
	private Member memberNo;
	private Book bookCode;
	
	public BookRentalInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookRentalInfo(int rentalNo, Date rentalDate, Date returnDate, Date returnSchedule, Member memberNo,
			Book bookCode) {
		super();
		this.rentalNo = rentalNo;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.returnSchedule = returnSchedule;
		this.memberNo = memberNo;
		this.bookCode = bookCode;
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
		return memberNo;
	}

	public void setMemberNo(Member memberNo) {
		this.memberNo = memberNo;
	}

	public Book getBookCode() {
		return bookCode;
	}

	public void setBookCode(Book bookCode) {
		this.bookCode = bookCode;
	}

	@Override
	public String toString() {
		return "BookRentalInfo [rentalNo=" + rentalNo + ", rentalDate=" + rentalDate + ", returnDate=" + returnDate
				+ ", returnSchedule=" + returnSchedule + ", memberNo=" + memberNo + ", bookCode=" + bookCode + "]";
	}

	
}

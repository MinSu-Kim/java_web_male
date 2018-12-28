package kr.or.yi.java_web_male.dto;

import java.util.Date;

public class Overdue {
	private String memberNo;
	private int stopDate;
	private int overdueCount;
	private boolean rentalAuthority;
	private Date overdueDate;
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public int getStopDate() {
		return stopDate;
	}
	public void setStopDate(int stopDate) {
		this.stopDate = stopDate;
	}
	public int getOverdueCount() {
		return overdueCount;
	}
	public void setOverdueCount(int overdueCount) {
		this.overdueCount = overdueCount;
	}
	public boolean isRentalAuthority() {
		return rentalAuthority;
	}
	public void setRentalAuthority(boolean rentalAuthority) {
		this.rentalAuthority = rentalAuthority;
	}
	
	
	public Date getOverdueDate() {
		return overdueDate;
	}
	public void setOverdueDate(Date overdueDate) {
		this.overdueDate = overdueDate;
	}
	@Override
	public String toString() {
		return String.format("Overdue [memberNo=%s, stopDate=%s, overdueCount=%s, rentalAuthority=%s, overdueDate=%s]",
				memberNo, stopDate, overdueCount, rentalAuthority, overdueDate);
	}
	
	
	
	
	
}

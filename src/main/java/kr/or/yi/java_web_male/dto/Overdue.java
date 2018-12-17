package kr.or.yi.java_web_male.dto;

public class Overdue {
	private String memberNo;
	private int stopDate;
	private int overdueCount;
	private boolean rentalAuthority;
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
	
	@Override
	public String toString() {
		return String.format("Member_rental_info [memberNo=%s, stopDate=%s, overdueCount=%s, rentalAuthority=%s]",
				memberNo, stopDate, overdueCount, rentalAuthority);
	}
	
	
}

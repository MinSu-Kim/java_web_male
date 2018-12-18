package kr.or.yi.java_web_male.dto;

public class MemberRentalInfo {
	private String memberNo;
	private int grade;
	private int nowTotal;
	private int total;
	
	
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getNowTotal() {
		return nowTotal;
	}
	public void setNowTotal(int nowTotal) {
		this.nowTotal = nowTotal;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return String.format("Member_rental_info [memberNo=%s, grade=%s, nowTotal=%s, total=%s]", memberNo, grade,
				nowTotal, total);
	}
	
	
}

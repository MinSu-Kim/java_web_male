package kr.or.yi.java_web_male.dto;

public class MemberBest10 {
	private String sex;
	private Member memberNo;
	private Member Name;
	private Member admin;
	private BookRentalInfo rentalDate;
	private int ranking;
	@Override
	public String toString() {
		return "MemberBest10 [sex=" + sex + ", memberNo=" + memberNo + ", Name=" + Name + ", admin=" + admin
				+ ", rentalDate=" + rentalDate + ", ranking=" + ranking + "]";
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Member getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Member memberNo) {
		this.memberNo = memberNo;
	}
	public Member getName() {
		return Name;
	}
	public void setName(Member name) {
		Name = name;
	}
	public Member getAdmin() {
		return admin;
	}
	public void setAdmin(Member admin) {
		this.admin = admin;
	}
	public BookRentalInfo getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(BookRentalInfo rentalDate) {
		this.rentalDate = rentalDate;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public MemberBest10() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberBest10(String sex, Member memberNo, Member name, Member admin, BookRentalInfo rentalDate,
			int ranking) {
		super();
		this.sex = sex;
		this.memberNo = memberNo;
		Name = name;
		this.admin = admin;
		this.rentalDate = rentalDate;
		this.ranking = ranking;
	}
	
	
}

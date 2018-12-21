package kr.or.yi.java_web_male.dto;

public class MemberBest10 {
	private String sex;
	private Member memberNo;
	private Member name;
	private Member admin;
	private BookRentalInfo rentalDate;
	private int ranking;
	private CategoryB cateBNo;
	private CategoryM cateMNo;
	private CategoryS cateSNo;
	
	
	
	
	
	public CategoryB getCateBNo() {
		return cateBNo;
	}
	public void setCateBNo(CategoryB cateBNo) {
		this.cateBNo = cateBNo;
	}
	public CategoryM getCateMNo() {
		return cateMNo;
	}
	public void setCateMNo(CategoryM cateMNo) {
		this.cateMNo = cateMNo;
	}
	public CategoryS getCateSNo() {
		return cateSNo;
	}
	public void setCateSNo(CategoryS cateSNo) {
		this.cateSNo = cateSNo;
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
		return name;
	}
	public void setName(Member name) {
		this.name = name;
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
		name = name;
		this.admin = admin;
		this.rentalDate = rentalDate;
		this.ranking = ranking;
	}
	
	
}

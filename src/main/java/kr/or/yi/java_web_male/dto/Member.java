package kr.or.yi.java_web_male.dto;

import org.apache.ibatis.type.Alias;

@Alias("Member")
public class Member {
	private String memberNo;
	private String password;
	private String kor_name;
	private String eng_name;
	private String phone;
	private String jumin;
	private String email;
	private String address;
	private String photo;
	private int admin;
	private String Uniqueness;

	public Member() {}

	public Member(String memberNo, String password, String kor_name, String eng_name, String phone, String jumin,
			String email, String address, String photo, int admin, String uniqueness) {
		this.memberNo = memberNo;
		this.password = password;
		this.kor_name = kor_name;
		this.eng_name = eng_name;
		this.phone = phone;
		this.jumin = jumin;
		this.email = email;
		this.address = address;
		this.photo = photo;
		this.admin = admin;
		this.Uniqueness = uniqueness;
	}

	public String getmemberNo() {
		return memberNo;
	}

	public void setmemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKor_name() {
		return kor_name;
	}

	public void setKor_name(String kor_name) {
		this.kor_name = kor_name;
	}

	public String getEng_name() {
		return eng_name;
	}

	public void setEng_name(String eng_name) {
		this.eng_name = eng_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getUniqueness() {
		return Uniqueness;
	}

	public void setUniqueness(String uniqueness) {
		this.Uniqueness = uniqueness;
	}

	@Override
	public String toString() {
		return String.format(
				"Member [memberNo=%s, password=%s, kor_name=%s, eng_name=%s, phone=%s, jumin=%s, email=%s, address=%s, photo=%s, admin=%s, Uniqueness=%s]",
				memberNo, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, Uniqueness);
	}

}

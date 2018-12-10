package kr.or.yi.java_web_male.dto;

public class CategoryB {
	private int bCode;
	private String bName;

	public CategoryB() {
	}
	public CategoryB(int bCode, String bName) {
		super();
		this.bCode = bCode;
		this.bName = bName;
	}

	public int getbCode() {
		return bCode;
	}

	public void setbCode(int bCode) {
		this.bCode = bCode;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}
 
	

	@Override
	public String toString() {
		return bCode+""+bName;

	}

}

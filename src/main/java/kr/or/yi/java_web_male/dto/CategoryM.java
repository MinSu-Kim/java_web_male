package kr.or.yi.java_web_male.dto;

public class CategoryM {
	private int mCode;
	private String mName;
	private CategoryB bCode;

	public CategoryM() {
	}
	public CategoryM(int mCode, String mName, CategoryB bCode) {
		super();
		this.mCode = mCode;
		this.mName = mName;
		this.bCode = bCode;
	}

	public int getmCode() {
		return mCode;
	}

	public void setmCode(int mCode) {
		this.mCode = mCode;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public CategoryB getbCode() {
		return bCode;
	}

	public void setbCode(CategoryB bCode) {
		this.bCode = bCode;
	}
	

	

	@Override
	public String toString() {
		return bCode.getbCode() +""+ mCode +""+mName;

	}

}

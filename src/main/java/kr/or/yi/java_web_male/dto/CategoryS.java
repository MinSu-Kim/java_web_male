package kr.or.yi.java_web_male.dto;

public class CategoryS {
	private int sCode;
	private String sName;
	private CategoryM mCode;
	private CategoryB bCode;

	public CategoryS() {
	}
	public CategoryS(int sCode, String sName, CategoryM mCode, CategoryB bCode) {
		this.sCode = sCode;
		this.sName = sName;
		this.mCode = mCode;
		this.bCode = bCode;
	}

	public int getsCode() {
		return sCode;
	}

	public void setsCode(int sCode) {
		this.sCode = sCode;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public CategoryM getmCode() {
		return mCode;
	}

	public void setmCode(CategoryM mCode) {
		this.mCode = mCode;
	}

	public CategoryB getbCode() {
		return bCode;
	}

	public void setbCode(CategoryB bCode) {
		this.bCode = bCode;
	}
	@Override
	public String toString() {
		return bCode.getbCode() +""+ mCode.getmCode() +""+sCode+""+sName;
	}
	

	

	

}

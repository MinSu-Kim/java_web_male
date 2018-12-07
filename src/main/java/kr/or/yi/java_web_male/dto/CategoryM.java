package kr.or.yi.java_web_male.dto;

public class CategoryM {
	private int categorynoM;
	private String themaM;
	private CategoryB categorynoB;

	public CategoryM() {}

	public CategoryM(int categorynoM, String themaM, CategoryB categorynoB) {
		this.categorynoM = categorynoM;
		this.themaM = themaM;
		this.categorynoB = categorynoB;
	}

	public int getCategorynoM() {
		return categorynoM;
	}

	public void setCategorynoM(int categorynoM) {
		this.categorynoM = categorynoM;
	}

	public String getThemaM() {
		return themaM;
	}

	public void setThemaM(String themaM) {
		this.themaM = themaM;
	}

	public CategoryB getCategorynoB() {
		return categorynoB;
	}

	public void setCategorynoB(CategoryB categorynoB) {
		this.categorynoB = categorynoB;
	}

	@Override
	public String toString() {
		return "CategoryM [categorynoM=" + categorynoM + ", themaM=" + themaM + ", categorynoB=" + categorynoB + "]";
	}

}

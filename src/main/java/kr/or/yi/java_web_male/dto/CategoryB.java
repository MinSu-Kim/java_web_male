package kr.or.yi.java_web_male.dto;

public class CategoryB {
	private int categorynoB;
	private String themaB;

	public CategoryB() {}

	public CategoryB(int categorynoB, String themaB) {
		this.categorynoB = categorynoB;
		this.themaB = themaB;
	}

	public int getCategorynoB() {
		return categorynoB;
	}

	public void setCategorynoB(int categorynoB) {
		this.categorynoB = categorynoB;
	}

	public String getThemaB() {
		return themaB;
	}

	public void setThemaB(String themaB) {
		this.themaB = themaB;
	}

	@Override
	public String toString() {
		return String.format("CategoryB [categorynoB=%s, themaB=%s]", categorynoB, themaB);
	}

}

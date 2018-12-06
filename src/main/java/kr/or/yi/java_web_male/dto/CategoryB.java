package kr.or.yi.java_web_male.dto;

public class CategoryB {
	private int categorynoB;
	private String themaB;

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
		return "CategoryB [categorynoB=" + categorynoB + ", themaB=" + themaB + "]";
	}

	public CategoryB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryB(int categorynoB, String themaB) {
		super();
		this.categorynoB = categorynoB;
		this.themaB = themaB;
	}

}

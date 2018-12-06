package kr.or.yi.java_web_male.dto;

public class CategoryS {
	private int categorynoS;
	private String themaS;
	private CategoryM categorynoM;
	private CategoryB categorynoB;

	public CategoryS() {}

	public CategoryS(int categorynoS, String themaS, CategoryM categorynoM, CategoryB categorynoB) {
		super();
		this.categorynoS = categorynoS;
		this.themaS = themaS;
		this.categorynoM = categorynoM;
		this.categorynoB = categorynoB;
	}

	public int getCategorynoS() {
		return categorynoS;
	}

	public void setCategorynoS(int categorynoS) {
		this.categorynoS = categorynoS;
	}

	public String getThemaS() {
		return themaS;
	}

	public void setThemaS(String themaS) {
		this.themaS = themaS;
	}

	public CategoryM getCategorynoM() {
		return categorynoM;
	}

	public void setCategorynoM(CategoryM categorynoM) {
		this.categorynoM = categorynoM;
	}

	public CategoryB getCategorynoB() {
		return categorynoB;
	}

	public void setCategorynoB(CategoryB categorynoB) {
		this.categorynoB = categorynoB;
	}

	@Override
	public String toString() {
		return String.format("CategoryS [categorynoS=%s, themaS=%s, categorynoM=%s, categorynoB=%s]", categorynoS,
				themaS, categorynoM, categorynoB);
	}

}

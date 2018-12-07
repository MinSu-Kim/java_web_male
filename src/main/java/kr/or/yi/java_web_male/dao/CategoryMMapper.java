package kr.or.yi.java_web_male.dao;

import java.util.List;

import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;

public interface CategoryMMapper {
	List<CategoryM> selectCategoryMByAll();
	List<CategoryM> selectCategoryMByBNo(CategoryB cateB);
}

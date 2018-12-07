package kr.or.yi.java_web_male.dao;

import java.util.List;

import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;

public interface CategorySMapper {
	List<CategoryS> selectCategorySByAll();
}

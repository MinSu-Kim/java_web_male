package kr.or.yi.java_web_male.service;

import java.util.List;

import kr.or.yi.java_web_male.dao.CategoryBMapper;
import kr.or.yi.java_web_male.dao.CategoryBMapperImpl;
import kr.or.yi.java_web_male.dao.CategoryMMapper;
import kr.or.yi.java_web_male.dao.CategoryMMapperImpl;
import kr.or.yi.java_web_male.dao.CategorySMapper;
import kr.or.yi.java_web_male.dao.CategorySMapperImpl;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;

public class LibraryUIService {
	private CategoryBMapper cateBMapper;
	private CategoryMMapper cateMMapper;
	private CategorySMapper cateSMapper;

	public LibraryUIService() {
		cateBMapper = new CategoryBMapperImpl();
		cateMMapper = new CategoryMMapperImpl();
		cateSMapper = new CategorySMapperImpl();
	}
	
	public List<CategoryB> selectCategoryBByAll() {
		return cateBMapper.selectCategoryBByAll();
	}
	
	public List<CategoryM> selectCategoryMByAll() {
		return cateMMapper.selectCategoryMByAll();
	}
	
	public List<CategoryS> selectCategorySByAll() {
		return cateSMapper.selectCategorySByAll();
	}
	
	public List<CategoryM> selectCategoryMByBNo(CategoryB cateB) {
		return cateMMapper.selectCategoryMByBNo(cateB);
	}

}

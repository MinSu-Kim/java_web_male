package kr.or.yi.java_web_male.service;

import java.util.List;

import kr.or.yi.java_web_male.dao.CategoryBMapper;
import kr.or.yi.java_web_male.dao.CategoryBMapperImpl;
import kr.or.yi.java_web_male.dto.CategoryB;

public class LibraryUIService {
	private CategoryBMapper cateBMapper;

	public LibraryUIService() {
		cateBMapper = new CategoryBMapperImpl();
	}
	public List<CategoryB> selectCategoryBByAll(){
		return cateBMapper.selectCategoryBByAll();		
	}
	
	
}

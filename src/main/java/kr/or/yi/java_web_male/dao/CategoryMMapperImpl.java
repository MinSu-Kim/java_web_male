package kr.or.yi.java_web_male.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class CategoryMMapperImpl implements CategoryMMapper {
	private static final String namespace = "kr.or.yi.java_web_male.dao.CategoryMMapper";
																		
	@Override
	public List<CategoryM> selectCategoryMByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectCategoryMByAll");  
		}
	}

	@Override
	public List<CategoryM> selectCategoryMByBNo(CategoryB cateB) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectCategoryMByBNo",cateB);
		}
	}

}

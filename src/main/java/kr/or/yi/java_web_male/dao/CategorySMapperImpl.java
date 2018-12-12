package kr.or.yi.java_web_male.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class CategorySMapperImpl implements CategorySMapper {
	private static final CategorySMapperImpl instance = new CategorySMapperImpl();

	public static CategorySMapperImpl getInstance() {
		return instance;
	}

	private CategorySMapperImpl() {}
	private static final String namespace = "kr.or.yi.java_web_male.dao.CategorySMapper";
																		
	@Override
	public List<CategoryS> selectCategorySByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectCategorySByAll");
		}
	}
	
	@Override
	public List<CategoryS> selectCategorySByBNoMno(CategoryM cateM) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectCategorySByBNoMno",cateM);
		}
	}

	@Override
	public CategoryS selectCategoryAllCode(CategoryS cateS) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+".selectCategoryAllCode",cateS);
		}
	}

}

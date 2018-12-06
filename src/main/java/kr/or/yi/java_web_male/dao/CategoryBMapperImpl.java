package kr.or.yi.java_web_male.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class CategoryBMapperImpl implements CategoryBMapper {
	private static final String namespace = "kr.or.yi.java_web_male.dao.CategoryBMapper";
	
	@Override
	public List<CategoryB> selectCategoryBByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectCategoryBByAll");
		}
	}

}

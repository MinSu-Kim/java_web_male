package kr.or.yi.java_web_male.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.BookBest10;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class BookBest10MapperImpl implements BookBest10Mapper {
	private static final BookBest10MapperImpl instance = new BookBest10MapperImpl();

	public static BookBest10MapperImpl getInstance() {
		return instance;
	}

	private BookBest10MapperImpl() {
	}
	
	private static final String namespace = "kr.or.yi.java_web_male.dao.BookBest10Mapper";
	
	@Override
	public List<BookBest10> selectBookBest10ByMap(Map<String, Object> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectBookBest10ByMap", map);
		}
	}

	@Override
	public List<BookBest10> selectBookByMap(Map<String, Object> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectBookByMap", map);
		}
	}

	

	

}

package kr.or.yi.java_web_male.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class BookMapperImpl implements BookMapper {
	private static final String namespace = "kr.or.yi.java_web_male.dao.BookMapper";
	
	@Override
	public List<Book> selectBookByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectBookByAll");
		}
	}

	@Override
	public Book selectbookbybookCode(Book book) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+".selectbookbybookCode",book);
		}
	}

	@Override
	public int insertBook(Book book) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.insert(namespace+".insertBook",book);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Book selectBookbyno(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

}
package kr.or.yi.java_web_male.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class BookRentalInfoMapperImpl implements BookRentalInfoMapper {
	private static final BookRentalInfoMapperImpl instance = new BookRentalInfoMapperImpl();
	public static BookRentalInfoMapperImpl getInstance() {
		return instance;
	}
	private BookRentalInfoMapperImpl() {}
	
	private static final String namespace = "kr.or.yi.java_web_male.dao.BookRentalInfoMapper";
	private static final String namespacekjy = "kr.or.yi.java_web_male.dao.BookRentalInfoMapperkjy";

	@Override
	public List<BookRentalInfo> selectBookRentalInfoByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectBookRentalInfoByAll");
		}
	}

	@Override
	public BookRentalInfo selectBookRentalInfoByCode(BookRentalInfo bookRentalInfo) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectBookRentalInfoByCode", bookRentalInfo);
		}
	}

	@Override
	public int insertBookRentalInfo(BookRentalInfo bookRentalInfo) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertBookRentalInfo", bookRentalInfo);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public List<BookRentalInfo> selectBookRentalInfoByBookCode(Book book) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespacekjy + ".selectBookRentalInfoByBookCode",book);
		}
	}

}

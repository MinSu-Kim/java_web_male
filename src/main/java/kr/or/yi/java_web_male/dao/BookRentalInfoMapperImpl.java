package kr.or.yi.java_web_male.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class BookRentalInfoMapperImpl implements BookRentalInfoMapper {
	private static final BookRentalInfoMapperImpl instance = new BookRentalInfoMapperImpl();

	public static BookRentalInfoMapperImpl getInstance() {
		return instance;
	}

	private BookRentalInfoMapperImpl() {
	}

	private static final String namespace = "kr.or.yi.java_web_male.dao.BookRentalInfoMapper";

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
			return sqlSession.selectList(namespace + ".selectBookRentalInfoByBookCode", book);
		}
	}

	@Override
	public List<BookRentalInfo> selectBookRentalMemberInfo(Member member) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectBookRentalMemberInfo", member);
		}
	}

	@Override
	public int nextCode() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".nextCode");
		}
	}

	@Override
	public List<BookRentalInfo> selectBookRentalInfoByMemberNo(Member member) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectBookByMemberNo", member);
		}
	}

	@Override
	public List<BookRentalInfo> selectBookByMemberNoReturnDateNull(Member member) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectBookByMemberNoReturnDateNull", member);
		}
	}

	@Override
	public BookRentalInfo selectRentalNoByBookCode(BookRentalInfo bookRentalInfo) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectRentalNoByBookCode", bookRentalInfo);
		}
	}

	@Override
	public int updateReturnDate(BookRentalInfo bookRentalInfo) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(namespace + ".updateReturnDate", bookRentalInfo);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public List<BookRentalInfo> selectRentalBookInfoByCategoryB(Member member) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectRentalBookInfoByCategoryB", member);

		}
	}

	@Override
	public BookRentalInfo selectRentalNoByBookCode_returnDateNull(BookRentalInfo bookRentalInfo) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectRentalNoByBookCode_returnDateNull", bookRentalInfo);
		}
	}

	@Override
	public int updateReturnSchedule(BookRentalInfo bookRentalInfo) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(namespace + ".updateReturnSchedule", bookRentalInfo);
			sqlSession.commit();
			return res;
		}
	}
}

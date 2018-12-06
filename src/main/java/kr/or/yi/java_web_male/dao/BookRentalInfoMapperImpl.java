package kr.or.yi.java_web_male.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class BookRentalInfoMapperImpl implements BookRentalInfoMapper{
	private static final String namespace = "kr.or.yi.java_web_male.dao.BookRentalInfoMapper";
	
	@Override
	public List<BookRentalInfo> selectBookRentalInfoByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectBookRentalInfoByAll");
		}
	}

	@Override
	public BookRentalInfo selectBookRentalInfoByNo(BookRentalInfo bookRentalInfo) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+".selectBookRentalInfoByNo",bookRentalInfo);
		}
	}

	@Override
	public int insertBookRentalInfo(BookRentalInfo bookRentalInfo) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.insert(namespace+".insertBookRentalInfo",bookRentalInfo);
			sqlSession.commit();
			return res;
		}
	}
}

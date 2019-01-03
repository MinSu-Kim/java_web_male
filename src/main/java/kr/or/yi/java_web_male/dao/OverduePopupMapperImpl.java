package kr.or.yi.java_web_male.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.OverduePopup;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class OverduePopupMapperImpl implements OverduePopupMapper {

	private static final OverduePopupMapperImpl instance = new OverduePopupMapperImpl();

	public static OverduePopupMapperImpl getInstance() {
		return instance;
	}

	private OverduePopupMapperImpl() {
	}
	
	private static final String namespace = "kr.or.yi.java_web_male.dao.OverduePopupMapper";
	
	@Override
	public List<OverduePopup> selectAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectAll");
		}
	}

	@Override
	public void updatedat() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(namespace + ".updatedat");
			sqlSession.commit();
		}
		
	}

	@Override
	public int selectDate() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectDate");
		}
	}

	@Override
	public List<OverduePopup> selectAllRentInfo() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectAllRentInfo");
		}
	}

}

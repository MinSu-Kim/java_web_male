package kr.or.yi.java_web_male.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.Overdue;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class OverdueMapperImpl implements OverdueMapper {
	
	private static final OverdueMapperImpl instance = new OverdueMapperImpl();
	public static OverdueMapperImpl getInstance() {
		return instance;
	}
	private OverdueMapperImpl() {}
	
	private static final String namespace = "kr.or.yi.java_web_male.dao.OverdueMapper";
	
	@Override
	public List<Overdue> selectOverdueByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectOverdueByAll");
		}
	}

	@Override
	public Overdue selectOverdueByCode(Overdue overdue) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectOverdueByCode", overdue);
		}
	}
	
	@Override
	public Overdue selectOverdueByMemberNo(Overdue overdue) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectOverdueByMemberNo", overdue);
		}
	}
	
	@Override
	public int insertOverdue(Overdue overdue) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertOverdue", overdue);
			sqlSession.commit();
			return res;
		}
	}
	
	
}

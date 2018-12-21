package kr.or.yi.java_web_male.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.MemberBest10;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class MemberBest10MapperImpl implements MemberBest10Mapper {
	private static final MemberBest10MapperImpl instance = new MemberBest10MapperImpl();

	public static MemberBest10MapperImpl getInstance() {
		return instance;
	}

	private MemberBest10MapperImpl() {
	}
	
	private static final String namespace = "kr.or.yi.java_web_male.dao.MemberBest10Mapper";
	
	@Override
	public List<MemberBest10> selectMemberBest10ByMap(Map<String, Object> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectMemberBest10ByMap", map);
		}
	}

}

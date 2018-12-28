package kr.or.yi.java_web_male.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class MemberMapperImpl implements MemberMapper {
	private static final MemberMapperImpl instance = new MemberMapperImpl();

	
	public static MemberMapperImpl getInstance() {
		return instance;
	}
	private MemberMapperImpl() {}
	

	private static final String namespace = "kr.or.yi.java_web_male.dao.MemberMapper";

	@Override
	public Member selectMemberByNo(Member member) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectMemberbyNo", member);
		}
	}

	@Override
	public List<Member> selectMemberByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectMemberByAll");
		}
	}

	@Override
	public int insertMember(Member member) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertMember", member);
			sqlSession.commit();
			return res;
		}

	}

	@Override
	public int deleteMember(int id) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".deleteMember", id);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateMember(Member member) {
		try (SqlSession sqlSesion = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSesion.update(namespace + ".updateMember", member);
			sqlSesion.commit();
			return res;
		}

	}

	@Override
	public int deleteMember(String id) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".deleteMember", id);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Member selectMemberByNo(String member) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectMemberByNoToString", member);
		}
	}

	@Override
	public List<Member> selectMemberByMemberNo() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectMemberByAll");
		}
	}

	@Override
	public List<Member> searchMemberNo(Map<String, String> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".searchMemberNo", map);
		}
	}

	@Override
	public List<Member> searchMemberName(Map<String, String> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace + ".searchMemberName", map);
		}
	}
	@Override
	public List<Member> searchMemberPhone(Map<String, String> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace + ".searchMemberPhone", map);
		}
	}

	@Override
	public List<Member> searchMembernoRent(Map<String, String> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace + ".searchMembernoRent", map);
		}
	}
	@Override
	public List<Member> selectMemberByNoList(Member member) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace + ".selectMemberByNoList", member);
		}
	}
	@Override
	public Member searchIdAndPw(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace + ".searchIdAndPw", map);
		}
	}
	@Override
	public int changePW(Map<String, Object> map) {
		try (SqlSession sqlSesion = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSesion.update(namespace + ".changePW", map);
			sqlSesion.commit();
			return res;
		}
	}
	
}
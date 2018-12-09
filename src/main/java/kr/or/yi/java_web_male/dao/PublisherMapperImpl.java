package kr.or.yi.java_web_male.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.Publisher;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class PublisherMapperImpl implements PublisherMapper {
	private static final String namespace = "kr.or.yi.java_web_male.dao.PublisherMapper";

	@Override
	public List<Publisher> selectPublisherByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectPublisherByAll");
		}
	}

}

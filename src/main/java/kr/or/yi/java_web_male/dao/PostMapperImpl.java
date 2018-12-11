package kr.or.yi.java_web_male.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_male.dto.Post;
import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class PostMapperImpl implements PostMapper {
	private static final String namespace = "kr.or.yi.java_web_male.dao.PostMapper";
	
	@Override
	public List<Post> selectPostByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectPostByAll");
		}
	}

	@Override
	public List<Post> selectPostByDoro(Post post) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectPostByDoro",post);
		}
	}

}

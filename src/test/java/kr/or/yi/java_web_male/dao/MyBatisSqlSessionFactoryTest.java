package kr.or.yi.java_web_male.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.java_web_male.jdbc.MyBatisSqlSessionFactory;

public class MyBatisSqlSessionFactoryTest extends AbstractTest{

	@Test
	public void testOpenSession() {
		log.debug("testOpenSession()");

		SqlSession session = MyBatisSqlSessionFactory.openSession();
		log.debug("session " + session);
		Assert.assertNotNull(session);
	}
}

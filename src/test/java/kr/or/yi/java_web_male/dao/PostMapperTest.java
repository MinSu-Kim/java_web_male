package kr.or.yi.java_web_male.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.java_web_male.dto.Post;

public class PostMapperTest extends AbstractTest{
	private PostMapper dao = new PostMapperImpl();
	
	/*@Test
	public void test01selectPostByAll() {
		log.debug("test01selectPostByAll");
		List<Post> postList = dao.selectPostByAll();
		Assert.assertNotNull(postList);
	}*/
	
	@Test
	public void test02selectPostByDoro() {
		log.debug("test02selectPostByDoro");
		Post post = new Post();
		
		post.setSido("대구광역시");
		post.setDoro("통학로46길");
		List<Post> postList = dao.selectPostByDoro(post);
		System.out.println(postList);
		Assert.assertNotNull(postList);
	}

}

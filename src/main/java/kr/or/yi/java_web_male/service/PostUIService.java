package kr.or.yi.java_web_male.service;

import java.util.List;

import kr.or.yi.java_web_male.dao.PostMapper;
import kr.or.yi.java_web_male.dao.PostMapperImpl;
import kr.or.yi.java_web_male.dto.Post;

public class PostUIService {
	private PostMapper postmapper = new PostMapperImpl();
	
	public List<Post> selectPostByDoro(Post post){
		return postmapper.selectPostByDoro(post);
	}
}

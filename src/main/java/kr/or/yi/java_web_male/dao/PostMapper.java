package kr.or.yi.java_web_male.dao;

import java.util.List;

import kr.or.yi.java_web_male.dto.Post;

public interface PostMapper {
	List<Post> selectPostByAll();
	
	List<Post> selectPostByDoro(Post post);

}

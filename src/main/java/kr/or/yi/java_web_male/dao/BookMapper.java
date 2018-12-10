package kr.or.yi.java_web_male.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dto.Book;

public interface BookMapper {
	List<Book> selectBookByAll();

	Book selectBookbyno(Book book);

	List<Book> selectbookbybookCode(Book book);

	int insertBook(Book book);
	
	int updateBook(Book book);

	List<Book> selectbookbyOther(Map<String, Object> map);
	
	

}

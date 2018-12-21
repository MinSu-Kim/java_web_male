package kr.or.yi.java_web_male.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dto.Book;

public interface BookMapper {
	List<Book> selectBookByAll();

	Book selectBookbyno(int i);

	List<Book> selectbookbybookCode(Book book);

	int insertBook(Book book);

	int updateBook(Book book);

	List<Book> selectbookbyOther(Map<String, Object> map);
	
	int updateBookPossible (Book book);
	
}

package kr.or.yi.java_web_male.dao;

import java.util.List;

import kr.or.yi.java_web_male.dto.Book;

public interface BookMapper {
	List<Book> selectBookByAll();
	Book selectbookbyno(Book book);	
}

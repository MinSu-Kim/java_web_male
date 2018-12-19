package kr.or.yi.java_web_male.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookBest10;
import kr.or.yi.java_web_male.dto.BookRentalInfo;

public interface BookBest10Mapper {
	List<BookBest10> selectBookBest10ByMap(Map<String, Object> map);

	
}

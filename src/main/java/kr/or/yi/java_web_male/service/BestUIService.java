package kr.or.yi.java_web_male.service;

import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dao.BookBest10Mapper;
import kr.or.yi.java_web_male.dao.BookBest10MapperImpl;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapper;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapperImpl;
import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookBest10;
import kr.or.yi.java_web_male.dto.BookRentalInfo;


public class BestUIService {
	/*private BookRentalInfoMapper bookRentalInfoMapper;*/
	private BookBest10Mapper best10Mapper;

	public BestUIService() {
		/*bookRentalInfoMapper = BookRentalInfoMapperImpl.getInstance();*/
		best10Mapper = BookBest10MapperImpl.getInstance();
	}	
	/*public List<BookRentalInfo> selectBookRentalInfoByAll() {
		return bookRentalInfoMapper.selectBookRentalInfoByAll();
	}
	public List<BookRentalInfo> selectBookRentalInfoByBookCode(Book book) {
		return bookRentalInfoMapper.selectBookRentalInfoByBookCode(book);
	}*/
	public List<BookBest10> selectBookBest10ByMap(Map<String, Object> map) {
		return best10Mapper.selectBookBest10ByMap(map);
	}
	
	
}

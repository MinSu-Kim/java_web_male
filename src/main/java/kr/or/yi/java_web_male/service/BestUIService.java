package kr.or.yi.java_web_male.service;

import java.util.List;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapper;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapperImpl;
import kr.or.yi.java_web_male.dto.BookRentalInfo;


public class BestUIService {
	private BookRentalInfoMapper bookRentalInfoMapper;

	public BestUIService() {
		bookRentalInfoMapper = BookRentalInfoMapperImpl.getInstance();
	}	
	public List<BookRentalInfo> selectBookRentalInfoByAll() {
		return bookRentalInfoMapper.selectBookRentalInfoByAll();
	}
}

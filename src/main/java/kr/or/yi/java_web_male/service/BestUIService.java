package kr.or.yi.java_web_male.service;

import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dao.BookBest10Mapper;
import kr.or.yi.java_web_male.dao.BookBest10MapperImpl;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapper;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapperImpl;
import kr.or.yi.java_web_male.dao.MemberBest10Mapper;
import kr.or.yi.java_web_male.dao.MemberBest10MapperImpl;
import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookBest10;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.MemberBest10;


public class BestUIService {
	private BookBest10Mapper best10Mapper;
	private MemberBest10Mapper memberBest10Mapper;

	public BestUIService() {
	
		best10Mapper = BookBest10MapperImpl.getInstance();
		memberBest10Mapper = MemberBest10MapperImpl.getInstance();
	}	
	
	public List<BookBest10> selectBookBest10ByMap(Map<String, Object> map) {
		return best10Mapper.selectBookBest10ByMap(map);
	}
	public List<MemberBest10> selectMemberBest10ByMap(Map<String, Object> map) {
		return memberBest10Mapper.selectMemberBest10ByMap(map);
	}
	public List<BookBest10> selectBookByMap(Map<String, Object> map) {
		return best10Mapper.selectBookByMap(map);
	}
	
	
}

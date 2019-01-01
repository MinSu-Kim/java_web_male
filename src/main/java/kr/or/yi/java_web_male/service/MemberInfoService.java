package kr.or.yi.java_web_male.service;

import java.util.List;

import kr.or.yi.java_web_male.dao.BookRentalInfoMapper;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapperImpl;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.Member;

public class MemberInfoService {
	private BookRentalInfoMapper bookRentalInfoMapper;

	public MemberInfoService() {
		bookRentalInfoMapper = BookRentalInfoMapperImpl.getInstance();
	}

	public List<BookRentalInfo> selectBookRentalMemberInfo(Member member) {
		return bookRentalInfoMapper.selectBookRentalMemberInfo(member);
	}
}

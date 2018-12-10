package kr.or.yi.java_web_male.dao;

import java.util.List;

import kr.or.yi.java_web_male.dto.BookRentalInfo;

public interface BookRentalInfoMapper {
	List<BookRentalInfo> selectBookRentalInfoByAll();

	BookRentalInfo selectBookRentalInfoByCode(BookRentalInfo bookRentalInfo);

	int insertBookRentalInfo(BookRentalInfo bookRentalInfo);
}

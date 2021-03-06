package kr.or.yi.java_web_male.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.Member;

public interface BookRentalInfoMapper {
	List<BookRentalInfo> selectBookRentalInfoByAll();

	BookRentalInfo selectBookRentalInfoByCode(BookRentalInfo bookRentalInfo);

	int insertBookRentalInfo(BookRentalInfo bookRentalInfo);

	List<BookRentalInfo> selectBookRentalInfoByBookCode(Book book);

	List<BookRentalInfo> selectBookRentalInfoByMemberNo(Member member);

	int nextCode();

	List<BookRentalInfo> selectBookRentalMemberInfo(Member member);
	
	List<BookRentalInfo> selectBookByMemberNoReturnDateNull(Member member);

	int updateReturnDate(BookRentalInfo bookRentalInfo);

	BookRentalInfo selectRentalNoByBookCode(BookRentalInfo bookRentalInfo);

	List<BookRentalInfo> selectRentalBookInfoByCategoryB(Member member);

	BookRentalInfo selectRentalNoByBookCode_returnDateNull(BookRentalInfo bookRentalInfo);

	int updateReturnSchedule(BookRentalInfo bookRentalInfo);

}

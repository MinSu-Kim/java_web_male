package kr.or.yi.java_web_male.service;

import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dao.BookMapper;
import kr.or.yi.java_web_male.dao.BookMapperImpl;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapper;
import kr.or.yi.java_web_male.dao.BookRentalInfoMapperImpl;
import kr.or.yi.java_web_male.dao.CategoryBMapper;
import kr.or.yi.java_web_male.dao.CategoryBMapperImpl;
import kr.or.yi.java_web_male.dao.CategoryMMapper;
import kr.or.yi.java_web_male.dao.CategoryMMapperImpl;
import kr.or.yi.java_web_male.dao.CategorySMapper;
import kr.or.yi.java_web_male.dao.CategorySMapperImpl;
import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dao.MemberMapperImpl;
import kr.or.yi.java_web_male.dao.PublisherMapper;
import kr.or.yi.java_web_male.dao.PublisherMapperImpl;
import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.Publisher;

public class LibraryUIService {
	private CategoryBMapper cateBMapper;
	private CategoryMMapper cateMMapper;
	private CategorySMapper cateSMapper;
	private PublisherMapper publisher;
	private BookMapper bookMapper;
	private BookRentalInfoMapper bookRentalInfoMapper;
	private MemberMapper memberMapper;

	public LibraryUIService() {

		bookRentalInfoMapper = BookRentalInfoMapperImpl.getInstance();

		cateBMapper = CategoryBMapperImpl.getInstance();
		cateMMapper = CategoryMMapperImpl.getInstance();
		cateSMapper = CategorySMapperImpl.getInstance();
		publisher = PublisherMapperImpl.getInstance();
		bookMapper = BookMapperImpl.getInstance();
		memberMapper = MemberMapperImpl.getInstance();
	}

	public List<CategoryB> selectCategoryBByAll() {
		return cateBMapper.selectCategoryBByAll();
	}

	public List<CategoryM> selectCategoryMByAll() {
		return cateMMapper.selectCategoryMByAll();
	}

	public List<CategoryS> selectCategorySByAll() {
		return cateSMapper.selectCategorySByAll();
	}

	public List<CategoryS> selectCategorySByBNoMno(CategoryM cateM) {
		return cateSMapper.selectCategorySByBNoMno(cateM);
	}

	public CategoryS selectCategoryAllCode(CategoryS cateS) {
		return cateSMapper.selectCategoryAllCode(cateS);
	}

	public List<CategoryM> selectCategoryMByBNo(CategoryB cateB) {
		return cateMMapper.selectCategoryMByBNo(cateB);
	}

	public List<Publisher> selectPublisherByAll() {
		return publisher.selectPublisherByAll();
	}

	public Publisher selectPublisherByNo(Publisher pub) {
		return publisher.selectPublisherByNo(pub);
	}

	public Publisher selectPublisherByName(Publisher pub) {
		return publisher.selectPublisherByName(pub);
	}

	public List<Book> selectbookbybookCode(Book book) {
		return bookMapper.selectbookbybookCode(book);
	}

	public Book selectbookbybookCodeOne(Book book) {
		return bookMapper.selectBookBybookCodeOne(book);
	}

	public List<Book> selectbookbyOther(Map<String, Object> map) {
		return bookMapper.selectbookbyOther(map);
	}

	public int deleteBook(Map<String, Object> map) {
		return bookMapper.deleteBook(map);
	}

	public int updateBook(Book book) {
		return bookMapper.updateBook(book);
	}

	public List<BookRentalInfo> selectBookRentalInfoByBookCode(Book book) {
		return bookRentalInfoMapper.selectBookRentalInfoByBookCode(book);
	}

	public int insertBookRentalInfo(BookRentalInfo bookRentalInfo) {
		return bookRentalInfoMapper.insertBookRentalInfo(bookRentalInfo);
	}

	public BookRentalInfo selectRentalNoByBookCode(BookRentalInfo bookRentalInfo) {
		return bookRentalInfoMapper.selectRentalNoByBookCode(bookRentalInfo);
	}
	
	public BookRentalInfo selectBookRentalInfoByCode(BookRentalInfo bookRentalInfo) {
		return bookRentalInfoMapper.selectBookRentalInfoByCode(bookRentalInfo);
	}

	public int nextCode() {
		return bookRentalInfoMapper.nextCode();
	}

	public int updateBookPossible(Book book) {
		return bookMapper.updateBookPossible(book);
	}

	public int updateReturnDate(BookRentalInfo bookRentalInfo) {
		return bookRentalInfoMapper.updateReturnDate(bookRentalInfo);
	}

	public BookRentalInfo selectRentalNoByBookCode_returnDateNull(BookRentalInfo bookRentalInfo) {
		return bookRentalInfoMapper.selectRentalNoByBookCode_returnDateNull(bookRentalInfo);
	}

	public Book selectBookUpdate(Book book) {
		return bookMapper.selectBookUpdate(book);
	}

	public int updateReturnSchedule(BookRentalInfo bookRentalInfo) {
		return bookRentalInfoMapper.updateReturnSchedule(bookRentalInfo);
	}
	public Member selectMemberbyNo(String member) {
		return memberMapper.selectMemberByNo(member);
	}
}

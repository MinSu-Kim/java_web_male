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
import kr.or.yi.java_web_male.dao.PublisherMapper;
import kr.or.yi.java_web_male.dao.PublisherMapperImpl;
import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.Publisher;

public class LibraryUIService {
	private CategoryBMapper cateBMapper;
	private CategoryMMapper cateMMapper;
	private CategorySMapper cateSMapper;
	private PublisherMapper publisher;
	private BookMapper bookMapper;
	private BookRentalInfoMapper bookRentalInfoMapper;

	public LibraryUIService() {

		
		bookRentalInfoMapper = BookRentalInfoMapperImpl.getInstance();
		

		cateBMapper = CategoryBMapperImpl.getInstance();
		cateMMapper =  CategoryMMapperImpl.getInstance();
		cateSMapper =  CategorySMapperImpl.getInstance();
		publisher = PublisherMapperImpl.getInstance();
		bookMapper =  BookMapperImpl.getInstance();
		

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

	public List<Book> selectbookbyOther(Map<String, Object> map) {
		return bookMapper.selectbookbyOther(map);
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
	
	public int nextCode() {
		return bookRentalInfoMapper.nextCode();
	}
	
	public int updateBookPossible (Book book) {
		return bookMapper.updateBookPossible(book);
	}

}

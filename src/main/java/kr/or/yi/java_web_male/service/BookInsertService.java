package kr.or.yi.java_web_male.service;

import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dao.BookMapper;
import kr.or.yi.java_web_male.dao.BookMapperImpl;
import kr.or.yi.java_web_male.dao.CategoryBMapper;
import kr.or.yi.java_web_male.dao.CategoryBMapperImpl;
import kr.or.yi.java_web_male.dao.CategoryMMapper;
import kr.or.yi.java_web_male.dao.CategoryMMapperImpl;
import kr.or.yi.java_web_male.dao.CategorySMapper;
import kr.or.yi.java_web_male.dao.CategorySMapperImpl;
import kr.or.yi.java_web_male.dao.PublisherMapper;
import kr.or.yi.java_web_male.dao.PublisherMapperImpl;
import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.Publisher;

public class BookInsertService {
	private BookMapper bookMapper;
	private PublisherMapper publisherMapper;
	private CategoryBMapper bMapper;
	private CategoryMMapper mMapper;
	private CategorySMapper sMapper;

	public BookInsertService() {
		bookMapper = BookMapperImpl.getInstance();
		publisherMapper = PublisherMapperImpl.getInstance();
		bMapper = CategoryBMapperImpl.getInstance();
		mMapper = CategoryMMapperImpl.getInstance();
		sMapper = CategorySMapperImpl.getInstance();
	}

	public List<Book> selectBookByAll() {
		return bookMapper.selectBookByAll();
	}

	public int insertBook(Book book) {
		return bookMapper.insertBook(book);
	}

	public List<Book> selectbookbyOther(Map<String, Object> map) {
		return bookMapper.selectbookbyOther(map);
	}

	public List<Publisher> selectPublisherByAll() {
		return publisherMapper.selectPublisherByAll();
	}

	public Publisher selectPublisherByName(Publisher publisher) {
		return publisherMapper.selectPublisherByName(publisher);
	}

	public int insertPublisher(Publisher publisher) {
		return publisherMapper.insertPublisher(publisher);
	}

	public List<CategoryB> selectCategoryBByAll() {
		return bMapper.selectCategoryBByAll();
	}

	public List<CategoryM> selectCategoryMByAll() {
		return mMapper.selectCategoryMByAll();
	}

	public List<CategoryM> selectCategoryMByBNo(CategoryB cateB) {
		return mMapper.selectCategoryMByBNo(cateB);
	}

	public List<CategoryS> selectCategorySByAll() {
		return sMapper.selectCategorySByAll();
	}

	public List<CategoryS> selectCategorySByBNoMno(CategoryM cateM) {
		return sMapper.selectCategorySByBNoMno(cateM);
	}

}

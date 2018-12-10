package kr.or.yi.java_web_male.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.Publisher;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookMapperImplTest extends AbstractTest {

	private BookMapper dao = new BookMapperImpl();
	private PublisherMapper dao2 = new PublisherMapperImpl();
	private CategoryBMapper dao1 = new CategoryBMapperImpl();

	@Test
	public void test01selectBookByAll() {
		log.debug("test01selectBookByAll");
		List<Book> stdList = dao.selectBookByAll();
		Assert.assertNotNull(stdList);
	}

	@Test
	public void test02selectbookbybookCode() {
		log.debug("test02selectbookbybookCode");
		Book book = new Book();
		book.setBookCode("000");
		List<Book> stdList = dao.selectbookbybookCode(book);
		Assert.assertNotNull(stdList);
	}

	@Test
	public void test04selectCategoryBByAll() {
		log.debug("test04selectCategoryBByAll");
		List<CategoryB> stdList = dao1.selectCategoryBByAll();
		Assert.assertNotNull(stdList);
	}
	@Test
	public void test05selectPublisherByAll() {
		log.debug("test05selectPublisherByAll");
		List<Publisher> stdList = dao2.selectPublisherByAll();
		Assert.assertNotNull(stdList);
	}
	@Test
	public void test06selectPublisherByNo() {
		log.debug("test06selectPublisherByNo");
		Publisher Publisher = new Publisher();
		Publisher.setPubNo("P001");
		Publisher stdList = dao2.selectPublisherByNo(Publisher);
		Assert.assertNotNull(stdList);
	}
}

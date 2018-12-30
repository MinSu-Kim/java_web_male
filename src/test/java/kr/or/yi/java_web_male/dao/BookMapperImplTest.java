package kr.or.yi.java_web_male.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.Publisher;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookMapperImplTest extends AbstractTest {

	private BookMapper dao = BookMapperImpl.getInstance();
	private PublisherMapper dao2 = PublisherMapperImpl.getInstance();
	private CategoryBMapper dao1 = CategoryBMapperImpl.getInstance();

	/*@Test
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

	@Test
	public void test07selectbookbyOther() {
		log.debug("test07selectbookbyOther");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pubNo", "P001");
		List<Book> stdList = dao.selectbookbyOther(map);
		Assert.assertNotNull(stdList);
	}

	@Test
	public void test08InsertBook() {
		Publisher p = new Publisher();
		p.setPubNo("P001");

		CategoryB categoryB = new CategoryB();
		categoryB.setbCode(0);
		categoryB.setbName("1");

		CategoryM categoryM = new CategoryM();
		categoryM.setmCode(0);
		categoryM.setmName("1");

		CategoryS categoryS = new CategoryS();
		categoryS.setsCode(0);
		categoryS.setsName("1");

		log.debug("test08InsertBook()");
		Book book = new Book();
		book.setBookCode("001158");
		book.setBookNo(123);
		book.setTitle("자바의 호우");
		book.setAuthor("호우");
		book.setTranslator("호우");
		book.setAuthor("작가");
		book.setTranslator("역자");
		book.setCateBNo(categoryB);
		book.setCateMNo(categoryM);
		book.setCateSNo(categoryS);
		book.setPrice(1000);
		int res = dao.insertBook(book);
		Assert.assertEquals(1, res);
	}*/
	
	@Test
	public void test07selectbookbyOther() {
		log.debug("test07selectbookbyOther");
		Book book = new Book();
		book.setBookCode("0040000201");
		book = dao.selectBookUpdate(book);
		System.out.println(book);
		Assert.assertNotNull(book);
	}
}

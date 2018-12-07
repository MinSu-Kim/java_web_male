package kr.or.yi.java_web_male.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.Publisher;

/*@FixMethodOrder(MethodSorters.NAME_ASCENDING)*/
public class BookMapperImplTest extends AbstractTest {

	private BookMapper dao = new BookMapperImpl();

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
		book.setBookCode("00001");
		book = dao.selectbookbybookCode(book);
		Assert.assertNotNull(book);
	}

	@Test
	public void test03insertStudent() {
		log.debug("test03insertStudent");
		Book bookex = new Book();
		CategoryB b = new CategoryB(0, "총류");
		CategoryM m = new CategoryM(0, "총류", b);
		CategoryS s = new CategoryS(0, "총류", m, b);
		Publisher p = new Publisher("P001", "영남인제교육원");
		Book book = new Book("00003", 2, p, "김재영", null, null, 50000, true, null, s, m, b);
		int res = dao.insertBook(book);
		Assert.assertEquals(1, res);
	}
}

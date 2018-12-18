package kr.or.yi.java_web_male.dao;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.Publisher;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookRentalInfoMapperTest extends AbstractTest {

	private BookRentalInfoMapper dao = BookRentalInfoMapperImpl.getInstance();

	@Test
	public void test0selectBookRentalInfoByAll() {
		log.debug("test0selectBookRentalInfoByAll");
		List<BookRentalInfo> rentList = dao.selectBookRentalInfoByAll();
		Assert.assertNotNull(rentList);
	}

	@Test
	public void test02selectBookRentalInfoByCode() {
		log.debug("test02selectBookRentalInfoByCode");
		BookRentalInfo bookRentalInfo1 = new BookRentalInfo();
		bookRentalInfo1.setRentalNo(3);
		BookRentalInfo bookRentalInfo = dao.selectBookRentalInfoByCode(bookRentalInfo1);
		System.out.println(bookRentalInfo);
		Assert.assertNotNull(bookRentalInfo);
	}

	@Test
	public void test03insertBookRentalInfo() {
		log.debug("test03insertBookRentalInfo");
		BookRentalInfo bookRentalInfo = new BookRentalInfo();
		 
		Member me = new  Member();
		me.setMemberNo("2");
		
		Book bo = new Book();
		bo.setBookCode("00001");
		
		BookRentalInfo bookRentalInfo1 = new BookRentalInfo(4, new Date(), null, new Date(), me, bo);
		int res = dao.insertBookRentalInfo(bookRentalInfo1);
		Assert.assertEquals(1, res);
	}
}

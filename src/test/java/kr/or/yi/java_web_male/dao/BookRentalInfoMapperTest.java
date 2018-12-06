package kr.or.yi.java_web_male.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.CategoryB;
import kr.or.yi.java_web_male.dto.CategoryM;
import kr.or.yi.java_web_male.dto.CategoryS;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.Publisher;

public class BookRentalInfoMapperTest extends AbstractTest{

	private BookRentalInfoMapper dao = new BookRentalInfoMapperImpl();
	
	
	@Test
	public void test0selectBookRentalInfoByAll() {
		log.debug("test0selectBookRentalInfoByAll");
		List<BookRentalInfo> rentList = dao.selectBookRentalInfoByAll();
		Assert.assertNotNull(rentList);
	}
	
	@Test
	public void test02selectBookRentalInfoByNo() {
		log.debug("test02selectBookRentalInfoByNo");
		BookRentalInfo bookRentalInfo = new BookRentalInfo();
		bookRentalInfo.setRentalNo(1);
		bookRentalInfo = dao.selectBookRentalInfoByNo(bookRentalInfo);
		Assert.assertNotNull(bookRentalInfo);
	}
	
	@Test
	public void test03insertBookRentalInfo() {
		log.debug("test03insertBookRentalInfo");
		BookRentalInfo bookRentalInfo = new BookRentalInfo();
		/*Calendar newDate = GregorianCalendar.getInstance();*/
		CategoryB b = new CategoryB(0,"총류");
		CategoryM m = new CategoryM(0,"총류",b);
		CategoryS s = new CategoryS(0,"총류",m,b);
		Publisher p = new Publisher("P001","영남인제교육원");
		Member me = new Member("1", "232", "모코코", "mococo", "010-3333-3333", "999999-1111111", "mococo@naver.com", "토토이크섬 모코코마을", "씨앗", 1, "쪼꼬미");
		Book bo = new Book("c001", 1, p, "ee", "rr", "tt", 2, false, "dd", s, m, b);
		BookRentalInfo bookRentalInfo1 = new BookRentalInfo(1,new Date(),null,new Date(+7),me,bo);
		int res = dao.insertBookRentalInfo(bookRentalInfo);
		
		Assert.assertEquals(1, res);
	}
}

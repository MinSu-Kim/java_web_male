package kr.or.yi.java_web_male.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.java_web_male.dto.Book;
import kr.or.yi.java_web_male.dto.BookRentalInfo;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.MemberRentalInfo;

public class MemberRentalInfoMapperTest extends AbstractTest{
	
	private MemberRentalInfoMapper dao = MemberRentalInfoMapperImpl.getInstance();
	
	@Test
	public void test01selectMemberRentalInfoByAll() {
		log.debug("test0selectMemberRentalInfoByAll");
		List<MemberRentalInfo> rentList = dao.selectMemberRentalInfoByAll();
		Assert.assertNotNull(rentList);
	}
	
	@Test
	public void test10selectMemberRentalInfoByCode() {
		log.debug("test02selectMemberRentalInfoByCode");
		MemberRentalInfo memberRentalInfo = new MemberRentalInfo();
		memberRentalInfo.setMemberNo("2");
		MemberRentalInfo memberRentalInfo1 = dao.selectMemberRentalInfoByCode(memberRentalInfo);
		Assert.assertNotNull(memberRentalInfo1);
	}
	
	@Test
	public void test03insertMemberRentalInfo() {
		log.debug("test03insertMemberRentalInfo");
		MemberRentalInfo memberRentalInfo = new MemberRentalInfo();
		 
		memberRentalInfo.setMemberNo("123");
		memberRentalInfo.setGrade(1);
		memberRentalInfo.setNowTotal(1);
		memberRentalInfo.setTotal(2);
		int res = dao.insertMemberRentalInfo(memberRentalInfo);
		Assert.assertEquals(1, res);
	}
	
	
	
}

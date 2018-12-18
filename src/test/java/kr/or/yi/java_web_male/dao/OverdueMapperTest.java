package kr.or.yi.java_web_male.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_male.dto.MemberRentalInfo;
import kr.or.yi.java_web_male.dto.Overdue;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OverdueMapperTest extends AbstractTest{
	
	private OverdueMapper dao = OverdueMapperImpl.getInstance();
	
	@Test
	public void test01selectOverdueByAll() {
		log.debug("test01selectOverdueByAll");
		List<Overdue> rentList = dao.selectOverdueByAll();
		Assert.assertNotNull(rentList);
	}
	
	@Test
	public void test02selectOverdueByCode() {
		log.debug("test02selectOverdueByCode");
		Overdue overdue = new Overdue();
		overdue.setMemberNo("2");
		Overdue overdue1 = dao.selectOverdueByCode(overdue);
		Assert.assertNotNull(overdue1);
	}
	
	@Test
	public void test03selectOverdueByMemberNo() {
		log.debug("test02selectOverdueByMemberNo");
		Overdue overdue = new Overdue();
		overdue.setMemberNo("2");
		Overdue overdue1 = dao.selectOverdueByMemberNo(overdue);
		Assert.assertNotNull(overdue1);
	}
	
	/*@Test
	public void test04insertOverdue() {
		log.debug("test03insertOverdue");
		Overdue overdue = new Overdue();
		 
		overdue.setMemberNo("123");
		overdue.setStopDate(0);
		overdue.setOverdueCount(0);
		overdue.setRentalAuthority(true);
		int res = dao.insertOverdue(overdue);
		Assert.assertEquals(1, res);
	}*/

}

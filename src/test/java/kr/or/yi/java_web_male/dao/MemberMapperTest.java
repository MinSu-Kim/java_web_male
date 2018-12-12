package kr.or.yi.java_web_male.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_male.dto.Member;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberMapperTest {
	private MemberMapper dao = MemberMapperImpl.getInstance();

	@Test
	public void test01inSertMember() {
		Member member = new Member();
		member.setMemberNo("1");
		member.setPassword("tgkdsfld");
		member.setKorName("서동준");
		member.setEngName("seo-dong-june");
		member.setPhone("010-2230-6796");
		member.setJumin("921012-*******");
		member.setEmail("super@naver.com");
		member.setAddress("깊은산속 옹달샘");
		member.setPhoto("박예븜");
		member.setAdmin(1);
		member.setUniqueness("아 한번에 안되겠지");
		System.out.println(member);
	/*	int res = dao.insertMember(member);
		Assert.assertEquals(1, res);*/
	}
	/*모두선택*/
	@Test
	public void test02selectMemberByAll() {
		List<Member> list = dao.selectMemberByAll();
		Assert.assertNotNull(list);
	}
	/*검색*/
	@Test
	public void test03selectMemberByNo() {
		Member searchMem = new Member();
		searchMem.setMemberNo("1");

		Member searchedMem = dao.selectMemberByNo(searchMem);
		Assert.assertNotNull(searchedMem);
	}
	/*로그인*/
	@Test
	public void test04selectMemberByNo() {
		String searchStr = "1";

		Member searchedMem = dao.selectMemberByNo(searchStr);
		Assert.assertNotNull(searchedMem);
	}

	@Test
	public void test05UpdateMember() {
		Member member = new Member();
		member.setMemberNo("1");
		member.setPassword("donggay");
		member.setKorName("김동준");
		member.setEngName("gayking");
		member.setPhone("010-4354-2435");
		member.setJumin("647412-******");
		member.setEmail("supterdongte@naver.com");
		member.setAddress("이건 비밀입니닷");
		member.setPhoto("김예쁨");
		member.setAdmin(1);
		member.setUniqueness("내가 고자라닛");
		int res = dao.updateMember(member);
		Assert.assertSame(1, res);
	}

	/*@Test
	public void test06DeleteMember() {
		int deleteMember = dao.deleteMember("1");
		Assert.assertSame(1, deleteMember);

	}*/
	@Test
	public void test07searchMemberno() {
		Map<String, String> map = new HashMap<>();
		map.put("memberNo", "3");
		Member list = dao.searchMemberNo(map);
		Assert.assertNotNull(list);
	}
}// end of testClass

package kr.or.yi.java_web_male.dao;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


import kr.or.yi.java_web_male.dto.Member;



public class MemberMapperTest {
	private MemberMapper dao = new MemberMapperImpl();
	@Test
	public void test() {
		Member member = new Member();
		member.setMemberNo("1");
		member.setPassword("tgkdsfld");
		member.setKor_name("서동준");
		member.setEng_name("seo-dong-june");
		member.setPhone("010-2230-6796");
		member.setJumin("921012-*******");
		member.setEmail("super@naver.com");
		member.setAddress("깊은산속 옹달샘");
		member.setPhoto("박예븜");
		member.setAdmin(1);
		member.setUniqueness("아 한번에 안되겠지");
		int res = dao.insertMember(member);
		Assert.assertEquals(1, res);
	}

}

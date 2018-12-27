package kr.or.yi.java_web_male.service;

import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dao.MemberMapperImpl;
import kr.or.yi.java_web_male.dto.Member;

public class LoginService {
	private MemberMapper memberMapper;

	public LoginService() {
		memberMapper = MemberMapperImpl.getInstance();
	}
	
	public Member selectMemberByNo(String member) {
		return memberMapper.selectMemberByNo(member);
	}

}

package kr.or.yi.java_web_male.service;

import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dao.MemberMapperImpl;
import kr.or.yi.java_web_male.dto.Member;

public class LoginUIService {
	private MemberMapper memberMapper;
	
	public LoginUIService() {
	
		memberMapper = MemberMapperImpl.getInstance();
	}
	public Member selectBookByMapForeSum(Map<String, Object> map) {
		return memberMapper.searchIdAndPw(map);
	}
}

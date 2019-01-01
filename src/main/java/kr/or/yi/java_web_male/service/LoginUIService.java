package kr.or.yi.java_web_male.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dao.MemberMapperImpl;
import kr.or.yi.java_web_male.dao.OverduePopupMapper;
import kr.or.yi.java_web_male.dao.OverduePopupMapperImpl;
import kr.or.yi.java_web_male.dto.Member;

public class LoginUIService {
	private MemberMapper memberMapper;
	private OverduePopupMapper overduePopupMapper;
	
	public LoginUIService() {
	
		memberMapper = MemberMapperImpl.getInstance();
		overduePopupMapper = OverduePopupMapperImpl.getInstance();
	}
	public Member selectBookByMapForeSum(Map<String, Object> map) {
		return memberMapper.searchIdAndPw(map);
	}
	
	public int changePW(Map<String, Object> map) {
		return memberMapper.changePW(map);
	}
	public int selectDate() {
		return overduePopupMapper.selectDate();
	}
	
}

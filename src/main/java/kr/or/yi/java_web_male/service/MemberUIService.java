package kr.or.yi.java_web_male.service;

import java.util.List;

import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dao.MemberMapperImpl;
import kr.or.yi.java_web_male.dto.Member;

public class MemberUIService {
	private MemberMapper dao = new MemberMapperImpl();
	
	public List<Member> selectMemberByAll(){
		return dao.selectMemberByAll();
	}
		
}

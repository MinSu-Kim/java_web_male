package kr.or.yi.java_web_male.service;

import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dao.MemberMapperImpl;
import kr.or.yi.java_web_male.dto.Member;

public class MemberUIService {

	private MemberMapper dao =  MemberMapperImpl.getInstance();


	public List<Member> selectMemberByAll(){
		return dao.selectMemberByAll();
	}

	public Member searchMemberNo(Map<String, String> map) {
		return dao.searchMemberNo(map);
	}
	public Member searchMemberName(Map<String, String> map) {
		return dao.searchMemberName(map);
	}
	public Member searchMemberPhone(Map<String, String> map) {
		return dao.searchMemberPhone(map);
	}

	public Member selectMemberByNo(Member member){
		return dao.selectMemberByNo(member);
	}
		

}

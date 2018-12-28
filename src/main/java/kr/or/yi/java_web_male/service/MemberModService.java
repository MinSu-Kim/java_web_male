package kr.or.yi.java_web_male.service;

import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dao.MemberMapperImpl;
import kr.or.yi.java_web_male.dto.Member;

public class MemberModService {
	private MemberMapper memberMapper;

	public MemberModService() {
		memberMapper = MemberMapperImpl.getInstance();
	}

	public int updateMember(Member member) {
		return memberMapper.updateMember(member);
	}

	public Member selectMemberByNo(String member) {
		return memberMapper.selectMemberByNo(member);
	}

}

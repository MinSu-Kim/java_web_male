package kr.or.yi.java_web_male.dao;

import java.util.List;

import kr.or.yi.java_web_male.dto.Member;

public interface MemberMapper {
	Member selectMemberbyNo(Member member);

	List<Member> selectMemberByAll();

	int insertMember(Member member);

	int deleteMember(int id);
}

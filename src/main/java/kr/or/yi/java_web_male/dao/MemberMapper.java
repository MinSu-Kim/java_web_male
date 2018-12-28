package kr.or.yi.java_web_male.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dto.Member;

public interface MemberMapper {
	Member selectMemberByNo(Member member);

	List<Member> selectMemberByAll();

	int insertMember(Member member);

	int updateMember(Member member);

	int deleteMember(int id);

	int deleteMember(String id);
	
	int deleteMemberNo(Map<String, Object> map);
	
	Member selectMemberByNo(String member);
	
	List<Member> selectMemberByMemberNo();
	
	List<Member> selectMemberByNoList(Member member);
	
	
	//프로시저 해시맵
//	List<Map<String, String>> searchMemberNo(Map<String, String> map);
	List<Member> searchMemberNo(Map<String, String> map);

	/*Member searchMemberName(Map<String, String> map);*/
	List<Member> searchMemberName(Map<String, String> map);
	
	List<Member> searchMemberPhone(Map<String, String>map);
	//대여된 책 확인하기 해쉬맵
	List<Member> searchMembernoRent(Map<String, String> map);
	
	Member searchIdAndPw(Map<String, Object> map);
	
	int changePW(Map<String, Object> map);

	List<Member> selectMemberByNojumin(Member member);
	
	
}

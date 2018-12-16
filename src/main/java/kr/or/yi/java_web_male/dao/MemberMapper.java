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

	Member selectMemberByNo(String member);
	
	List<Member> selectMemberByMemberNo();
	

	//프로시저 해시맵
//	List<Map<String, String>> searchMemberNo(Map<String, String> map);
	Member searchMemberNo(Map<String, String> map);

	/*Member searchMemberName(Map<String, String> map);*/
	List<Member> searchMemberName(Map<String, String> map);
	
	Member searchMemberPhone(Map<String, String>map);

}

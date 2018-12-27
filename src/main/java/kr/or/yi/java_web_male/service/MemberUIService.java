package kr.or.yi.java_web_male.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dao.MemberMapperImpl;
import kr.or.yi.java_web_male.dao.MemberRentalInfoMapper;
import kr.or.yi.java_web_male.dao.MemberRentalInfoMapperImpl;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.MemberRentalInfo;

public class MemberUIService {

	private MemberMapper dao =  MemberMapperImpl.getInstance();
	
	private MemberRentalInfoMapper dao1 = MemberRentalInfoMapperImpl.getInstance();
	
	
	public List<Member> selectMemberByAll(){
		return dao.selectMemberByAll();
	}

	public Member searchMemberNo(Map<String, String> map) {
		return dao.searchMemberNo(map);
	}
	public List<Member> searchMemberName(Map<String, String> map) {
		return dao.searchMemberName(map);
	}
	public Member searchMemberPhone(Map<String, String> map) {
		return dao.searchMemberPhone(map);
	}

	public Member selectMemberByNo(Member member){
		return dao.selectMemberByNo(member);
	}
	public Member selectMemberByNo2(String string){
		return dao.selectMemberByNo(string);
	}
	public int updateMember(Member member) {
		return dao.updateMember(member);
	}
	public List<Member>  searchMembernoRent(Map<String, String> map) {
		return dao.searchMembernoRent(map);
	}
	public int insertMember(Member member) {
		return dao.insertMember(member);
	}
	
	public List<Member> selectMemberByNoList(Member member) {
		return dao.selectMemberByNoList(member);
	}
	
	public int updateMemberRentalInfo(MemberRentalInfo memberRentalInfo) {
		return dao1.updateMemberRentalInfo(memberRentalInfo);
	}
	
	public int updateMemberRentalInfoGrade(MemberRentalInfo memberRentalInfo) {
		return dao1.updateMemberRentalInfoGrade(memberRentalInfo);
	}
	
	public MemberRentalInfo selectMemberNowTotalByCode(MemberRentalInfo memberRentalInfo) {
		return dao1.selectMemberNowTotalByCode(memberRentalInfo);
	}
	
	public MemberRentalInfo selectMemberTotalByCode(MemberRentalInfo memberRentalInfo) {
		return dao1.selectMemberTotalByCode(memberRentalInfo);
	}
	
	public MemberRentalInfo selectMemberGradeByCode(MemberRentalInfo memberRentalInfo) {
		return dao1.selectMemberGradeByCode(memberRentalInfo);
	}
	public List<Member> selectMemberByMemberNo(){
		return dao.selectMemberByMemberNo();
	}
}

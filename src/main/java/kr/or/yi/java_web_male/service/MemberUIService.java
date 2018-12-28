package kr.or.yi.java_web_male.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dao.MemberMapper;
import kr.or.yi.java_web_male.dao.MemberMapperImpl;
import kr.or.yi.java_web_male.dao.MemberRentalInfoMapper;
import kr.or.yi.java_web_male.dao.MemberRentalInfoMapperImpl;
import kr.or.yi.java_web_male.dao.OverdueMapper;
import kr.or.yi.java_web_male.dao.OverdueMapperImpl;
import kr.or.yi.java_web_male.dto.Member;
import kr.or.yi.java_web_male.dto.MemberRentalInfo;
import kr.or.yi.java_web_male.dto.Overdue;

public class MemberUIService {

	private MemberMapper dao =  MemberMapperImpl.getInstance();
	
	private MemberRentalInfoMapper dao1 = MemberRentalInfoMapperImpl.getInstance();
	
	private OverdueMapper dao2 = OverdueMapperImpl.getInstance();
	
	
	public List<Member> selectMemberByAll(){
		return dao.selectMemberByAll();
	}

	/*public Member searchMemberNo(Map<String, String> map) {
		return dao.searchMemberNo(map);
	}*/
	public List<Member> searchMemberNo(Map<String, String> map) {
		return dao.searchMemberNo(map);
	}
	public List<Member> searchMemberName(Map<String, String> map) {
		return dao.searchMemberName(map);
	}
	public List<Member> searchMemberPhone(Map<String, String> map) {
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
	public List<Member> selectMemberByNojumin(Member member){
		return dao.selectMemberByNojumin(member);
	}
	public int updateMemberRentalInfo(MemberRentalInfo memberRentalInfo) {
		return dao1.updateMemberRentalInfo(memberRentalInfo);
	}
	
	public int updateMemberRentalInfo2(MemberRentalInfo memberRentalInfo) {
		return dao1.updateMemberRentalInfo2(memberRentalInfo);
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

	
	public Overdue selectOverdueByCode(Overdue overdue) {
		return dao2.selectOverdueByCode(overdue);
	}
	
	public int updateCount(Overdue overdue) {
		return dao2.updateCount(overdue);
	}
	
	public int updateStopDate(Overdue overdue) {
		return dao2.updateStopDate(overdue);
	}

	public List<Member> selectMemberByMemberNo(){
		return dao.selectMemberByMemberNo();
	}
	public int deleteMemberNo(Map<String, Object> map){
		return dao.deleteMemberNo(map);
	}
}

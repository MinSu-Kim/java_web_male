package kr.or.yi.java_web_male.dao;

import java.util.List;

import kr.or.yi.java_web_male.dto.MemberRentalInfo;

public interface MemberRentalInfoMapper {
	List<MemberRentalInfo> selectMemberRentalInfoByAll();

	MemberRentalInfo selectMemberRentalInfoByCode(MemberRentalInfo memberRentalInfo);
	
	int insertMemberRentalInfo(MemberRentalInfo memberRentalInfo);
	
	int updateMemberRentalInfo(MemberRentalInfo memberRentalInfo);
	
	int updateMemberRentalInfoGrade(MemberRentalInfo memberRentalInfo);
	
	int updateMemberRentalInfo2(MemberRentalInfo memberRentalInfo);
	
	MemberRentalInfo selectMemberNowTotalByCode(MemberRentalInfo memberRentalInfo);
	
	MemberRentalInfo selectMemberTotalByCode(MemberRentalInfo memberRentalInfo);
	
	MemberRentalInfo selectMemberGradeByCode(MemberRentalInfo memberRentalInfo);
}

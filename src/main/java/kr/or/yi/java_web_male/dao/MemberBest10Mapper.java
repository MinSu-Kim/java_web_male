package kr.or.yi.java_web_male.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_male.dto.MemberBest10;

public interface MemberBest10Mapper {
	List<MemberBest10> selectMemberBest10ByMap(Map<String, Object> map);
}

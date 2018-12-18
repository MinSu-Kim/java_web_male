package kr.or.yi.java_web_male.dao;

import java.util.List;

import kr.or.yi.java_web_male.dto.Overdue;

public interface OverdueMapper {
	List<Overdue> selectOverdueByAll();

	Overdue selectOverdueByCode(Overdue overdue);
	Overdue selectOverdueByMemberNo(Overdue overdue);
	
	int insertOverdue(Overdue overdue);
}

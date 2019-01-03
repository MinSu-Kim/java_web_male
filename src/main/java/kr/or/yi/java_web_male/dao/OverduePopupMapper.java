package kr.or.yi.java_web_male.dao;

import java.util.Date;
import java.util.List;

import kr.or.yi.java_web_male.dto.OverduePopup;

public interface OverduePopupMapper {
	List<OverduePopup> selectAll();
	void updatedat();
	int selectDate();
	List<OverduePopup> selectAllRentInfo();
	
}

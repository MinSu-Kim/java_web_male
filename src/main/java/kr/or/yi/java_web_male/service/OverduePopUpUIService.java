package kr.or.yi.java_web_male.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.RequestingUserName;

import kr.or.yi.java_web_male.dao.OverduePopupMapper;
import kr.or.yi.java_web_male.dao.OverduePopupMapperImpl;
import kr.or.yi.java_web_male.dto.OverduePopup;

public class OverduePopUpUIService {
	private OverduePopupMapper overduePopupMapper;
	
	public OverduePopUpUIService() {
		
		overduePopupMapper = OverduePopupMapperImpl.getInstance();
	}
	
	public List<OverduePopup> selectAll() {
		return overduePopupMapper.selectAll();
	}
	public void updatedat(){
		overduePopupMapper.updatedat();
	}

	public List<OverduePopup> selectAllRentInfo() {
		return overduePopupMapper.selectAllRentInfo();
	}
		
	
}

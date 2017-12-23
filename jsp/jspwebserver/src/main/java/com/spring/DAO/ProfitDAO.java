package com.spring.DAO;

import java.util.List;

import com.spring.Model.ProfitInfoVO;
import com.spring.Model.ProfitItemVO;
import com.spring.Model.ProfitVO;

public interface ProfitDAO {

	public List<ProfitVO> profitList();
	
	public void insertProfit(ProfitVO vo);
	
	public int getNextProfitId();
	
	public void insertProfitItem(ProfitItemVO vo);
	
	public List<ProfitItemVO> profitItemList();
	
	public List<ProfitItemVO> profitAgeInfo(int sAge, int eAge);
	
	public List<ProfitItemVO> profitGenderInfo(String gender);
}

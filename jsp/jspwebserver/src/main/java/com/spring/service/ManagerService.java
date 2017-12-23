package com.spring.service;

import java.util.List;

import com.spring.Model.ManagerVO;
import com.spring.Model.ProfitInfoVO;
import com.spring.Model.ProfitItemVO;
import com.spring.Model.ProfitVO;
import com.spring.Model.SeatVO;

public interface ManagerService {
	
	public List<ManagerVO> managerList();
	
	public void insertManager(ManagerVO vo);
	
	public ManagerVO loginManager(ManagerVO vo);
	
	public List<ManagerVO> duplication(String id);
	
	public boolean checkNum(int managerNum);
	
	public ManagerVO viewManager();
	
	public void updateManager(ManagerVO vo);
	
	public void insertSeat(SeatVO vo);
	
	public void deleteSeat(SeatVO vo);
	
	public List<SeatVO> seatList();

	public List<ProfitVO> profitList();
	
	public void insertProfit(ProfitVO vo);
	
	public int getNextProfitId();
	
	public void insertProfitItem(ProfitItemVO vo);
	
	public List<ProfitItemVO> profitItemList();
	
	public List<ProfitItemVO> profitAgeInfo(int sAge, int eAge);
	
	public List<ProfitItemVO> profitGenderInfo(String gender);
}

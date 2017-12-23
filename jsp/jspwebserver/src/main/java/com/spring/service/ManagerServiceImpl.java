package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.DAO.ManagerDAO;
import com.spring.DAO.ManagerDAOImpl;
import com.spring.DAO.ProfitDAOImpl;
import com.spring.DAO.SeatDAOImpl;
import com.spring.Model.ManagerVO;
import com.spring.Model.ProfitInfoVO;
import com.spring.Model.ProfitItemVO;
import com.spring.Model.ProfitVO;
import com.spring.Model.SeatVO;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Inject
	ManagerDAOImpl managerDao;
	
	@Inject
	SeatDAOImpl seatDao;
	
	@Inject
	ProfitDAOImpl profitDao;
	
	@Override
	public List<ManagerVO> managerList() {
		// TODO Auto-generated method stub
		return managerDao.managerList();
	}

	@Override
	public void insertManager(ManagerVO vo) {
		// TODO Auto-generated method stub
		managerDao.insertManager(vo);
	}

	@Override
	public ManagerVO viewManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateManager(ManagerVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ManagerVO loginManager(ManagerVO vo) {
		// TODO Auto-generated method stub
		return managerDao.loginManager(vo);
	}

	@Override
	public List<ManagerVO> duplication(String id) {
		// TODO Auto-generated method stub
		return managerDao.duplication(id);
	}

	@Override
	public void insertSeat(SeatVO vo) {
		// TODO Auto-generated method stub
		seatDao.insertSeat(vo);
	}

	@Override
	public void deleteSeat(SeatVO vo) {
		// TODO Auto-generated method stub
		seatDao.deleteSeat(vo);
	}

	@Override
	public List<SeatVO> seatList() {
		// TODO Auto-generated method stub
		return seatDao.seatList();
	}

	@Override
	public List<ProfitVO> profitList() {
		// TODO Auto-generated method stub
		return profitDao.profitList();
	}

	@Override
	public void insertProfit(ProfitVO vo) {
		// TODO Auto-generated method stub
		profitDao.insertProfit(vo);
	}

	@Override
	public boolean checkNum(int managerNum) {
		// TODO Auto-generated method stub
		return managerDao.checkNum(managerNum);
	}

	@Override
	public int getNextProfitId() {
		// TODO Auto-generated method stub
		return profitDao.getNextProfitId();
	}

	@Override
	public void insertProfitItem(ProfitItemVO vo) {
		// TODO Auto-generated method stub
		profitDao.insertProfitItem(vo);
	}

	@Override
	public List<ProfitItemVO> profitItemList() {
		// TODO Auto-generated method stub
		return profitDao.profitItemList();
	}

	@Override
	public List<ProfitItemVO> profitAgeInfo(int sAge, int eAge) {
		// TODO Auto-generated method stub
		return profitDao.profitAgeInfo(sAge, eAge);
	}

	@Override
	public List<ProfitItemVO> profitGenderInfo(String gender) {
		// TODO Auto-generated method stub
		return profitDao.profitGenderInfo(gender);
	}

}

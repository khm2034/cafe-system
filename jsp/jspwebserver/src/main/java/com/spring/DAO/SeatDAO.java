package com.spring.DAO;

import java.util.List;

import com.spring.Model.SeatVO;

public interface SeatDAO {

	public void insertSeat(SeatVO vo);
	
	public void deleteSeat(SeatVO vo);
	
	public List<SeatVO> seatList();
	
	public SeatVO searchSeat(int userNum);
}

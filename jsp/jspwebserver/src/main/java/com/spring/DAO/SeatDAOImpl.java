package com.spring.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.Model.SeatVO;

@Repository
public class SeatDAOImpl implements SeatDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insertSeat(SeatVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("seat.insertSeat", vo);
	}

	@Override
	public void deleteSeat(SeatVO vo) {
		// TODO Auto-generated method stub
		sqlSession.delete("seat.deleteSeat", vo);
	}

	@Override
	public List<SeatVO> seatList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("seat.seatList");
	}

	@Override
	public SeatVO searchSeat(int userNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("seat.searchSeat", userNum);
	}

}

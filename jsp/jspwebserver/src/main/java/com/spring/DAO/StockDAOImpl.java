package com.spring.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.Model.StockVO;

@Repository
public class StockDAOImpl implements StockDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<StockVO> stockList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("stock.stockList");
	}

	@Override
	public void insertStock(StockVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("stock.insertStock", vo);
	}

	@Override
	public void updateStock(StockVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update("stock.updateStock", vo);
	}

	@Override
	public StockVO searchStock(StockVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("stock.searchStock", vo);
	}

	@Override
	public void deleteStock(StockVO vo) {
		// TODO Auto-generated method stub
		sqlSession.delete("stock.deleteStock", vo);
	}

}

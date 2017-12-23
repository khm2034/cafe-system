package com.spring.DAO;

import java.util.List;

import com.spring.Model.StockVO;

public interface StockDAO {
	
	public List<StockVO> stockList(); 
	
	public void insertStock(StockVO vo);
	
	public void updateStock(StockVO vo);
	
	public StockVO searchStock(StockVO vo);
	
	public void deleteStock(StockVO vo);
}

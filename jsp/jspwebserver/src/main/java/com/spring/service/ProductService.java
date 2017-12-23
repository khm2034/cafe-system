package com.spring.service;

import java.util.List;

import com.spring.Model.ProductVO;
import com.spring.Model.StockVO;

public interface ProductService {

	public List<ProductVO> productList(int kinds);
	
	public void insertProduct(ProductVO vo);
	
	public void updateProduct(ProductVO vo);
	
	public ProductVO searchProduct(ProductVO vo);
	
	public void deleteProduct(ProductVO vo);
	
	public String searchProductId(String menu, int kind);
	
	public List<StockVO> stockList(); 
	
	public void insertStock(StockVO vo);
	
	public void updateStock(StockVO vo);
	
	public StockVO searchStock(StockVO vo);
	
	public void deleteStock(StockVO vo);
}

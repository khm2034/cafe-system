package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.DAO.ProductDAOImpl;
import com.spring.DAO.StockDAOImpl;
import com.spring.Model.ProductVO;
import com.spring.Model.StockVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductDAOImpl productDao;
	
	@Inject
	StockDAOImpl stockDao;
	
	@Override
	public List<ProductVO> productList(int kinds) {
		// TODO Auto-generated method stub
		return productDao.productList(kinds);
	}

	@Override
	public void insertProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		productDao.insertProduct(vo);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		productDao.updateProduct(vo);
	}

	@Override
	public ProductVO searchProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		return productDao.searchProduct(vo);
	}
	

	@Override
	public void deleteProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(vo);
	}

	@Override
	public List<StockVO> stockList() {
		// TODO Auto-generated method stub
		return stockDao.stockList();
	}

	@Override
	public void insertStock(StockVO vo) {
		// TODO Auto-generated method stub
		stockDao.insertStock(vo);
	}

	@Override
	public void updateStock(StockVO vo) {
		// TODO Auto-generated method stub
		stockDao.updateStock(vo);
	}

	@Override
	public StockVO searchStock(StockVO vo) {
		// TODO Auto-generated method stub
		return stockDao.searchStock(vo);
	}

	@Override
	public void deleteStock(StockVO vo) {
		// TODO Auto-generated method stub
		stockDao.deleteStock(vo);
	}

	@Override
	public String searchProductId(String menu, int kind) {
		// TODO Auto-generated method stub
		return productDao.searchProductId(menu, kind);
	}

}

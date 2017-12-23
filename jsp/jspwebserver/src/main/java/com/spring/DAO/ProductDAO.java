package com.spring.DAO;

import java.util.List;

import com.spring.Model.ProductVO;

public interface ProductDAO {
	
	public List<ProductVO> productList(int kinds);
	
	public void insertProduct(ProductVO vo);
	
	public void updateProduct(ProductVO vo);
	
	public ProductVO searchProduct(ProductVO vo);

	public void deleteProduct(ProductVO vo);
	
	public String searchProductId(String menu, int kind);
}

package com.spring.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.Model.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ProductVO> productList(int kinds) {
		// TODO Auto-generated method stub
		switch(kinds) {
		case 1:
			return sqlSession.selectList("coffee.productList");
		case 2:
			return sqlSession.selectList("beverage.productList");
		case 3:
			return sqlSession.selectList("dessert.productList");
		}
		return null;
		
	}

	@Override
	public void insertProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		switch(vo.getKinds()) {
		case 1:
			sqlSession.insert("coffee.insertProduct", vo);
			break;
		case 2:
			sqlSession.insert("beverage.insertProduct", vo);
			break;
		case 3:
			sqlSession.insert("dessert.insertProduct", vo);
			break;
		}
	}

	@Override
	public void updateProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		if(vo.getImageURL() != null) {
			switch(vo.getKinds()) {
			case 1:
				sqlSession.update("coffee.allUpdateProduct", vo);
				break;
			case 2:
				sqlSession.update("beverage.allUpdateProduct", vo);
				break;
			case 3:
				sqlSession.update("dessert.allUpdateProduct", vo);
				break;
			}
			
		}
		else {
			switch(vo.getKinds()) {
			case 1:
				sqlSession.update("coffee.updateProduct", vo);
				break;
			case 2:
				sqlSession.update("beverage.updateProduct", vo);
				break;
			case 3:
				sqlSession.update("dessert.updateProduct", vo);
				break;
			}
			
		}
	}

	@Override
	public ProductVO searchProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("product.searchProduct", vo);
	}

	@Override
	public void deleteProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		switch(vo.getKinds()) {
		case 1:
			sqlSession.delete("coffee.deleteProduct", vo);
			break;
		case 2:
			sqlSession.delete("beverage.deleteProduct", vo);
			break;
		case 3:
			sqlSession.delete("dessert.deleteProduct", vo);
			break;
		}
		
	}

	@Override
	public String searchProductId(String menu, int kind) {
		// TODO Auto-generated method stub
		String id = null;
		
		switch(kind) {
		case 1:
			id = sqlSession.selectOne("coffee.searchId", menu);
			break;
		case 2:
			id = sqlSession.selectOne("beverage.searchId", menu);
			break;
		case 3:
			id = sqlSession.selectOne("dessert.searchId", menu);
			break;
		}
		return id;
	}

}

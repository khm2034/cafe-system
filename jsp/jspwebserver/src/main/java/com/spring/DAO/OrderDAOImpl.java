package com.spring.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.Model.OrderVO;
import com.spring.Model.OrderItemVO;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<OrderVO> getOrderList(int success) {
		// TODO Auto-generated method stub
		if(success == 1)
			return sqlSession.selectList("order.orderList", 1);
		else if(success == 0)
			return sqlSession.selectList("order.orderList", 0);
		
		return null;
	}

	@Override
	public int insertOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("order.insertOrder", vo);
	}

	@Override
	public void deleteOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		sqlSession.delete("order.deleteOrder", vo);
	}

	@Override
	public int getNextOrderId() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("order.getNextOrderId", null);
	}

	@Override
	public void updateOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update("order.updateOrder", vo);
		
	}

	@Override
	public OrderVO searchOrder(int orderNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("order.searchOrder", orderNum);
	}

	@Override
	public void insertOrderItem(OrderItemVO vo) {
		// TODO Auto-generated method stub
		switch(vo.getKind()) {
		case 1:
			sqlSession.insert("order.insertCoffeeItem", vo);
			break;
		case 2:
			sqlSession.insert("order.insertBeverageItem", vo);
			break;
		case 3:
			sqlSession.insert("order.insertDessertItem", vo);
			break;
		default:
			break;
		}
	}

	@Override
	public List<OrderItemVO> getOrderItemList(int orderNum, int kind) {
		// TODO Auto-generated method stub
		switch(kind) {
		case 1:
			return sqlSession.selectList("order.coffeeItemList", orderNum);
		case 2:
			return sqlSession.selectList("order.beverageItemList", orderNum);
		case 3:
			return sqlSession.selectList("order.dessertItemList", orderNum);
		default:
			break;
		}
		return null;
	}


}

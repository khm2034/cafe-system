package com.spring.DAO;

import java.util.List;

import com.spring.Model.OrderVO;
import com.spring.Model.OrderItemVO;

public interface OrderDAO {
	
	List<OrderVO> getOrderList(int success);
	
	int insertOrder(OrderVO vo);
	
	void insertOrderItem(OrderItemVO vo);
	
	void deleteOrder(OrderVO vo);
	
	void updateOrder(OrderVO vo);
	
	int getNextOrderId();
	
	OrderVO searchOrder(int orderNum);
	
	List<OrderItemVO> getOrderItemList(int orderNum, int kind);
}

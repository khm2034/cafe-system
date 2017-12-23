package com.spring.service;

import java.util.List;
import com.spring.Model.ManagerVO;
import com.spring.Model.OrderVO;
import com.spring.Model.SeatVO;
import com.spring.Model.UserVO;
import com.spring.Model.OrderItemVO;

public interface UserService {

	public List<OrderVO> getOrderList(int success);
	
	public int insertOrder(OrderVO vo);
	
	public void insertOrderItem(OrderItemVO vo);
	
	public List<OrderItemVO> getOrderItemList(int orderNum, int kind);
	
	public void deleteOrder(OrderVO vo);
	
	public void updateOrder(OrderVO vo);
	
	public OrderVO searchOrder(int orderNum);
	
	public int getNextOrderId();
	
	public List<UserVO> userList();
	
	public String searchUserId(int userNum);
	
	public UserVO searchUser(int userNum);
	
	public SeatVO searchSeat(int userNum);
}

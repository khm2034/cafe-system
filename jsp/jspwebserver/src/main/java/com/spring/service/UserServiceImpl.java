package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.DAO.ManagerDAOImpl;
import com.spring.DAO.OrderDAOImpl;
import com.spring.DAO.SeatDAOImpl;
import com.spring.DAO.UserDAOImpl;
import com.spring.Model.ManagerVO;
import com.spring.Model.OrderVO;
import com.spring.Model.SeatVO;
import com.spring.Model.UserVO;
import com.spring.Model.OrderItemVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	OrderDAOImpl orderDao;
	
	@Inject
	UserDAOImpl userDao;
	
	@Inject
	SeatDAOImpl seatDao;
	@Override
	public List<OrderVO> getOrderList(int success) {
		// TODO Auto-generated method stub
		return orderDao.getOrderList(success);
	}

	@Override
	public int insertOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDao.insertOrder(vo);
	}

	@Override
	public void deleteOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		orderDao.deleteOrder(vo);
	}

	@Override
	public int getNextOrderId() {
		// TODO Auto-generated method stub
		return orderDao.getNextOrderId();
	}

	@Override
	public void updateOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		orderDao.updateOrder(vo);
	}

	@Override
	public List<UserVO> userList() {
		// TODO Auto-generated method stub
		return userDao.userList();
	}

	@Override
	public UserVO searchUser(int userNum) {
		// TODO Auto-generated method stub
		return userDao.searchUser(userNum);
	}

	@Override
	public OrderVO searchOrder(int orderNum) {
		// TODO Auto-generated method stub
		return orderDao.searchOrder(orderNum);
	}
	

	@Override
	public SeatVO searchSeat(int userNum) {
		// TODO Auto-generated method stub
		return seatDao.searchSeat(userNum);
	}

	@Override
	public void insertOrderItem(OrderItemVO vo) {
		// TODO Auto-generated method stub
		orderDao.insertOrderItem(vo);
	}

	@Override
	public List<OrderItemVO> getOrderItemList(int orderNum, int kind) {
		// TODO Auto-generated method stub
		return orderDao.getOrderItemList(orderNum, kind);
	}

	@Override
	public String searchUserId(int userNum) {
		// TODO Auto-generated method stub
		return userDao.searchUserId(userNum);
	}

}

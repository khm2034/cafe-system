package com.spring.DAO;

import java.util.List;

import com.spring.Model.UserVO;

public interface UserDAO {
	
	public List<UserVO> userList();
	
	public UserVO searchUser(int userNum);
	
	public String searchUserId(int userNum);
}

package com.spring.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.Model.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<UserVO> userList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("user.userList");
	}

	@Override
	public UserVO searchUser(int userNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("user.searchUser", userNum);
	}

	@Override
	public String searchUserId(int userNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("user.searchUserId", userNum);
	}

}

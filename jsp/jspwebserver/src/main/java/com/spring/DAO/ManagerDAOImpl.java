package com.spring.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.Model.ManagerVO;

@Repository
public class ManagerDAOImpl implements ManagerDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ManagerVO> managerList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("manager.managerList");
	}

	@Override
	public void insertManager(ManagerVO vo) {
		// TODO Auto-generated method stub
		System.out.println("insert " + vo.getManagerId());
		sqlSession.insert("manager.insertManager", vo);

	}

	@Override
	public ManagerVO viewManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateManager(ManagerVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ManagerVO loginManager(ManagerVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("manager.login", vo);
		
	}

	@Override
	public List<ManagerVO> duplication(String id) {
		return sqlSession.selectList("manager.duplication", id);
	}

	@Override
	public boolean checkNum(int managerNum) {
		// TODO Auto-generated method stub
		List<ManagerVO> list = sqlSession.selectList("manager.checkId", managerNum);
		if(list.size() == 0)
			return true;
		else
			return false;
	}

}

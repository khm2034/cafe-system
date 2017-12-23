package com.spring.DAO;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.Model.ProfitInfoVO;
import com.spring.Model.ProfitItemVO;
import com.spring.Model.ProfitVO;

@Repository
public class ProfitDAOImpl implements ProfitDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ProfitVO> profitList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("profit.profitList");
	}

	@Override
	public void insertProfit(ProfitVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("profit.insertProfit", vo);
	}

	@Override
	public int getNextProfitId() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("profit.getNextProfitId");
	}

	@Override
	public void insertProfitItem(ProfitItemVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("profit.insertProfitItem", vo);
	}

	@Override
	public List<ProfitItemVO> profitItemList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("profit.profitItemList");
	}

	@Override
	public List<ProfitItemVO> profitAgeInfo(int sAge, int eAge) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> age = new HashMap<String, Integer>();
		age.put("sAge", sAge);
		age.put("eAge", eAge);
		return sqlSession.selectList("profit.profitAgeInfo", age);
	}

	@Override
	public List<ProfitItemVO> profitGenderInfo(String gender) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("profit.profitGenderInfo", gender);
	}

}

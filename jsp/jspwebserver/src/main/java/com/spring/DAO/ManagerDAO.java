package com.spring.DAO;

import java.util.List;
import com.spring.Model.ManagerVO;

public interface ManagerDAO {

	public List<ManagerVO> managerList();
	
	public void insertManager(ManagerVO vo);
	
	public ManagerVO loginManager(ManagerVO vo);
	
	public ManagerVO viewManager();
	
	public void updateManager(ManagerVO vo);
	
	public List<ManagerVO> duplication(String id);
	
	public boolean checkNum(int managerNum);

}

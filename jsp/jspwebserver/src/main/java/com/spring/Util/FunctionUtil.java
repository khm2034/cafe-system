package com.spring.Util;

import java.util.ArrayList;
import java.util.List;

import com.spring.Model.OrderItemVO;
import com.spring.Model.ProductVO;
import com.spring.Model.ProfitItemVO;

public class FunctionUtil {

	public List<ProfitItemVO> getProfitItem(List<OrderItemVO> item, int profitId){
		
		List<ProfitItemVO> list = new ArrayList<ProfitItemVO>(); 
		for(int i = 0; i<item.size(); i++) {
			ProfitItemVO profitItemVo = new ProfitItemVO();
			boolean chk = false;
			for(int j=0; j<i; j++) {
				if(list.get(j).getMenuName().equals(item.get(i).getName())) {
					list.get(j).setCount(list.get(j).getCount() + item.get(i).getCount());
					chk = true;
					break;
				}
			}
			
			if(chk)
				continue;
			
			profitItemVo.setProfitId(profitId);
			profitItemVo.setMenuName(item.get(i).getName());
			profitItemVo.setCount(item.get(i).getCount());
			
			list.add(profitItemVo);
		}
		return list;
	}
	
	public List<ProductVO> settingNum(List<ProductVO> list){
		
		for(int i=0; i<list.size(); i++) {
			list.get(i).setNum(i+1);
			//cList.get(i).setKinds(1);
		}
		return list;
	}
	
	public List<ProductVO>[] divideList(List<ProductVO> allList){
		List<ProductVO> list[] = new ArrayList[2];
		list[0] = new ArrayList<ProductVO>();
		list[1] = new ArrayList<ProductVO>();
		
		int ice = 1;
		int hot = 1;
		
		for(int i=0; i<allList.size(); i++) {
			
			int typeInt = 0;
			if(allList.get(i).getType().equals("H"))
				typeInt = 1;
			else if(allList.get(i).getType().equals("C"))
				typeInt = 2;
			else if(allList.get(i).getType().equals("HC"))
				typeInt = 3;
			
			switch(typeInt) {
			case 1:
				allList.get(i).setNum(hot);
				list[0].add(allList.get(i));
				hot++;
				break;
			case 2:
				allList.get(i).setNum(ice);
				list[1].add(allList.get(i));
				ice++;
				break;
			case 3:
				allList.get(i).setNum(hot);
				list[0].add(allList.get(i));
				hot++;
				ProductVO iceTmp = new ProductVO(allList.get(i));
				iceTmp.setNum(ice);
				iceTmp.setsPrice(allList.get(i).getsPrice()+500);
				iceTmp.setrPrice(allList.get(i).getrPrice()+500);
				iceTmp.setlPrice(allList.get(i).getlPrice()+500);
				list[1].add(iceTmp);
				ice++;
				break;
			default:
				break;
			}
		}
		
		return list;
	}
	
	
}


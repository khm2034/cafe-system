package com.spring.Util;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.spring.Model.ProfitInfoVO;
import com.spring.Model.ProfitItemVO;

public class ProfitUtil {

	@SuppressWarnings("unchecked")
	public HashMap<String, Integer> sortMap(HashMap map){
		List list = new LinkedList(map.entrySet());
		
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable)((Map.Entry)(o1)).getValue()).compareTo(((Map.Entry)(o2)).getValue());
			}
		});
		
		Collections.reverse(list);
		
		HashMap sorted = new LinkedHashMap<String, Integer>();
		
		for(Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next();
			sorted.put(entry.getKey(), entry.getValue());
		}
		
		return sorted;
	}
	
	public HashMap<String, Integer> manufacturMap(HashMap<String, Integer> map){
		int count5 = 0;
		int sumValue = 0;
		HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
		
		for(HashMap.Entry<String, Integer> entry:map.entrySet()) {
			if(count5 == 5) {
				//resultMap.put("기타", totalCount - sumValue);
				break;
			}
			resultMap.put(entry.getKey(), entry.getValue());
			count5++;
			sumValue += entry.getValue();
		}
		return resultMap;
	}
	
	public HashMap<String, Integer> getInfo(List<ProfitItemVO> list){
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0;i <list.size(); i++) {
			
			String menuName = list.get(i).getMenuName();
			int count = list.get(i).getCount();
			
			if(map.containsKey(menuName))
				map.put(menuName, map.get(menuName) +count);
			else
				map.put(menuName, count);
		}
		
		return map;
	}
}

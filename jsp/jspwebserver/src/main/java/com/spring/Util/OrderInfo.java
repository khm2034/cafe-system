package com.spring.Util;

import java.sql.Date;
import java.util.List;

import com.spring.Model.OrderItemVO;

public class OrderInfo {

	private Date date;
	private int orderNum;
	private String id;
	private String fullMenu = "";
	private String count = "";
	private String size = "";
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullMenu() {
		return fullMenu;
	}
	public void setFullMenu(String fullMenu) {
		this.fullMenu = fullMenu;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setInfo(List<OrderItemVO> list) {
		for(int j=0; j<list.size(); j++) {
			if(list.get(j).getType() != null) {
				if(list.get(j).getType().equals("H"))
					fullMenu += list.get(j).getName() + "(HOT),";
				else if(list.get(j).getType().equals("I"))
					fullMenu += list.get(j).getName() + "(ICE),";
				else
					fullMenu += list.get(j).getName();
			} else
				fullMenu += list.get(j).getName();
			
			count += list.get(j).getCount() + ",";
			if(list.get(j).getSize() != null)
				size += list.get(j).getSize() + ",";
			else
				size += "  ,";
		}
	}
}

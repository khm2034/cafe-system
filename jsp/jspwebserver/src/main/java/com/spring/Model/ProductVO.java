package com.spring.Model;

public class ProductVO {

	private int num;
	private String id;
	private String absoluteURL;
	private String imageURL;
	private String originalName;
	private String saveFileName;
	private String name;
	private int sPrice;
	private int rPrice;
	private int lPrice;
	private int kinds;
	private String type;
	
	public ProductVO(){}
	
	public ProductVO(ProductVO vo){
		id = vo.getId();
		absoluteURL = vo.getAbsoluteURL();
		imageURL = vo.getImageURL();
		originalName = vo.getOriginalName();
		saveFileName = vo.getSaveFileName();
		name = vo.getName();
		sPrice = vo.getsPrice();
		rPrice = vo.getrPrice();
		lPrice = vo.getlPrice();
		kinds = vo.getKinds();
		type = vo.getType();
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getKinds() {
		return kinds;
	}
	public void setKinds(int kinds) {
		this.kinds = kinds;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAbsoluteURL() {
		return absoluteURL;
	}
	public void setAbsoluteURL(String absoluteURL) {
		this.absoluteURL = absoluteURL;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getsPrice() {
		return sPrice;
	}
	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}
	public int getrPrice() {
		return rPrice;
	}
	public void setrPrice(int rPrice) {
		this.rPrice = rPrice;
	}
	public int getlPrice() {
		return lPrice;
	}
	public void setlPrice(int lPrice) {
		this.lPrice = lPrice;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ProductVO [num=" + num + ", id= " + id + ", absoluteURL= " + absoluteURL 
				+ ", originalName= " + originalName + ", saveFileName= " + saveFileName +  ", name= "
		+ name + ", sPrice= " + sPrice + ", rPrice= " + rPrice + "]";
	}
	
}

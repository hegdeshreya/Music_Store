package com.entity;

public class Cart2 {
	private int cid; // Cart ID
	private int iid; // CD ID
	private int uid; // User ID
	private String instruname;
	private Double price;
	private Double totalprice;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getInstruname() {
		return instruname;
	}

	public void setInstruname(String instruname) {
		this.instruname = instruname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

}

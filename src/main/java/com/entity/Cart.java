package com.entity;

public class Cart {
	private int cid; // Cart ID
	private int sid; // CD ID
	private int uid; // User ID
	private String song_name;
	private Double price;
	private Double total;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getSongName() {
		return song_name;
	}

	public void setSongName(String songName) {
		this.song_name = songName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
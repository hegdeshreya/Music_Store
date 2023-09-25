package com.entity;

public class instrument { // Class names should start with an uppercase letter and follow camelCase

	private int id;
	private String instruname;
	private String price;
	private String picName;
	private String quantity;
	private String email;

	public instrument() {
		super();
		// TODO Auto-generated constructor stub
	}

	public instrument(String instruname, String price, String picName, String quantity, String email) {
		super();

		this.instruname = instruname;
		this.price = price;
		this.picName = picName;
		this.quantity = quantity;
		this.email = email;
	}

	@Override
	public String toString() {
		return "instrument [id=" + id + ", instruname=" + instruname + ", price=" + price + ", picName=" + picName
				+ ", quantity=" + quantity + ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstruname() {
		return instruname;
	}

	public void setInstruname(String instruname) {
		this.instruname = instruname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
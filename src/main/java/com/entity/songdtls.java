package com.entity;

public class songdtls {
	private int id;
	private String songname;
	private String artist;
	private String price;
	private String genre;
	private String songName;
	private String picName;
	private String email;

	public songdtls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public songdtls(String songname, String artist, String price, String genre, String songName, String picName,
			String email) {
		super();
		this.songname = songname;
		this.artist = artist;
		this.price = price;
		this.genre = genre;
		this.songName = songName;
		this.picName = picName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "songdtls [id=" + id + ", songname=" + songname + ", artist=" + artist + ", price=" + price + ", genre="
				+ genre + ", songName=" + songName + ", picName=" + picName + ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getsongname() {
		return songname;
	}

	public void setsongname(String song) {
		this.songname = song;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSong() {
		return songName;
	}

	public void setSong(String song) {
		this.songName = song;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

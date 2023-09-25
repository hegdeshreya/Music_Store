package com.DAO;

import java.util.List;

import com.entity.Cart;

public interface CartDAO {

	public boolean addcart(Cart c);

	public List<Cart> getSongByUser(int UserId);

	public boolean deleteSong(int sid, int uid);

}

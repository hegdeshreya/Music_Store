package com.DAO;

import java.util.List;

import com.entity.Song_Order;

public interface SongOrderDAO {

	public boolean saveOrder(List<Song_Order> slist);

	public List<Song_Order> getSong(String email);

	public List<Song_Order> getAllorder();
}

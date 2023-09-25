package com.DAO;

import java.util.List;

import com.entity.Cart2;

public interface Cart2DAO {

	public boolean addcart2(Cart2 c);

	public List<Cart2> getinstrumentByUser(int UserId);

	public boolean deleteInstrument(int iid, int uid);

}

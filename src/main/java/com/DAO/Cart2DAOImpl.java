package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart2;

public class Cart2DAOImpl implements Cart2DAO {
	private Connection conn;

	public Cart2DAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean addcart2(Cart2 c) {
		boolean f = false;
		try {

			String sql = "INSERT INTO cart2 (iid, uid, instruname, price, total_price) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, c.getIid());
			ps.setInt(2, c.getUid());
			ps.setString(3, c.getInstruname());
			ps.setDouble(4, c.getPrice());
			ps.setDouble(5, c.getTotalprice());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Cart2> getinstrumentByUser(int userId) {
		List<Cart2> list = new ArrayList<Cart2>();
		Cart2 c = null;
		double total = 0;

		try {
			String sql = "select * from cart2 where uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new Cart2();
				c.setCid(rs.getInt(1));
				c.setIid(rs.getInt(2));
				c.setUid(rs.getInt(3));
				c.setInstruname(rs.getString(4)); // Corrected the method name to setSongName

				c.setPrice(rs.getDouble(5));

				total = total + rs.getDouble(6);
				c.setPrice(total);
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

	public boolean deleteInstrument(int iid, int uid) {
		boolean f = false;
		String sql = "delete from cart2 where iid=? and uid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iid);
			ps.setInt(2, uid);
			int j = ps.executeUpdate();
			if (j == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
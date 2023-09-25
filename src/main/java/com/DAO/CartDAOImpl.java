package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart;

public class CartDAOImpl implements CartDAO {
	private Connection conn;

	public CartDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean addcart(Cart c) {
		boolean f = false;
		try {

			String sql = "INSERT INTO cart (sid, uid, song_name, price, total) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, c.getSid());
			ps.setInt(2, c.getUid());
			ps.setString(3, c.getSongName());
			ps.setDouble(4, c.getPrice());
			ps.setDouble(5, c.getTotal());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Cart> getSongByUser(int userId) {
		List<Cart> list = new ArrayList<Cart>();
		Cart c = null;
		double total = 0;

		try {
			String sql = "select * from cart where uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new Cart();
				c.setCid(rs.getInt(1));
				c.setSid(rs.getInt(2));
				c.setUid(rs.getInt(3));
				c.setSongName(rs.getString(4)); // Corrected the method name to setSongName

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

	public boolean deleteSong(int sid, int uid) {
		boolean f = false;
		String sql = "delete from cart where sid=? and uid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			ps.setInt(2, uid);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
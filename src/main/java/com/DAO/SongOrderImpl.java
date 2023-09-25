package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Song_Order;

public class SongOrderImpl implements SongOrderDAO {

	private Connection conn;

	public SongOrderImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean saveOrder(List<Song_Order> slist) {
		boolean f = false;
		try {

			String sql = "insert into song_order(order_id,user_name,email,address,phno,song_name,price,payment) values(?,?,?,?,?,?,?,?)";

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);

			for (Song_Order s : slist) {
				ps.setString(1, s.getOrderId());
				ps.setString(2, s.getUserName());
				ps.setString(3, s.getEmail());
				ps.setString(4, s.getFulladd());
				ps.setString(5, s.getPhno());
				ps.setString(6, s.getSongName());

				ps.setString(7, s.getPrice());
				ps.setString(8, s.getPaymentType());
				ps.addBatch();
			}
			int[] count = ps.executeBatch();
			conn.commit();
			f = true;
			conn.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Song_Order> getSong(String email) {
		List<Song_Order> list = new ArrayList<Song_Order>();
		Song_Order o = null;
		try {
			String sql = "select * from song_order where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				o = new Song_Order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUserName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhno(rs.getString(6));
				o.setSongName(rs.getString(7));

				o.setPrice(rs.getString(8));
				o.setPaymentType(rs.getString(9));
				list.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Song_Order> getAllorder() {
		List<Song_Order> list = new ArrayList<Song_Order>();
		Song_Order o = null;
		try {
			String sql = "select * from song_order";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				o = new Song_Order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUserName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhno(rs.getString(6));
				o.setSongName(rs.getString(7));

				o.setPrice(rs.getString(8));
				o.setPaymentType(rs.getString(9));
				list.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
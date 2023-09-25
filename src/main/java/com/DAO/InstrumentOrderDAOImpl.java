package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Instrument_Order;

public class InstrumentOrderDAOImpl implements InstrumentOrderDAO {
	private Connection conn;

	public InstrumentOrderDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean saveOrder2(List<Instrument_Order> ilist) {
		boolean f = false;
		try {

			String sql = "insert into instrument_order(order_id,user_name,email,address,phno,instruname_name,price,payment) values(?,?,?,?,?,?,?,?)";

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);

			for (Instrument_Order s : ilist) {
				ps.setString(1, s.getOrderId());
				ps.setString(2, s.getUserName());
				ps.setString(3, s.getEmail());
				ps.setString(4, s.getFulladd());
				ps.setString(5, s.getPhno());
				ps.setString(6, s.getInstruName());

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

	public List<Instrument_Order> getInstrument(String email) {
		List<Instrument_Order> list = new ArrayList<Instrument_Order>();
		Instrument_Order o = null;
		try {
			String sql = "select * from instrument_order where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				o = new Instrument_Order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUserName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhno(rs.getString(6));
				o.setInstruName(rs.getString(7));

				o.setPrice(rs.getString(8));
				o.setPaymentType(rs.getString(9));
				list.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Instrument_Order> getAllorder() {
		List<Instrument_Order> list = new ArrayList<Instrument_Order>();
		Instrument_Order o = null;
		try {
			String sql = "select * from instrument_order";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				o = new Instrument_Order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUserName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhno(rs.getString(6));
				o.setInstruName(rs.getString(7));

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

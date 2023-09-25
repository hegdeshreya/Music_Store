package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.instrument; // Updated class name

public class InstrumentDAOImpl implements InstrumentDAO {

	private Connection conn;

	public InstrumentDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addinstrument(instrument i) {
		boolean f = false;
		try {
			String sql = "INSERT INTO instrument (instruname, quantity, price, pic, email) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, i.getInstruname()); // Updated method calls
			ps.setString(2, i.getQuantity()); // Updated method calls
			ps.setString(3, i.getPrice()); // Updated method calls
			ps.setString(4, i.getPicName()); // Updated method calls
			ps.setString(5, i.getEmail()); // Updated method calls
			int rowsInserted = ps.executeUpdate();
			if (rowsInserted == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace(); // Handle exceptions appropriately
		}
		return f;
	}

	public List<instrument> getAllInstruments() {
		List<instrument> list = new ArrayList<instrument>();
		instrument i = null;

		try {
			String sql = "SELECT * FROM instrument";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i = new instrument();
				i.setId(rs.getInt(1));
				i.setInstruname(rs.getString(2));
				i.setPicName(rs.getString(3));
				i.setPrice(rs.getString(4));
				i.setQuantity(rs.getString(5));
				i.setEmail(rs.getString(6));
				list.add(i);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

	public boolean deleteInstrument(int id) {
		boolean f = false;
		try {
			String sql = "delete from instrument where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int j = ps.executeUpdate();
			if (j == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<instrument> getInstruments() {
		List<instrument> list = new ArrayList<instrument>();
		instrument i = null;
		try {
			String sql = "select * from instrument ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			int j = 1;
			while (rs.next() && j <= 4) {
				i = new instrument();
				i.setId(rs.getInt(1));
				i.setInstruname(rs.getString(2));
				i.setPicName(rs.getString(3));
				i.setPrice(rs.getString(4));
				i.setQuantity(rs.getString(5));
				i.setEmail(rs.getString(6));
				list.add(i);
				j++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public instrument getInstrumentById(int id) {
	    instrument i = null;

	    try {
	        String sql = "SELECT * FROM instrument WHERE id = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            i = new instrument();
	            i.setId(rs.getInt("id"));
	            i.setInstruname(rs.getString("instruname")); // Corrected field name
	            i.setPrice(rs.getString("price"));
	            i.setPicName(rs.getString("pic"));
	            i.setEmail(rs.getString("email"));
	        }

	        rs.close();
	        ps.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return i;
	}

}

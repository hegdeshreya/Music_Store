package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.songdtls;

public class SongDAOImpl implements SongDAO {

	private Connection conn;

	public SongDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addSongs(songdtls s) {
		boolean f = false;
		try {

			String sql = "INSERT INTO song_dtls (songname, artist, price, genre, song, pic, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, s.getsongname());
			ps.setString(2, s.getArtist());
			ps.setString(3, s.getPrice());
			ps.setString(4, s.getGenre());
			ps.setString(5, s.getSong());
			ps.setString(6, s.getPicName());
			ps.setString(7, s.getEmail());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<songdtls> getAllSongs() {
		List<songdtls> list = new ArrayList<songdtls>();
		songdtls s = null;

		try {
			String sql = "SELECT * FROM song_dtls";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new songdtls();
				s.setId(rs.getInt(1));
				s.setsongname(rs.getString(2));
				s.setPrice(rs.getString(3));
				s.setArtist(rs.getString(4));

				s.setGenre(rs.getString(5));
				s.setSong(rs.getString(6));
				s.setPicName(rs.getString(7));
				s.setEmail(rs.getString(8));

				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

	public boolean deleteSongs(int id) {
		boolean f = false;
		try {
			String sql = "delete from song_dtls where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<songdtls> getNewsongs() {
		List<songdtls> list = new ArrayList<songdtls>();
		songdtls s = null;
		try {
			String sql = "select * from song_dtls  where genre=? order by id DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Bollywood");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				s = new songdtls();
				s.setId(rs.getInt(1));
				s.setsongname(rs.getString(2));
				s.setPrice(rs.getString(3));
				s.setArtist(rs.getString(4));

				s.setGenre(rs.getString(5));
				s.setSong(rs.getString(6));
				s.setPicName(rs.getString(7));
				s.setEmail(rs.getString(8));
				list.add(s);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<songdtls> getRecentsongs() {
		List<songdtls> list = new ArrayList<songdtls>();
		songdtls s = null;
		try {
			String sql = "SELECT * FROM song_dtls ORDER BY id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new songdtls();
				s.setId(rs.getInt(1));
				s.setsongname(rs.getString(2));
				s.setPrice(rs.getString(3));
				s.setArtist(rs.getString(4));
				s.setGenre(rs.getString(5));
				s.setSong(rs.getString(6));
				s.setPicName(rs.getString(7));
				s.setEmail(rs.getString(8));
				list.add(s);

				if (list.size() >= 4) {
					break; // Stop after retrieving 4 records
				}
			}
			rs.close(); // Close the ResultSet
			ps.close(); // Close the PreparedStatement
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<songdtls> getSouthsongs() {
		List<songdtls> list = new ArrayList<songdtls>();
		songdtls s = null;
		try {
			String sql = "select * from song_dtls  where genre=? order by id DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "south");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				s = new songdtls();
				s.setId(rs.getInt(1));
				s.setsongname(rs.getString(2));
				s.setPrice(rs.getString(3));
				s.setArtist(rs.getString(4));

				s.setGenre(rs.getString(5));
				s.setSong(rs.getString(6));
				s.setPicName(rs.getString(7));
				s.setEmail(rs.getString(8));
				list.add(s);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<songdtls> getAllRecentsongs() {
		List<songdtls> list = new ArrayList<songdtls>();
		songdtls s = null;
		try {
			String sql = "SELECT * FROM song_dtls ORDER BY id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new songdtls();
				s.setId(rs.getInt(1));
				s.setsongname(rs.getString(2));
				s.setPrice(rs.getString(3));
				s.setArtist(rs.getString(4));
				s.setGenre(rs.getString(5));
				s.setSong(rs.getString(6));
				s.setPicName(rs.getString(7));
				s.setEmail(rs.getString(8));
				list.add(s);

			}
			rs.close(); // Close the ResultSet
			ps.close(); // Close the PreparedStatement
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<songdtls> getAllNewsongs() {
		List<songdtls> list = new ArrayList<songdtls>();
		songdtls s = null;
		try {
			String sql = "select * from song_dtls  where genre=? order by id DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Bollywood");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next()) {
				s = new songdtls();
				s.setId(rs.getInt(1));
				s.setsongname(rs.getString(2));
				s.setPrice(rs.getString(3));
				s.setArtist(rs.getString(4));

				s.setGenre(rs.getString(5));
				s.setSong(rs.getString(6));
				s.setPicName(rs.getString(7));
				s.setEmail(rs.getString(8));
				list.add(s);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<songdtls> getAllSouthsongs() {
		List<songdtls> list = new ArrayList<songdtls>();
		songdtls s = null;
		try {
			String sql = "select * from song_dtls  where genre=? order by id DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "south");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next()) {
				s = new songdtls();
				s.setId(rs.getInt(1));
				s.setsongname(rs.getString(2));
				s.setPrice(rs.getString(3));
				s.setArtist(rs.getString(4));

				s.setGenre(rs.getString(5));
				s.setSong(rs.getString(6));
				s.setPicName(rs.getString(7));
				s.setEmail(rs.getString(8));
				list.add(s);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public songdtls getSongById(int id) {
		songdtls s = null;

		try {
			String sql = "SELECT * FROM song_dtls WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s = new songdtls();
				s.setId(rs.getInt("id"));
				s.setsongname(rs.getString("songname"));
				s.setPrice(rs.getString("price"));
				s.setArtist(rs.getString("artist"));
				s.setGenre(rs.getString("genre"));
				s.setSong(rs.getString("song"));
				s.setPicName(rs.getString("pic"));
				s.setEmail(rs.getString("email"));
			}

			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}

}
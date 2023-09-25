package com.DAO;

import java.util.List;

import com.entity.songdtls;

public interface SongDAO {
	public boolean addSongs(songdtls s);

	public List<songdtls> getAllSongs();

	public boolean deleteSongs(int id);

	public List<songdtls> getNewsongs();

	public List<songdtls> getSouthsongs();

	public List<songdtls> getRecentsongs();

	public List<songdtls> getAllRecentsongs();

	public List<songdtls> getAllNewsongs();

	public List<songdtls> getAllSouthsongs();

	public songdtls getSongById(int id);

}

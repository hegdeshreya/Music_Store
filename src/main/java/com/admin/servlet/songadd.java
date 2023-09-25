package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.SongDAOImpl;
import com.DB.DBConnect;
import com.entity.songdtls;

@WebServlet("/add_song")
@MultipartConfig
public class songadd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String songname = req.getParameter("sname");
			String artist = req.getParameter("artist");
			String price = req.getParameter("price");
			String genre = req.getParameter("genre");

			Part songPart = req.getPart("songfile");
			String songFilename = songPart.getSubmittedFileName();

			Part picPart = req.getPart("img");
			String picFilename = picPart.getSubmittedFileName();

			songdtls s = new songdtls(songname, artist, price, genre, songFilename, picFilename, "admin");

			SongDAOImpl dao = new SongDAOImpl(DBConnect.getConn());

			// String songUploadPath = getServletContext().getRealPath("") + "music";
			// System.out.println(songUploadPath);

			boolean f = dao.addSongs(s);
			HttpSession session = req.getSession();

			if (f) {
				String songUploadPath = getServletContext().getRealPath("/") + File.separator + "music";
				String songFilePath = songUploadPath + File.separator + songFilename;
				songPart.write(songFilePath);

				// Save pic file
				String picUploadPath = getServletContext().getRealPath("/") + File.separator + "music-img";
				String picFilePath = picUploadPath + File.separator + picFilename;
				picPart.write(picFilePath);

				session.setAttribute("succMsg", "Song added");
				resp.sendRedirect("admin/add_song.jsp");
			} else {
				session.setAttribute("failedMsg", "wrong");
				resp.sendRedirect("admin/add_song.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
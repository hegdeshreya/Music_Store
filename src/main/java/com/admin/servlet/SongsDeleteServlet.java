package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.SongDAOImpl;
import com.DB.DBConnect;

@WebServlet("/delete")
public class SongsDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			SongDAOImpl dao = new SongDAOImpl(DBConnect.getConn());

			boolean f = dao.deleteSongs(id);
			HttpSession session = req.getSession();
			if (f) {

				session.setAttribute("succMsg", "Song deleted");
				resp.sendRedirect("admin/all_song.jsp");
			} else {

				session.setAttribute("failedMsg", "wrong");
				resp.sendRedirect("admin/add_song.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

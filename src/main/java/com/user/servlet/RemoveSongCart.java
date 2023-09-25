package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DB.DBConnect;

@WebServlet("/remove_song")
public class RemoveSongCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));
		int uid = Integer.parseInt(req.getParameter("uid"));
		CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
		boolean f = dao.deleteSong(sid, uid);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("succMsg", "Song Removed from cart");
			resp.sendRedirect("cart.jsp");
		} else {
			session.setAttribute("failedMsg", "Someting wrong");
			resp.sendRedirect("cart.jsp");
		}
	}

}

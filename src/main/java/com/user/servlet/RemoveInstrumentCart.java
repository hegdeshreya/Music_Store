package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.Cart2DAOImpl;
import com.DB.DBConnect;

@WebServlet("/remove_instrument")

public class RemoveInstrumentCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int iid = Integer.parseInt(req.getParameter("iid"));
		int uid = Integer.parseInt(req.getParameter("uid"));
		Cart2DAOImpl dao = new Cart2DAOImpl(DBConnect.getConn());
		boolean f = dao.deleteInstrument(iid, uid);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("succMsg", "Song Removed from cart");
			resp.sendRedirect("cart2.jsp");
		} else {
			session.setAttribute("failedMsg", "Someting wrong");
			resp.sendRedirect("cart2.jsp");
		}
	}

}

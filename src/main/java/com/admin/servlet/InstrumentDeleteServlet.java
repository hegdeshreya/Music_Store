package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.InstrumentDAOImpl;
import com.DB.DBConnect;

@WebServlet("/deletee")
public class InstrumentDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			InstrumentDAOImpl dao = new InstrumentDAOImpl(DBConnect.getConn());

			boolean f = dao.deleteInstrument(id);
			HttpSession session = req.getSession();
			if (f) {

				session.setAttribute("succMsg", "Instrument deleted");
				resp.sendRedirect("admin/all_instrument.jsp");
			} else {

				session.setAttribute("failedMsg", "wrong");
				resp.sendRedirect("admin/all_instrument.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

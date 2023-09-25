package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.Cart2DAOImpl;
import com.DAO.InstrumentDAOImpl;
import com.DB.DBConnect;
import com.entity.Cart2;
import com.entity.instrument;

@WebServlet("/cart2")
public class Cart2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int iid = Integer.parseInt(req.getParameter("iid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
			InstrumentDAOImpl dao = new InstrumentDAOImpl(DBConnect.getConn());
			instrument i = dao.getInstrumentById(iid);
			Cart2 c = new Cart2();
			c.setIid(iid);
			c.setUid(uid);
			c.setInstruname(i.getInstruname());

			c.setPrice(Double.parseDouble(i.getPrice()));
			c.setTotalprice(Double.parseDouble(i.getPrice()));
			Cart2DAOImpl dao2 = new Cart2DAOImpl(DBConnect.getConn());
			boolean f = dao2.addcart2(c);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("addcart", "Instrument successfully added to cart");
			} else {
				session.setAttribute("failed", "Something went wrong");
			}

			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

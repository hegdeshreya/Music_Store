package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.SongDAOImpl;
import com.DB.DBConnect;
import com.entity.Cart;
import com.entity.songdtls;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int sid = Integer.parseInt(req.getParameter("sid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
			SongDAOImpl dao = new SongDAOImpl(DBConnect.getConn());
			songdtls s = dao.getSongById(sid);
			Cart c = new Cart();
			c.setSid(sid);
			c.setUid(uid);
			c.setSongName(s.getsongname());

			c.setPrice(Double.parseDouble(s.getPrice()));
			c.setTotal(Double.parseDouble(s.getPrice()));
			CartDAOImpl dao2 = new CartDAOImpl(DBConnect.getConn());
			boolean f = dao2.addcart(c);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("addcart", "Song successfully added to cart");
			} else {
				session.setAttribute("failed", "Something went wrong");
			}

			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.SongOrderImpl;
import com.DB.DBConnect;
import com.entity.Cart;
import com.entity.Song_Order;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			HttpSession session = req.getSession();
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pincode = req.getParameter("pincode");
			String paymentType = req.getParameter("payment");

			String fullAdd = address + "," + landmark + "," + city + "," + state + "," + pincode;

			CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
			List<Cart> slist = dao.getSongByUser(id);

			if (slist.isEmpty()) {

				session.setAttribute("failedMsg", "Add Items");
				resp.sendRedirect("cart.jsp");
			} else {
				SongOrderImpl dao2 = new SongOrderImpl(DBConnect.getConn());

				Song_Order o = null;

				ArrayList<Song_Order> orderList = new ArrayList<Song_Order>();
				Random r = new Random();
				for (Cart c : slist) {
					o = new Song_Order();
					o.setOrderId("SONG-ORD-00" + r.nextInt(1000));
					o.setUserName(name);
					o.setEmail(email);
					o.setPhno(phno);
					o.setFulladd(fullAdd);
					o.setSongName(c.getSongName());

					o.setPrice(c.getPrice() + "");
					o.setPaymentType(paymentType);
					orderList.add(o);

				}
				if ("noselect".equals(paymentType)) {

					resp.sendRedirect("cart.jsp");

				} else {
					boolean f = dao2.saveOrder(orderList);
					if (f) {
						resp.sendRedirect("order_sucess.jsp");
					} else {
						session.setAttribute("failedMsg", "Order Failed");
						resp.sendRedirect("cart.jsp");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

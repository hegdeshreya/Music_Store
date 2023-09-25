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

import com.DAO.Cart2DAOImpl;
import com.DAO.InstrumentOrderDAOImpl;
import com.DB.DBConnect;
import com.entity.Cart2;
import com.entity.Instrument_Order;

@WebServlet("/order2")
public class Order2Servlet extends HttpServlet {

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

			Cart2DAOImpl dao = new Cart2DAOImpl(DBConnect.getConn());
			List<Cart2> ilist = dao.getinstrumentByUser(id);

			if (ilist.isEmpty()) {

				session.setAttribute("failedMsg", "Add Items");
				resp.sendRedirect("cart2.jsp");
			} else {
				InstrumentOrderDAOImpl dao2 = new InstrumentOrderDAOImpl(DBConnect.getConn());

				Instrument_Order o = null;

				ArrayList<Instrument_Order> orderList = new ArrayList<Instrument_Order>();
				Random r = new Random();
				for (Cart2 c : ilist) {
					o = new Instrument_Order();
					o.setOrderId("Intrument-ORD-00" + r.nextInt(1000));
					o.setUserName(name);
					o.setEmail(email);
					o.setPhno(phno);
					o.setFulladd(fullAdd);
					o.setInstruName(c.getInstruname());

					o.setPrice(c.getPrice() + "");
					o.setPaymentType(paymentType);
					orderList.add(o);

				}
				if ("noselect".equals(paymentType)) {

					resp.sendRedirect("cart2.jsp");

				} else {
					boolean f = dao2.saveOrder2(orderList);
					if (f) {
						resp.sendRedirect("order_sucess.jsp");
					} else {
						session.setAttribute("failedMsg", "Order Failed");
						resp.sendRedirect("cart2.jsp");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

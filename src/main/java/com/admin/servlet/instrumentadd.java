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

import com.DAO.InstrumentDAOImpl;
import com.DB.DBConnect;
import com.entity.instrument;

@WebServlet("/add_instrument")
@MultipartConfig
public class instrumentadd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String iname = req.getParameter("iname");
			String price = req.getParameter("price");
			String quantity = req.getParameter("quantity");
			Part picPart = req.getPart("img");
			String picFilename = picPart.getSubmittedFileName();

			instrument i = new instrument(iname, price, quantity, picFilename, "admin");

			InstrumentDAOImpl dao = new InstrumentDAOImpl(DBConnect.getConn());

			// String songUploadPath = getServletContext().getRealPath("") + "music";
			// System.out.println(songUploadPath);

			boolean f = dao.addinstrument(i);
			HttpSession session = req.getSession();

			if (f) {

				// Save pic file
				String picUploadPath = getServletContext().getRealPath("/") + File.separator + "instru-img";
				String picFilePath = picUploadPath + File.separator + picFilename;
				picPart.write(picFilePath);

				session.setAttribute("succMsg", "Instrument added");
				resp.sendRedirect("admin/add_instrument.jsp");
			} else {
				session.setAttribute("failedMsg", "wrong");
				resp.sendRedirect("admin/add_instrument.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
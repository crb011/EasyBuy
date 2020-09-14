package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCT_CATEGORYDao;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT_CATEGORY;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class productClassQuaID extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int epc_id = Integer.valueOf(request.getParameter("epc_id"));
		EASYBUY_PRODUCT_CATEGORY li = EASYBUY_PRODUCT_CATEGORYDao.FindID(epc_id);
		List<EASYBUY_PRODUCT_CATEGORY> ea = EASYBUY_PRODUCT_CATEGORYDao.findAll();
		request.setAttribute("li",li);
		request.setAttribute("ea",ea);
		request.getRequestDispatcher("HTML/Back-end/productClass-modify.jsp").forward(request, response);
	}
}

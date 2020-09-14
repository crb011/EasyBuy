package indi.crb.Easybuy.Backservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCT_CATEGORYDao;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT_CATEGORY;

public class productClassSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			List<EASYBUY_PRODUCT_CATEGORY> ea = EASYBUY_PRODUCT_CATEGORYDao.findAll();
			request.setAttribute("li",ea);
			request.getRequestDispatcher("HTML/Back-end/productClass.jsp").forward(request, response);
	}
}
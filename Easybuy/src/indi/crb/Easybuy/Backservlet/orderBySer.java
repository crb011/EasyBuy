package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_NEWSDao;
import indi.crb.Easybuy.Dao.EASYBUY_ORDERDao;
import indi.crb.Easybuy.eitity.EASYBUY_NEWS;
import indi.crb.Easybuy.eitity.EASYBUY_ORDER;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class orderBySer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String orderId = request.getParameter("orderId");
			String userName = request.getParameter("userName");
			List<EASYBUY_ORDER> li = EASYBUY_ORDERDao.findByni(orderId, userName);
			request.setAttribute("li",li);
			request.getRequestDispatcher("HTML/Back-end/order.jsp").forward(request, response);
	}
}
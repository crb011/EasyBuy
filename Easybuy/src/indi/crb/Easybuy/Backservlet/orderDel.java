package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_ORDERDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class orderDel extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int eo_id = Integer.valueOf(request.getParameter("eo_id"));
			int a = EASYBUY_ORDERDao.del(eo_id);
			if(a>0)
			{
				request.getRequestDispatcher("orderQuafy").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Back-end/order.jsp").forward(request, response);
			}
	}
}

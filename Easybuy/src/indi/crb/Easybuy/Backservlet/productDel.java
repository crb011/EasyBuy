package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCTDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class productDel extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int ep_id = Integer.valueOf(request.getParameter("ep_id"));
			int a = EASYBUY_PRODUCTDao.del(ep_id);
			if(a>0)
			{
				request.getRequestDispatcher("productQuafy").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Back-end/product.jsp").forward(request, response);
			}
	}
}

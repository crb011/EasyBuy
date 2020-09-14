package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_NEWSDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class newsDel extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int en_id = Integer.valueOf(request.getParameter("en_id"));
			int a = EASYBUY_NEWSDao.del(en_id);
			if(a>0)
			{
				request.getRequestDispatcher("newsQuafy").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Back-end/news.jsp").forward(request, response);
			}
	}
}

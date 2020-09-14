package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_NEWSDao;
import indi.crb.Easybuy.eitity.EASYBUY_NEWS;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class newsAdd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			
			String content = request.getParameter("content");
			Date time = Date.valueOf(request.getParameter("time"));
			
			EASYBUY_NEWS ea = new EASYBUY_NEWS(title, content, time);
			int a = EASYBUY_NEWSDao.Add(ea);
			//System.out.println(a);
			if(a>0)
			{
				request.getRequestDispatcher("newsQuafy").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Back-end/news.jsp").forward(request, response);
			}	
	}
}

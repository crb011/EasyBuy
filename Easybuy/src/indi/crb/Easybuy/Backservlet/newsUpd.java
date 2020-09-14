package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_NEWSDao;
import indi.crb.Easybuy.eitity.EASYBUY_NEWS;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class newsUpd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.valueOf(request.getParameter("id"));
		String title = request.getParameter("title");
		String en_content = request.getParameter("content");
		Date time = Date.valueOf(request.getParameter("time"));
	//	System.out.println(id+title+en_content+"----"+time);
		EASYBUY_NEWS li = new EASYBUY_NEWS(id, title, en_content,time);
		int a = EASYBUY_NEWSDao.Eupdate(li);
		if(a>0)
		{
			request.getRequestDispatcher("newsQuafy").forward(request, response);
		}else{
			System.out.println("ÐÞ¸Ä´íÎó");
			request.getRequestDispatcher("HTML/Back-end/news-modify.jsp").forward(request, response);
		}
	}
}

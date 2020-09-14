package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_NEWSDao;
import indi.crb.Easybuy.eitity.EASYBUY_NEWS;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class newsSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			List<EASYBUY_NEWS> li = EASYBUY_NEWSDao.findAll();
			request.setAttribute("li",li);
		//	System.out.println(li);//≤‚ ‘ «∑Ò”–÷µ
			request.getRequestDispatcher("HTML/Back-end/news.jsp").forward(request, response);
	}
}
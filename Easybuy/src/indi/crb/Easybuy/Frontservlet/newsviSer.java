package indi.crb.Easybuy.Frontservlet;

import indi.crb.Easybuy.Dao.EASYBUY_NEWSDao;
import indi.crb.Easybuy.eitity.EASYBUY_NEWS;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class newsviSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int en_id = Integer.valueOf(request.getParameter("en_id"));
		EASYBUY_NEWS ea =  EASYBUY_NEWSDao.userfind(en_id);
		List<EASYBUY_NEWS> li = EASYBUY_NEWSDao.findAll();
		request.setAttribute("ea", ea);
		request.setAttribute("li", li);
		request.getRequestDispatcher("HTML/Front-end/news-view.jsp").forward(request, response);
	}
}
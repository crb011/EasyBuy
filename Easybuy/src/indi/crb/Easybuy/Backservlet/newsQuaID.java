package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_NEWSDao;
import indi.crb.Easybuy.eitity.EASYBUY_NEWS;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class newsQuaID extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			//��ȡjsp��?������ֵ
			int en_id = Integer.valueOf(request.getParameter("en_id"));
		//	System.out.println(id);
			EASYBUY_NEWS li = EASYBUY_NEWSDao.userfind(en_id);
			request.setAttribute("li",li);
			//�ɻ�ȡֵ
			request.getRequestDispatcher("HTML/Back-end/news-modify.jsp").forward(request, response);
	}

}

package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_COMMENTDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class guestbookDel extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int ec_id = Integer.valueOf(request.getParameter("ec_id"));
			int a = EASYBUY_COMMENTDao.DelID(ec_id);
			if(a>0)
			{
				request.getRequestDispatcher("guestbookQuafy").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Back-end/guestbook.jsp").forward(request, response);
			}
	}

}
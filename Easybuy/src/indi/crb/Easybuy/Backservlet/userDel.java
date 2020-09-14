package indi.crb.Easybuy.Backservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.crb.Easybuy.Dao.EASYBUY_USERDao;

public class userDel extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			//从jsp中获取id
			String id = request.getParameter("user_id");
			
			//request.setAttribute("id", id);
			int a = EASYBUY_USERDao.del(id);
			
			if(a>0)
			{
				request.getRequestDispatcher("userQuafy").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Back-end/user.jsp").forward(request, response);
			}
	}
}
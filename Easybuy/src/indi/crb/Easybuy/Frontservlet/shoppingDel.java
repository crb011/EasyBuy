package indi.crb.Easybuy.Frontservlet;

import indi.crb.Easybuy.Dao.EASYBUY_NEWSDao;
import indi.crb.Easybuy.Dao.EASYBUY_SHOPPINGDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class shoppingDel extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int EOD_ID = Integer.valueOf(request.getParameter("EOD_ID"));
			System.out.println(EOD_ID);
			int a = EASYBUY_SHOPPINGDao.del(EOD_ID);
			if(a>0)
			{
				request.getRequestDispatcher("shoppingQua").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Front-end/shopping.jsp").forward(request, response);
			}
	}

}

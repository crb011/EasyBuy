package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_ORDERDao;
import indi.crb.Easybuy.eitity.EASYBUY_ORDER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class orderSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			List<EASYBUY_ORDER> li = EASYBUY_ORDERDao.findAll();
			request.setAttribute("li",li);
		//	System.out.println(li);//≤‚ ‘ «∑Ò”–÷µ
			request.getRequestDispatcher("HTML/Back-end/order.jsp").forward(request, response);
	}
}
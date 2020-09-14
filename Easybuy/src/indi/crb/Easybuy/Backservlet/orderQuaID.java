package indi.crb.Easybuy.Backservlet;


import indi.crb.Easybuy.Dao.EASYBUY_ORDERDao;

import indi.crb.Easybuy.eitity.EASYBUY_ORDER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class orderQuaID extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			//获取jsp中?所附的值
			int eo_id = Integer.valueOf(request.getParameter("eo_id"));
		//	System.out.println(id);
			EASYBUY_ORDER li = EASYBUY_ORDERDao.FindID(eo_id);
			request.setAttribute("li",li);
			//可获取值
			request.getRequestDispatcher("HTML/Back-end/order-modify.jsp").forward(request, response);
	}
}

package indi.crb.Easybuy.Backservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCT_CATEGORYDao;

public class productClassDel extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//��jsp�л�ȡid
		int id = Integer.valueOf(request.getParameter("epc_id"));
		//����������
		//response.setContentType("text/html;charset=utf-8");
		//request.setAttribute("id", id);
		//����out��
		//PrintWriter out = response.getWriter();
		int a = EASYBUY_PRODUCT_CATEGORYDao.del(id);
		
		if(a>0)
		{
			request.getRequestDispatcher("productClassSer").forward(request, response);
		}else {
			request.getRequestDispatcher("HTML/Back-end/productClass.jsp").forward(request, response);
		}
	}
}
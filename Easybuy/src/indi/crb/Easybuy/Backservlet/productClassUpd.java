package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCT_CATEGORYDao;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT_CATEGORY;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class productClassUpd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int id =Integer.valueOf(request.getParameter("id"));
			String className = request.getParameter("className");
			int parentId =Integer.valueOf(request.getParameter("parentId"));
			//传入新建对象
			EASYBUY_PRODUCT_CATEGORY ea = new EASYBUY_PRODUCT_CATEGORY(id, className, parentId);
			int a = EASYBUY_PRODUCT_CATEGORYDao.Eupdate(ea);
			//System.out.println(a);
			if(a>0)
			{
				request.getRequestDispatcher("productClassSer").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Back-end/productClass-modify.jsp").forward(request, response);
			}		
	}
}
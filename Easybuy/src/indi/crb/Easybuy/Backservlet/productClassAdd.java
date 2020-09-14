package indi.crb.Easybuy.Backservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCT_CATEGORYDao;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT_CATEGORY;

public class productClassAdd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int parentId = Integer.valueOf(request.getParameter("parentId"));
			String className = request.getParameter("className");
			
			//System.out.println(parentId+"    "+className);//测试值有没有传入
			EASYBUY_PRODUCT_CATEGORY ea = new EASYBUY_PRODUCT_CATEGORY(className, parentId);
			
			int a = EASYBUY_PRODUCT_CATEGORYDao.Add(ea);
			//System.out.println(a);
			if(a>0)
			{
				request.getRequestDispatcher("productClassSer").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Back-end/productClass-add.jsp").forward(request, response);
			}
			
		
			
	}

}

package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCTDao;
import indi.crb.Easybuy.Dao.EASYBUY_PRODUCT_CATEGORYDao;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT_CATEGORY;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class productAddSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			//获取关联页面的所有数据
			List<EASYBUY_PRODUCT> l = EASYBUY_PRODUCTDao.findAll();
			List<EASYBUY_PRODUCT_CATEGORY> li = EASYBUY_PRODUCT_CATEGORYDao.findAll();
			request.setAttribute("l",l);
			request.setAttribute("li",li);
			request.getRequestDispatcher("HTML/Back-end/product-add.jsp").forward(request, response);
	}

}

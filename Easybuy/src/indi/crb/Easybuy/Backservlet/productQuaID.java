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

public class productQuaID extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			//获取jsp中?所附的值
			int ep_id = Integer.valueOf(request.getParameter("ep_id"));
			EASYBUY_PRODUCT li = EASYBUY_PRODUCTDao.userfind(ep_id);
			List<EASYBUY_PRODUCT_CATEGORY> list = EASYBUY_PRODUCT_CATEGORYDao.findAll();
			//List<EASYBUY_PRODUCT_CATEGORY> list = EASYBUY_PRODUCT_CATEGORYDao.findA(ep_id);
			request.setAttribute("li",li);
			request.setAttribute("list",list);
			request.getRequestDispatcher("HTML/Back-end/product-modify.jsp").forward(request, response);
	}

}

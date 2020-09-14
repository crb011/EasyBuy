package indi.crb.Easybuy.Frontservlet;

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

public class productliSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int epc_id = Integer.valueOf(request.getParameter("epc_id"));
			//查询分类商品
			List<EASYBUY_PRODUCT_CATEGORY> ea = EASYBUY_PRODUCT_CATEGORYDao.findAll();
			EASYBUY_PRODUCT_CATEGORY ea2 =  EASYBUY_PRODUCT_CATEGORYDao.find();
			//根据ID查询
			//查询分类子商品，根据ID
			List<EASYBUY_PRODUCT> list = EASYBUY_PRODUCTDao.findID(epc_id);
			request.setAttribute("ea", ea);
			request.setAttribute("ea2", ea2);
			request.setAttribute("list", list);
			request.getRequestDispatcher("HTML/Front-end/product-list.jsp").forward(request, response);
	}
}

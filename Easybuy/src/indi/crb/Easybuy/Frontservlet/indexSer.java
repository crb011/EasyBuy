package indi.crb.Easybuy.Frontservlet;

import indi.crb.Easybuy.Dao.EASYBUY_NEWSDao;
import indi.crb.Easybuy.Dao.EASYBUY_PRODUCTDao;
import indi.crb.Easybuy.Dao.EASYBUY_PRODUCT_CATEGORYDao;
import indi.crb.Easybuy.eitity.EASYBUY_NEWS;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT_CATEGORY;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class indexSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			//查询新闻动态
			List<EASYBUY_NEWS> li = EASYBUY_NEWSDao.findAll();
			//查询分类管理
			List<EASYBUY_PRODUCT_CATEGORY> ea = EASYBUY_PRODUCT_CATEGORYDao.findAll();
			//查询今日特价
			List<EASYBUY_PRODUCT> ea1 = EASYBUY_PRODUCTDao.FindTJ();
			//查询热卖推荐
			List<EASYBUY_PRODUCT> ea2 = EASYBUY_PRODUCTDao.FindRM();
			request.setAttribute("li", li);
			request.setAttribute("ea", ea);
			request.setAttribute("ea1", ea1);
			request.setAttribute("ea2", ea2);
			request.getRequestDispatcher("HTML/Front-end/index.jsp").forward(request, response);
	}
}

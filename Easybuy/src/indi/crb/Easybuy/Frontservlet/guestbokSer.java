package indi.crb.Easybuy.Frontservlet;

import indi.crb.Easybuy.Dao.EASYBUY_COMMENTDao;
import indi.crb.Easybuy.Dao.EASYBUY_PRODUCT_CATEGORYDao;
import indi.crb.Easybuy.eitity.EASYBUY_COMMENT;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT_CATEGORY;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class guestbokSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			//查询留言
			List<EASYBUY_COMMENT> ea = EASYBUY_COMMENTDao.findAll();
			//查询分类管理
			List<EASYBUY_PRODUCT_CATEGORY> ea2 = EASYBUY_PRODUCT_CATEGORYDao.findAll();
			request.setAttribute("ea", ea);
			request.setAttribute("ea2", ea2);
			request.getRequestDispatcher("HTML/Front-end/guestbook.jsp").forward(request, response);
	}

}

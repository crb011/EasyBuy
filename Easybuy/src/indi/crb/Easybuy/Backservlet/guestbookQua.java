package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_COMMENTDao;
import indi.crb.Easybuy.eitity.EASYBUY_COMMENT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class guestbookQua extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			//获取jsp中?所附的值
			int ec_tid = Integer.valueOf(request.getParameter("ec_tid"));
		//	System.out.println(ec_tid);
			EASYBUY_COMMENT li = EASYBUY_COMMENTDao.FindID(ec_tid);
			request.setAttribute("li",li);
			//可获取值
			request.getRequestDispatcher("HTML/Back-end/guestbook-ck.jsp").forward(request, response);
	}
}
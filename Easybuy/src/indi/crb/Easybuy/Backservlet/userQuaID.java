package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_USERDao;
import indi.crb.Easybuy.eitity.EASYBUY_USER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userQuaID extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//页面查询
		request.setCharacterEncoding("utf-8");
		//获取修改按钮?的id，根据id做查询
		String user_id = request.getParameter("user_id");
		//在调用查询dao(id)，返回对象
		EASYBUY_USER li = EASYBUY_USERDao.userfind(user_id);
		//键值对把值传出去
		request.setAttribute("li", li);
		//带参转发到其他页面
		request.getRequestDispatcher("HTML/Back-end/user-modify.jsp").forward(request, response);
	}
}
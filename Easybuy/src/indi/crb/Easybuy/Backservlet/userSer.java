package indi.crb.Easybuy.Backservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.crb.Easybuy.Dao.EASYBUY_USERDao;
import indi.crb.Easybuy.eitity.EASYBUY_USER;

public class userSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//��ת����ʽ
			request.setCharacterEncoding("utf-8");
			//request.getParameter(arg0);
			//���ӵ�����dao�Ĳ�ѯ
			List<EASYBUY_USER> li = EASYBUY_USERDao.findAll();
			request.setAttribute("li",li);
			request.getRequestDispatcher("HTML/Back-end/user.jsp").forward(request, response);
	
	}

}
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
		//ҳ���ѯ
		request.setCharacterEncoding("utf-8");
		//��ȡ�޸İ�ť?��id������id����ѯ
		String user_id = request.getParameter("user_id");
		//�ڵ��ò�ѯdao(id)�����ض���
		EASYBUY_USER li = EASYBUY_USERDao.userfind(user_id);
		//��ֵ�԰�ֵ����ȥ
		request.setAttribute("li", li);
		//����ת��������ҳ��
		request.getRequestDispatcher("HTML/Back-end/user-modify.jsp").forward(request, response);
	}
}
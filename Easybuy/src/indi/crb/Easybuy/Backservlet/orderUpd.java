package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_ORDERDao;
import indi.crb.Easybuy.eitity.EASYBUY_ORDER;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class orderUpd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id =Integer.valueOf(request.getParameter("id"));//����״̬
		String orderId = request.getParameter("orderId");//�û�ID
		String name = request.getParameter("name");//�ջ�������
		String dianhua = request.getParameter("dianhua");//�ջ��˵绰
		String addres = request.getParameter("addres");//�ջ��˵�ַ
		int cost =Integer.valueOf(request.getParameter("cost"));//�ܼ�Ǯ
		Date time = Date.valueOf(request.getParameter("time"));//����ʱ��
		int status =Integer.valueOf(request.getParameter("status"));//����״̬
		int fukfs =Integer.valueOf(request.getParameter("fukfs"));//�ܼ�Ǯ
	//	System.out.println(orderId+dianhua+name+addres+cost+time+status+fukfs);
		EASYBUY_ORDER li = new EASYBUY_ORDER(id, orderId, name, dianhua, addres, cost, time, status, fukfs);
		int a = EASYBUY_ORDERDao.Eupdate(li);
		System.out.println(a);
		if(a>0)
		{
			request.getRequestDispatcher("orderQuafy").forward(request, response);
		}else{
			request.getRequestDispatcher("HTML/Back-end/order-modify.jsp").forward(request, response);
		}
	}
}

package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_COMMENTDao;
import indi.crb.Easybuy.eitity.EASYBUY_COMMENT;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class guestbookUpd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int orderId = Integer.valueOf(request.getParameter("orderId"));//id
			Date ec_create_time = Date.valueOf(request.getParameter("ec_create_time"));//����ʱ��
			Date ec_reply_time = Date.valueOf(request.getParameter("ec_reply_time"));//�ظ�ʱ��
			String name = request.getParameter("name");//����
			String ec_content = request.getParameter("ec_content");//��������
			String replyContent = request.getParameter("replyContent");//�ظ�����
			
			//System.out.println(ec_reply_time+name+ec_content+replyContent+orderId+ec_create_time);
			
			EASYBUY_COMMENT ea = new EASYBUY_COMMENT(orderId, ec_content, ec_create_time, replyContent,ec_reply_time,name);
			int a = EASYBUY_COMMENTDao.Eupdate(ea);
			//System.out.println(ea);
			if(a>0)
			{
				request.getRequestDispatcher("guestbookQuafy").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Back-end/guestbook-modify.jsp").forward(request, response);
			}	
	}
}

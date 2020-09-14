package indi.crb.Easybuy.Frontservlet;

import indi.crb.Easybuy.Dao.EASYBUY_COMMENTDao;
import indi.crb.Easybuy.eitity.EASYBUY_COMMENT;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class guestbokADD extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String guestContent = request.getParameter("guestContent");//ÁôÑÔÄÚÈÝ
			Date ec_create_time = Date.valueOf(request.getParameter("ec_create_time"));//ÁôÑÔ´´½¨Ê±¼ä
			String ec_nick_name = request.getParameter("ec_nick_name");//ÁôÑÔêÇ³Æ
			EASYBUY_COMMENT a = new EASYBUY_COMMENT(guestContent,ec_create_time,null,null,ec_nick_name);
			int ea = EASYBUY_COMMENTDao.Add(a);
			if(ea>0)
			{
				request.getRequestDispatcher("indexSer").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Front-end/guestbook.jsp").forward(request, response);
			}
			
			
	}

}

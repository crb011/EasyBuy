package indi.crb.Easybuy.Frontservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Seeionzx extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession();
			//ÒÆ³ýµÇÂ½µÄsession¶ÔÏó
			session.removeAttribute("ea");
			session.removeAttribute("qtname");
			request.getRequestDispatcher("indexSer").forward(request, response);
	}

}

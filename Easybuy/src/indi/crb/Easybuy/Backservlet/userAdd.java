package indi.crb.Easybuy.Backservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.crb.Easybuy.Dao.EASYBUY_USERDao;
import indi.crb.Easybuy.eitity.EASYBUY_USER;

public class userAdd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//第一步先获取值
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");//登录名
		String name = request.getParameter("name");//用户名(昵称)
		String passWord = request.getParameter("passWord");//密码
		String sex = request.getParameter("sex");//性别
		Date birthday = Date.valueOf(request.getParameter("birthday"));//出生日期
		String mobile = request.getParameter("mobile");//电话
		String address = request.getParameter("address");//地址
		String email = request.getParameter("email");//email
		System.out.println(userName+name+passWord+sex+birthday+mobile+address+email);
		EASYBUY_USER ea = new EASYBUY_USER(userName,name,passWord,sex,birthday,"",email,mobile,address,1);
		//System.out.println(ea);
		int conet = EASYBUY_USERDao.Add(ea);
		//System.out.println(conet);
		if(conet>0)
		{
			//System.out.println("写对了");
			request.setAttribute("ea", ea);
			request.getRequestDispatcher("userQuafy").forward(request, response);
		}else{
			//System.out.println("写错了");
			request.setAttribute("ea", ea);
			request.getRequestDispatcher("HTML/Back-end/user-add.jsp").forward(request, response);
		}
	}
}
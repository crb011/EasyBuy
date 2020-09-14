package indi.crb.Easybuy.Backservlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.crb.Easybuy.Dao.EASYBUY_USERDao;
import indi.crb.Easybuy.eitity.EASYBUY_USER;

public class userUpd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			//获取jsp的值
			String userName = request.getParameter("userName");
			String name = request.getParameter("name");
			String passWord = request.getParameter("passWord");
			String sex = request.getParameter("sex");
			Date birthday = Date.valueOf(request.getParameter("birthday"));
			String sfz = request.getParameter("sfz");
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			int status =Integer.valueOf(request.getParameter("status"));
			//测试成功可获取值
			//System.out.println(userName+name+passWord+sex+mobile+address+email+status+birthday);
			//传入新建对象
			EASYBUY_USER ea = new EASYBUY_USER(userName,name,passWord,sex,birthday,sfz,email,mobile,address,status);
			int a = EASYBUY_USERDao.Eupdate(ea);
			//System.out.println(a);
			if(a>0)
			{
				request.getRequestDispatcher("userQuafy").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Back-end/user-modify.jsp").forward(request, response);
			}		
	}
}
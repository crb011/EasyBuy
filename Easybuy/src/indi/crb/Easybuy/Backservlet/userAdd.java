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
		//��һ���Ȼ�ȡֵ
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");//��¼��
		String name = request.getParameter("name");//�û���(�ǳ�)
		String passWord = request.getParameter("passWord");//����
		String sex = request.getParameter("sex");//�Ա�
		Date birthday = Date.valueOf(request.getParameter("birthday"));//��������
		String mobile = request.getParameter("mobile");//�绰
		String address = request.getParameter("address");//��ַ
		String email = request.getParameter("email");//email
		System.out.println(userName+name+passWord+sex+birthday+mobile+address+email);
		EASYBUY_USER ea = new EASYBUY_USER(userName,name,passWord,sex,birthday,"",email,mobile,address,1);
		//System.out.println(ea);
		int conet = EASYBUY_USERDao.Add(ea);
		//System.out.println(conet);
		if(conet>0)
		{
			//System.out.println("д����");
			request.setAttribute("ea", ea);
			request.getRequestDispatcher("userQuafy").forward(request, response);
		}else{
			//System.out.println("д����");
			request.setAttribute("ea", ea);
			request.getRequestDispatcher("HTML/Back-end/user-add.jsp").forward(request, response);
		}
	}
}
package indi.crb.Easybuy.Frontservlet;

import indi.crb.Easybuy.Dao.EASYBUY_SHOPPINGDao;
import indi.crb.Easybuy.eitity.EASYBUY_SHOPPING;
import indi.crb.Easybuy.eitity.EASYBUY_USER;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class shoppingQua extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			//获取传出来登录用户
			EASYBUY_USER ea = (EASYBUY_USER) request.getSession().getAttribute("ea");
			//List<EASYBUY_SHOPPING> li = EASYBUY_SHOPPINGDao.FindAll();
			if(ea==null)
			{
				out.print("<script>alert('请登录');location.href='loginSer'</script>");
			}else {
				//根据获取登录的名字跳转去购物车查询页面
				List<EASYBUY_SHOPPING> li = EASYBUY_SHOPPINGDao.Find(ea.getEu_user_name());
				request.setAttribute("li",li);
				request.getRequestDispatcher("HTML/Front-end/shopping.jsp").forward(request, response);
			
			}
			
			}
	}

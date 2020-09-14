package indi.crb.Easybuy.Frontservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.crb.Easybuy.Dao.EASYBUY_USERDao;
import indi.crb.Easybuy.eitity.EASYBUY_USER;

public class loginSerDL extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//转换格式
		request.setCharacterEncoding("utf-8");
		//处理弹窗乱码
		response.setContentType("text/html;charset=utf-8");
		//获取传入过来的值
		String eu_user_id = request.getParameter("userName");//用户名称
		String eu_password =request.getParameter("passWord");
		//获取输入验证码
		String code = request.getParameter("veryCode");
		
		//获取图片真实验证码,强转
		String veryCod = (String)request.getSession().getAttribute("veryCode");
		//测试是否能拿到验证码
		//System.out.println(code+"  "+veryCod);
		EASYBUY_USER ea = EASYBUY_USERDao.findName(eu_user_id, eu_password);
		//创建out流
		PrintWriter out = response.getWriter();
		if(ea!=null)
		{
			//判断也验证码是否正确（不区分大小写）
			if(code.equalsIgnoreCase(veryCod))
			{
				//判断登录的是管理者还是普通用户
				if(ea.getEu_status()==1)
				{
					//传用户去前台，别的还需要拿，所以不能写局部变量
					request.getSession().setAttribute("ea",ea);
					request.getSession().setAttribute("qtname",eu_user_id);
					request.getRequestDispatcher("HTML/Front-end/reg-login.jsp").forward(request, response);
				}else{
					request.getSession().setAttribute("name",eu_user_id);
					request.getRequestDispatcher("HTML/Back-end/index.jsp").forward(request, response);
				}
			}else{
				out.write("<script>alert('验证码错误');location.href='loginSer'</script>");
			}
		}else{
			out.write("<script>alert('账号或密码错误');location.href='loginSer'</script>");
		}
		
	}

}

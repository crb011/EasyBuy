package indi.crb.Easybuy.Frontservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.crb.Easybuy.Dao.EASYBUY_USERDao;
import indi.crb.Easybuy.eitity.EASYBUY_USER;

public class registeSerZC extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			//处理弹窗乱码
			response.setContentType("text/html;charset=utf-8");
			//获取jsp传入过来的值
			String userName = request.getParameter("userName");//用户名
			String userId = request.getParameter("userId");
			String passWord = request.getParameter("passWord");
			//获取传入过来的验证码
			String Code = request.getParameter("veryCode");
			//获取图片真实验证码
			String veryCode = (String)request.getSession().getAttribute("veryCode");
			//测试能拿到验证码吗
			System.out.println(Code+"  "+veryCode);
			//再次确认密码已有script做出了操作
			String rePassWord = request.getParameter("rePassWord");
			String sex = request.getParameter("sex");
			//测试值是否传递过来
			//System.out.println(userName+"   "+passWord+"   "+rePassWord);
			EASYBUY_USER ea = new EASYBUY_USER(userName,userId,passWord,sex,null,"","","","",1);
			int conet = EASYBUY_USERDao.Add(ea);
			//System.out.println(conet);
			//创建out流
			PrintWriter out = response.getWriter();
			if(conet>0)
			{
				if(Code.equalsIgnoreCase(veryCode))//不区分大小写，判断验证码
				{
					request.setAttribute("conet",conet);
					request.getRequestDispatcher("HTML/Front-end/reg-result.jsp").forward(request, response);
				}else{
					out.write("<script>alert('验证码错误');location.href='registerSer'</script>");
				}
				
			}else{
				request.setAttribute("conet",conet);
				request.getRequestDispatcher("registerSer").forward(request, response);
			}
	}
}

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
			//����������
			response.setContentType("text/html;charset=utf-8");
			//��ȡjsp���������ֵ
			String userName = request.getParameter("userName");//�û���
			String userId = request.getParameter("userId");
			String passWord = request.getParameter("passWord");
			//��ȡ�����������֤��
			String Code = request.getParameter("veryCode");
			//��ȡͼƬ��ʵ��֤��
			String veryCode = (String)request.getSession().getAttribute("veryCode");
			//�������õ���֤����
			System.out.println(Code+"  "+veryCode);
			//�ٴ�ȷ����������script�����˲���
			String rePassWord = request.getParameter("rePassWord");
			String sex = request.getParameter("sex");
			//����ֵ�Ƿ񴫵ݹ���
			//System.out.println(userName+"   "+passWord+"   "+rePassWord);
			EASYBUY_USER ea = new EASYBUY_USER(userName,userId,passWord,sex,null,"","","","",1);
			int conet = EASYBUY_USERDao.Add(ea);
			//System.out.println(conet);
			//����out��
			PrintWriter out = response.getWriter();
			if(conet>0)
			{
				if(Code.equalsIgnoreCase(veryCode))//�����ִ�Сд���ж���֤��
				{
					request.setAttribute("conet",conet);
					request.getRequestDispatcher("HTML/Front-end/reg-result.jsp").forward(request, response);
				}else{
					out.write("<script>alert('��֤�����');location.href='registerSer'</script>");
				}
				
			}else{
				request.setAttribute("conet",conet);
				request.getRequestDispatcher("registerSer").forward(request, response);
			}
	}
}

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
		//ת����ʽ
		request.setCharacterEncoding("utf-8");
		//����������
		response.setContentType("text/html;charset=utf-8");
		//��ȡ���������ֵ
		String eu_user_id = request.getParameter("userName");//�û�����
		String eu_password =request.getParameter("passWord");
		//��ȡ������֤��
		String code = request.getParameter("veryCode");
		
		//��ȡͼƬ��ʵ��֤��,ǿת
		String veryCod = (String)request.getSession().getAttribute("veryCode");
		//�����Ƿ����õ���֤��
		//System.out.println(code+"  "+veryCod);
		EASYBUY_USER ea = EASYBUY_USERDao.findName(eu_user_id, eu_password);
		//����out��
		PrintWriter out = response.getWriter();
		if(ea!=null)
		{
			//�ж�Ҳ��֤���Ƿ���ȷ�������ִ�Сд��
			if(code.equalsIgnoreCase(veryCod))
			{
				//�жϵ�¼���ǹ����߻�����ͨ�û�
				if(ea.getEu_status()==1)
				{
					//���û�ȥǰ̨����Ļ���Ҫ�ã����Բ���д�ֲ�����
					request.getSession().setAttribute("ea",ea);
					request.getSession().setAttribute("qtname",eu_user_id);
					request.getRequestDispatcher("HTML/Front-end/reg-login.jsp").forward(request, response);
				}else{
					request.getSession().setAttribute("name",eu_user_id);
					request.getRequestDispatcher("HTML/Back-end/index.jsp").forward(request, response);
				}
			}else{
				out.write("<script>alert('��֤�����');location.href='loginSer'</script>");
			}
		}else{
			out.write("<script>alert('�˺Ż��������');location.href='loginSer'</script>");
		}
		
	}

}

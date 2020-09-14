package indi.crb.Easybuy.Frontservlet;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCTDao;
import indi.crb.Easybuy.Dao.EASYBUY_SHOPPINGDao;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT;
import indi.crb.Easybuy.eitity.EASYBUY_SHOPPING;
import indi.crb.Easybuy.eitity.EASYBUY_USER;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class shoppingSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			//��ȡ���ݹ������û�
			EASYBUY_USER ea = (EASYBUY_USER) request.getSession().getAttribute("ea");
			//��ȡ����������ֵ
			int ep_id =Integer.valueOf(request.getParameter("ep_id"));
			EASYBUY_PRODUCT eas = EASYBUY_PRODUCTDao.QuaID(ep_id);
			PrintWriter out = response.getWriter();
			//���δ��½����ȡ������Ϊ�վͲ�����ӹ��ﳵ
			if(ea==null)
			{
				out.print("<script>alert('���¼');location.href='loginSer'</script>");
			}else {
				int count = EASYBUY_SHOPPINGDao.add(ea, eas);
				//��תȥ���ﳵ��ѯҳ��
				List<EASYBUY_SHOPPING> li = EASYBUY_SHOPPINGDao.Find(ea.getEu_user_name());
				request.setAttribute("li",li);
				request.setAttribute("eas",eas);
				request.getRequestDispatcher("HTML/Front-end/shopping.jsp").forward(request, response);
			
			}
	}

}

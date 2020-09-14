package indi.crb.Easybuy.Frontservlet;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCTDao;
import indi.crb.Easybuy.Dao.EASYBUY_PRODUCT_CATEGORYDao;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT_CATEGORY;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class productviSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.valueOf(request.getParameter("id"));
		//����ID��ѯ����
		EASYBUY_PRODUCT li =  EASYBUY_PRODUCTDao.userfind(id);
		//��ѯ�������
		List<EASYBUY_PRODUCT_CATEGORY> ea = EASYBUY_PRODUCT_CATEGORYDao.findAll();
		
		//��ѯ������(2����requestֻ�ܴ���һ��ҳ�棬Session���Դ��͵�����)
		HttpSession session = request.getSession();
		//����Session
		List<EASYBUY_PRODUCT> hislist = (List<EASYBUY_PRODUCT>) session.getAttribute("hislist");
		//�ж���ʷ��¼Ϊ��
		if(hislist==null)
		{//��ʷ��¼����û��¼�Ļ�
			hislist = new ArrayList<EASYBUY_PRODUCT>();
			//Ȼ�󴫳�ȥ
			session.setAttribute("hislist",hislist);
		}
		//�ж���ֵ�Ļ�(contains�ж��Ƿ����ֵ������Ŷ���)
		if(hislist.contains(li))
		{//��ʷ��¼���������ݵĻ�
			hislist.remove(li);//���Ƴ�ԭ�е�
			hislist.add(0, li);//����ӵ��ʼ
		}else{
			hislist.add(0, li);//û�����ݵĻ�ֱ����ӵ��ʼ
			//�ж���ʷ��¼����
			if(hislist.size()>2)
			{
				//��ô�Ƴ����һ��
				hislist.remove(2);
			}
		}
		
		request.setAttribute("ea", ea);
		request.setAttribute("li", li);
		request.getRequestDispatcher("HTML/Front-end/product-view.jsp").forward(request, response);
	}
}

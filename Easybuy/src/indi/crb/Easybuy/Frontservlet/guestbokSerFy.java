package indi.crb.Easybuy.Frontservlet;

import indi.crb.Easybuy.Dao.EASYBUY_COMMENTDao;
import indi.crb.Easybuy.Dao.EASYBUY_PRODUCTDao;
import indi.crb.Easybuy.Dao.EASYBUY_PRODUCT_CATEGORYDao;
import indi.crb.Easybuy.eitity.EASYBUY_COMMENT;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT_CATEGORY;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class guestbokSerFy extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			//��ȷ����һҳ��ʾ������
			int count = 2;
			//���һ�ν�ȥ���ǵ�һҳ
			int page = 1;
			//��ѯ��ȡID����������(.sizeΪ��ȡ����)
			int max =EASYBUY_COMMENTDao.findAll().size();
			//�������ҳ��
			int maxpage = 0;
			if(max%count==0)
			{
				maxpage = max/count;
			}else{
				maxpage = max/count+1;
			}
			String page2 = request.getParameter("page");
			//����û�������ҳ��
			if(page2!=null)
			{
				//����ǵ�һҳ����ô����һҳ�Ļ�����1,�������ҳ���Ļ��������ҳ��
				//��������Ϊ���ģ�ת��Ϊ����
				page = Integer.valueOf(page2);
				if(page<1)
				{
					page = 1;
				}else if(page>maxpage)
				{
					page = maxpage;
				}
			}
			//���ò���dao������Ĳ�����Ϊ�����������׼��
			int begin = page*count-(count-1);
			int end = count*page;
			//��ѯ�����ҷ�ҳ
			List<EASYBUY_COMMENT> ea = EASYBUY_COMMENTDao.FenAll(begin, end);
			//��ѯ�������
			List<EASYBUY_PRODUCT_CATEGORY> ea2 = EASYBUY_PRODUCT_CATEGORYDao.findAll();
			request.setAttribute("ea", ea);
			request.setAttribute("ea2", ea2);
			request.setAttribute("maxpage",maxpage);
			request.setAttribute("page",page);
			request.getRequestDispatcher("HTML/Front-end/guestbook.jsp").forward(request, response);
			
	}

}

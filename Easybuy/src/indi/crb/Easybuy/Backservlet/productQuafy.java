package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCTDao;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class productQuafy extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȷ����һҳ��ʾ������
		int count = 4;
		//���һ�ν�ȥ���ǵ�һҳ
		int page = 1;
		//��ѯһ���е���������(.sizeΪ��ȡ����)
		int max =EASYBUY_PRODUCTDao.findAll().size();
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
		List<EASYBUY_PRODUCT> li = EASYBUY_PRODUCTDao.FenAll(begin, end);
		request.setAttribute("li",li);
		request.setAttribute("maxpage",maxpage);
		request.setAttribute("page",page);
		request.getRequestDispatcher("HTML/Back-end/product.jsp").forward(request, response);
	}
}

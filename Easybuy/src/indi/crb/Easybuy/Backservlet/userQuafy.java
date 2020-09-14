package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_USERDao;
import indi.crb.Easybuy.eitity.EASYBUY_USER;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userQuafy extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȷ����һҳ��ʾ������
		int count = 6;
		//���һ�ν�ȥ���ǵ�һҳ
		int ks = 1;
		//��ѯһ���е���������(.sizeΪ��ȡ����)
		int max = EASYBUY_USERDao.findAll().size();
		//�������ҳ��
		int maxks = 0;
		if(max%count==0)
		{
			maxks = max/count;
		}else{
			maxks = max/count+1;
		}
		String ks2 = request.getParameter("ks");
		//����û�������ҳ��
		if(ks2!=null)
		{
			//����ǵ�һҳ����ô����һҳ�Ļ�����1,�������ҳ���Ļ��������ҳ��
			//��������Ϊ���ģ�ת��Ϊ����
			ks = Integer.valueOf(ks2);
			if(ks<1)
			{
				ks = 1;
			}else if(ks>maxks)
			{
				ks = maxks;
			}
		}
		//���ò���dao������Ĳ�����Ϊ�����������׼��
		int begin = ks*count-(count-1);
		int end = count*ks;
		List<EASYBUY_USER> li = EASYBUY_USERDao.FenAll(begin, end);
		request.setAttribute("li",li);
		request.setAttribute("maxks",maxks);
		request.setAttribute("ks",ks);
		request.getRequestDispatcher("HTML/Back-end/user.jsp").forward(request, response);
	}
}

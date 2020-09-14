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
		//先确定第一页显示的条数
		int count = 6;
		//设第一次进去的是第一页
		int ks = 1;
		//查询一共有的数据条数(.size为获取条数)
		int max = EASYBUY_USERDao.findAll().size();
		//求出最大的页数
		int maxks = 0;
		if(max%count==0)
		{
			maxks = max/count;
		}else{
			maxks = max/count+1;
		}
		String ks2 = request.getParameter("ks");
		//如果用户传过来页数
		if(ks2!=null)
		{
			//如果是第一页，那么再上一页的话就是1,大于最大页数的话等于最大页数
			//传过来的为中文，转换为数字
			ks = Integer.valueOf(ks2);
			if(ks<1)
			{
				ks = 1;
			}else if(ks>maxks)
			{
				ks = maxks;
			}
		}
		//调用操作dao，上面的操作皆为现在这变量做准备
		int begin = ks*count-(count-1);
		int end = count*ks;
		List<EASYBUY_USER> li = EASYBUY_USERDao.FenAll(begin, end);
		request.setAttribute("li",li);
		request.setAttribute("maxks",maxks);
		request.setAttribute("ks",ks);
		request.getRequestDispatcher("HTML/Back-end/user.jsp").forward(request, response);
	}
}

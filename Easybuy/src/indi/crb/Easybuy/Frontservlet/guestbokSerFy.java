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
			//先确定第一页显示的条数
			int count = 2;
			//设第一次进去的是第一页
			int page = 1;
			//查询获取ID的数据条数(.size为获取条数)
			int max =EASYBUY_COMMENTDao.findAll().size();
			//求出最大的页数
			int maxpage = 0;
			if(max%count==0)
			{
				maxpage = max/count;
			}else{
				maxpage = max/count+1;
			}
			String page2 = request.getParameter("page");
			//如果用户传过来页数
			if(page2!=null)
			{
				//如果是第一页，那么再上一页的话就是1,大于最大页数的话等于最大页数
				//传过来的为中文，转换为数字
				page = Integer.valueOf(page2);
				if(page<1)
				{
					page = 1;
				}else if(page>maxpage)
				{
					page = maxpage;
				}
			}
			//调用操作dao，上面的操作皆为现在这变量做准备
			int begin = page*count-(count-1);
			int end = count*page;
			//查询留言且分页
			List<EASYBUY_COMMENT> ea = EASYBUY_COMMENTDao.FenAll(begin, end);
			//查询分类管理
			List<EASYBUY_PRODUCT_CATEGORY> ea2 = EASYBUY_PRODUCT_CATEGORYDao.findAll();
			request.setAttribute("ea", ea);
			request.setAttribute("ea2", ea2);
			request.setAttribute("maxpage",maxpage);
			request.setAttribute("page",page);
			request.getRequestDispatcher("HTML/Front-end/guestbook.jsp").forward(request, response);
			
	}

}

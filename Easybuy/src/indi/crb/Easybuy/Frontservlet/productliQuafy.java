package indi.crb.Easybuy.Frontservlet;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCTDao;
import indi.crb.Easybuy.Dao.EASYBUY_PRODUCT_CATEGORYDao;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT_CATEGORY;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class productliQuafy extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.valueOf(request.getParameter("epc_id"));
		//先确定第一页显示的条数
		int count = 2;
		//设第一次进去的是第一页
		int page = 1;
		//查询获取ID的数据条数(.size为获取条数)
		int max =EASYBUY_PRODUCTDao.findID(id).size();
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
		//System.out.println(id+"----"+begin+"-----"+end);
		List< EASYBUY_PRODUCT> list = EASYBUY_PRODUCTDao.findID(id);
		List<EASYBUY_PRODUCT> list1 = EASYBUY_PRODUCTDao.FenAllID(begin, end);
		List<EASYBUY_PRODUCT_CATEGORY> ea = EASYBUY_PRODUCT_CATEGORYDao.findAll();
		EASYBUY_PRODUCT_CATEGORY ea1 = EASYBUY_PRODUCT_CATEGORYDao.findA();
		request.setAttribute("list",list);
		request.setAttribute("list1",list1);
		request.setAttribute("ea",ea);
		request.setAttribute("ea1",ea1);
		request.setAttribute("maxpage",maxpage);
		request.setAttribute("page",page);
		request.getRequestDispatcher("HTML/Front-end/product-list.jsp").forward(request, response);
	}
}

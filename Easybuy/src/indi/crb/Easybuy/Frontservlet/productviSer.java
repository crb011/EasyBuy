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
		//根据ID查询详情
		EASYBUY_PRODUCT li =  EASYBUY_PRODUCTDao.userfind(id);
		//查询分类管理
		List<EASYBUY_PRODUCT_CATEGORY> ea = EASYBUY_PRODUCT_CATEGORYDao.findAll();
		
		//查询最近浏览(2条，request只能传送一个页面，Session可以传送到各个)
		HttpSession session = request.getSession();
		//设置Session
		List<EASYBUY_PRODUCT> hislist = (List<EASYBUY_PRODUCT>) session.getAttribute("hislist");
		//判断历史记录为空
		if(hislist==null)
		{//历史记录里面没记录的话
			hislist = new ArrayList<EASYBUY_PRODUCT>();
			//然后传出去
			session.setAttribute("hislist",hislist);
		}
		//判断有值的话(contains判断是否存在值，里面放对象)
		if(hislist.contains(li))
		{//历史记录里面有数据的话
			hislist.remove(li);//先移除原有的
			hislist.add(0, li);//再添加到最开始
		}else{
			hislist.add(0, li);//没有数据的话直接添加到最开始
			//判断历史记录几条
			if(hislist.size()>2)
			{
				//那么移除最后一条
				hislist.remove(2);
			}
		}
		
		request.setAttribute("ea", ea);
		request.setAttribute("li", li);
		request.getRequestDispatcher("HTML/Front-end/product-view.jsp").forward(request, response);
	}
}

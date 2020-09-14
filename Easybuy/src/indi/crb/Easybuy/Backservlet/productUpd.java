package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCTDao;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class productUpd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//创建上传文件类
			SmartUpload su = new SmartUpload();
			//初始化文件上传
			su.initialize(this.getServletConfig(), request, response);
			//初始化全局名称变量
			String fileName = "";
			//上传
			try {
				su.upload();
				//获取文件
				Files f = su.getFiles();
				//获取文件名:0第一个文件
				File f1 = f.getFile(0);
				//需要更改页面编码格式为GBK，否则出现乱码
				//获取不重复的文件名称
				String name = UUID.randomUUID().toString();
				//获取文件后缀名
				String path = f1.getFileExt();
				fileName = name+"."+path;
				//传入项目文件夹和服务器
				//f1.saveAs("HTML/images/product/"+fileName);
				f1.saveAs("F:\\javaDemo\\Easybuy\\WebRoot\\HTML\\images\\product\\"+fileName);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//上传文件名和其它信息进数据库,获取信息应从smartupload对象中获取
			Request request1 = su.getRequest();
			int id =Integer.valueOf(request1.getParameter("id"));//所属分类
			String ep_name = request1.getParameter("productName");//商品名称
			int epc_child_id =Integer.valueOf(request1.getParameter("parentId"));//所属分类
			Double ep_price = Double.valueOf(request1.getParameter("productPrice"));
			String ep_description = request1.getParameter("product1");
			int ep_stock =Integer.valueOf(request1.getParameter("productstock"));
			//System.out.println(ep_name+epc_child_id+ep_price+ep_description+ep_stock+fileName);
			EASYBUY_PRODUCT ea = new EASYBUY_PRODUCT(id, ep_name, ep_description, ep_price, ep_stock, epc_child_id, fileName);
			int a = EASYBUY_PRODUCTDao.Eupdate(ea);
			//System.out.println(a);
			if(a>0)
			{
				request.getRequestDispatcher("productQuafy").forward(request, response);
			}else{
				//System.out.println("添加失败");
				request.getRequestDispatcher("HTML/Back-end/product-modify.jsp").forward(request, response);
			}
	} 

}

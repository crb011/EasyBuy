package indi.crb.Easybuy.Backservlet;

import indi.crb.Easybuy.Dao.EASYBUY_PRODUCTDao;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT;

import java.io.IOException;
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


public class productAdd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			/*//创建上传文件对象
			SmartUpload sm = new SmartUpload();
			//初始化上传文件
			sm.initialize(this.getServletConfig(),request,response);
			String a1=null;
			try {
				//上传
				sm.upload();
				//找到上传文件位置
				Files f = sm.getFiles();
				//根据上传文件的索引找到位置，从第一个上传文件的下标开始
				File a =f.getFile(0);
				//获取上传文件的名称
				a1 = a.getFileName();
				//给上传文件的名字重命名，防止相同跟出现文件乱码
				String uuid = UUID.randomUUID().toString();
				//获取文件后缀名
				String hz = a.getFileExt();
				//名字拼接后缀,更改上传文件名称
				a1 = uuid+"."+hz;
				//上传进服务器(项目)---上传绝对路径
				a.saveAs("F:/javaDemo/Easybuy/WebRoot/HTML/images/product"+a1);
				//然后上传进数据库就行
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/	
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
				//System.out.println(f1.getFileName());
				//获取不重复的文件名称
				String name = UUID.randomUUID().toString();
				//System.out.println(name);
				//获取文件后缀名
				String path = f1.getFileExt();
				//System.out.println(path);
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
			String ep_name = request1.getParameter("productName");//商品名称
			int epc_child_id =Integer.valueOf(request1.getParameter("parentId"));//所属分类
			int ep_price = Integer.valueOf(request1.getParameter("productPrice"));
			String ep_description = request1.getParameter("product1");
			int ep_stock =Integer.valueOf(request1.getParameter("productstock"));
			//System.out.println(ep_name+epc_child_id+ep_price+ep_description+ep_stock+fileName);
			EASYBUY_PRODUCT ea = new EASYBUY_PRODUCT(ep_name, ep_description, ep_price, ep_stock, epc_child_id, fileName);
			int a = EASYBUY_PRODUCTDao.Add(ea);
			if(a>0)
			{
				request.getRequestDispatcher("productQuafy").forward(request, response);
			}else{
				request.getRequestDispatcher("HTML/Back-end/product-add.jsp").forward(request, response);
			}
	} 

}

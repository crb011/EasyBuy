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
			/*//�����ϴ��ļ�����
			SmartUpload sm = new SmartUpload();
			//��ʼ���ϴ��ļ�
			sm.initialize(this.getServletConfig(),request,response);
			String a1=null;
			try {
				//�ϴ�
				sm.upload();
				//�ҵ��ϴ��ļ�λ��
				Files f = sm.getFiles();
				//�����ϴ��ļ��������ҵ�λ�ã��ӵ�һ���ϴ��ļ����±꿪ʼ
				File a =f.getFile(0);
				//��ȡ�ϴ��ļ�������
				a1 = a.getFileName();
				//���ϴ��ļ�����������������ֹ��ͬ�������ļ�����
				String uuid = UUID.randomUUID().toString();
				//��ȡ�ļ���׺��
				String hz = a.getFileExt();
				//����ƴ�Ӻ�׺,�����ϴ��ļ�����
				a1 = uuid+"."+hz;
				//�ϴ���������(��Ŀ)---�ϴ�����·��
				a.saveAs("F:/javaDemo/Easybuy/WebRoot/HTML/images/product"+a1);
				//Ȼ���ϴ������ݿ����
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/	
			//�����ϴ��ļ���
			SmartUpload su = new SmartUpload();
			//��ʼ���ļ��ϴ�
			su.initialize(this.getServletConfig(), request, response);
			//��ʼ��ȫ�����Ʊ���
			String fileName = "";
			//�ϴ�
			try {
				su.upload();
				//��ȡ�ļ�
				Files f = su.getFiles();
				//��ȡ�ļ���:0��һ���ļ�
				File f1 = f.getFile(0);
				//��Ҫ����ҳ������ʽΪGBK�������������
				//System.out.println(f1.getFileName());
				//��ȡ���ظ����ļ�����
				String name = UUID.randomUUID().toString();
				//System.out.println(name);
				//��ȡ�ļ���׺��
				String path = f1.getFileExt();
				//System.out.println(path);
				fileName = name+"."+path;
				//������Ŀ�ļ��кͷ�����
				//f1.saveAs("HTML/images/product/"+fileName);
				f1.saveAs("F:\\javaDemo\\Easybuy\\WebRoot\\HTML\\images\\product\\"+fileName);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//�ϴ��ļ�����������Ϣ�����ݿ�,��ȡ��ϢӦ��smartupload�����л�ȡ
			Request request1 = su.getRequest();
			String ep_name = request1.getParameter("productName");//��Ʒ����
			int epc_child_id =Integer.valueOf(request1.getParameter("parentId"));//��������
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

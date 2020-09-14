package indi.crb.Easybuy.Frontservlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class veryCodeSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//������֤��ĳ���
			int height = 30;
			int width = 100;
			
			//����֤�뽨һ������----------������������ɫ,��ȡ��ԭɫ
			BufferedImage bu = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
			//����һ������
			Graphics2D hb = bu.createGraphics();
			//���ɫ,��������ɫ�����û�������
			hb.setColor(Color.white);
			//������������״--ԭ�㶼Ϊ0����ý����ĳ�����
			hb.fillRect(0,0,width,height);
			
			//ȷ�����ֵĴ�С����ʽ--��������,����Ӵ֣������С�����ܳ������õĸ߶ȣ�
			hb.setFont(new Font("����������", Font.BOLD, 30));
			
			//���������ĸ�����ֵ���ϣ�ֻ��4λ��
			char [] a = {'1','2','3','4','5','q','w','e','r','Z','X','C','v','w','6'};
			//newһ��Random�������
			Random ra = new Random();
			
			//���ɵ���֤��ֵ,����Ȼᴫ��
			String veryCode = "";
			//ѭ���������4���ַ������һ���ַ���,����±꣬��0��ʼ
			for (int i = 0; i < 4; i++) {
				//���a���±�,ra��ȡ��һ��������a�ĳ���
				//תΪString���Ϳ��ԼӸ�""����
				String code = a[ra.nextInt(a.length)]+"";
				//��ȡ��һ�����ַ���Ȼ�󴫳�ȥ
				veryCode+=code;
				//�����ַ�����ɫ---��ȡ��ԭɫ��rgb,r����ɫ���Ϊ255����д��256����Ϊ�Ǵ�0��ʼ�����������ɫ
				hb.setColor(new Color(ra.nextInt(256),ra.nextInt(256),ra.nextInt(256)));
				
				//���õ����ַ��ļ��--��ȡÿ���ַ�,����X����,����Y��ļ��
				hb.drawString(code,25*i,30);
			}
			
			//�����ַ�������(4��)
			for (int i = 0; i < 5; i++) {
				//�����ַ�����ɫ�����������ɫ
				hb.setColor(new Color(ra.nextInt(256),ra.nextInt(256),ra.nextInt(256)));
				//X,Y������趨�ĳ���
				hb.drawOval(ra.nextInt(width),ra.nextInt(height), width, height);
			}
			
			//����֤��д��jsp�������������
			ServletOutputStream sos = response.getOutputStream();
			//����session,�����������õ�����session���valueCodeֵ
			//ͨ����ֵ�Դ�������
			request.getSession().setAttribute("veryCode",veryCode);
			//ȷ����֤���ʽ,��Ϊǰ�˵�Ϊһ��ͼƬ�����ͼƬ��д��ȥ
			ImageIO.write(bu,"jpeg",sos);
			//�ر�һ����������
			sos.close();
	}

}

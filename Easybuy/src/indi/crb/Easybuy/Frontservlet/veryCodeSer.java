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
			//设置验证码的长宽
			int height = 30;
			int width = 100;
			
			//给验证码建一个画布----------宽，长，画布颜色,获取三原色
			BufferedImage bu = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
			//建立一个画笔
			Graphics2D hb = bu.createGraphics();
			//填充色,给画布上色，需用画笔来点
			hb.setColor(Color.white);
			//建立画布的形状--原点都为0，获得建立的长跟宽
			hb.fillRect(0,0,width,height);
			
			//确定文字的大小及样式--设置字体,字体加粗，字体大小（不能超过设置的高度）
			hb.setFont(new Font("华康布丁体", Font.BOLD, 30));
			
			//创建随机字母跟数字的组合（只需4位）
			char [] a = {'1','2','3','4','5','q','w','e','r','Z','X','C','v','w','6'};
			//new一个Random对象出来
			Random ra = new Random();
			
			//生成的验证码值,方便等会传出
			String veryCode = "";
			//循环随机挑出4个字符，组成一个字符串,获得下标，从0开始
			for (int i = 0; i < 4; i++) {
				//获得a的下标,ra获取下一个，传入a的长度
				//转为String类型可以加个""就行
				String code = a[ra.nextInt(a.length)]+"";
				//获取到一个个字符，然后传出去
				veryCode+=code;
				//设置字符的颜色---获取三原色，rgb,r的颜色最大为255，需写到256，因为是从0开始，随机所有颜色
				hb.setColor(new Color(ra.nextInt(256),ra.nextInt(256),ra.nextInt(256)));
				
				//设置单个字符的间距--获取每个字符,设置X轴间距,设置Y轴的间距
				hb.drawString(code,25*i,30);
			}
			
			//创建字符干扰线(4条)
			for (int i = 0; i < 5; i++) {
				//设置字符的颜色，随机所有颜色
				hb.setColor(new Color(ra.nextInt(256),ra.nextInt(256),ra.nextInt(256)));
				//X,Y轴根据设定的长宽
				hb.drawOval(ra.nextInt(width),ra.nextInt(height), width, height);
			}
			
			//把验证码写到jsp，服务器输出流
			ServletOutputStream sos = response.getOutputStream();
			//创建session,可让所有人拿到，把session存放valueCode值
			//通过键值对传出数据
			request.getSession().setAttribute("veryCode",veryCode);
			//确定验证码格式,因为前端的为一个图片，需把图片流写出去
			ImageIO.write(bu,"jpeg",sos);
			//关闭一个服务器流
			sos.close();
	}

}

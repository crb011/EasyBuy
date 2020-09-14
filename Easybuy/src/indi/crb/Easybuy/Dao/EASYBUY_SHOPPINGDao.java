package indi.crb.Easybuy.Dao;

import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT;
import indi.crb.Easybuy.eitity.EASYBUY_SHOPPING;
import indi.crb.Easybuy.eitity.EASYBUY_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EASYBUY_SHOPPINGDao {
	//设置全局变量
	private static Connection conn = null;
	private static PreparedStatement pre = null;
	private static ResultSet res = null;
	private static String sql = null;
	//查询
	public static List<EASYBUY_SHOPPING> FindAll()//参数为用户表中的用户名称
	{
		List<EASYBUY_SHOPPING> li = new ArrayList<EASYBUY_SHOPPING>();
		conn = baseDao.getconn();
		sql = "select * from EASYBUY_SHOPPING";//判断用户名称等于取到的用户账号
		try {
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next())
			{
				EASYBUY_SHOPPING ea = new EASYBUY_SHOPPING(res.getInt("EOD_ID"), res.getString("EO_USERNAME"),
						res.getInt("EP_ID"), res.getString("EP_FILE_NAME"), res.getString("EP_NAME"),
						res.getDouble("EOD_COST"));
				li.add(ea);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			baseDao.closeAll(conn, pre, res);
		}
		return li;
	}
	//根据用户跟商品表做添加
		public static int add(EASYBUY_USER ea,EASYBUY_PRODUCT eas)
		{
			int count = 0;
			conn = baseDao.getconn();
			sql = "insert into EASYBUY_SHOPPING values(seq_eod_id.nextval,?,?,?,?,?)";
			
			try {
				pre = conn.prepareStatement(sql);
				pre.setString(1,ea.getEu_user_name());//获取用户名
				pre.setInt(2,eas.getEp_id());//获取商品id
				pre.setString(3,eas.getEp_file_name());//获取商品图片
				pre.setString(4,eas.getEp_name());//获取商品名字
				pre.setDouble(5,eas.getEp_price());//获取商品价格
				
				count = pre.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				baseDao.closeAll(conn, pre, res);
			}
			return count;
		}
		
		//查询购物车（根据用户昵称）
		public static List<EASYBUY_SHOPPING> Find(String ep_user_name)//参数为用户表中的用户名称
		{
			List<EASYBUY_SHOPPING> li = new ArrayList<EASYBUY_SHOPPING>();
			conn = baseDao.getconn();
			sql = "select * from EASYBUY_SHOPPING where EO_USERNAME=?";//判断用户名称等于取到的用户账号
			try {
				pre = conn.prepareStatement(sql);
				pre.setString(1,ep_user_name);
				res = pre.executeQuery();
				while(res.next())
				{
					EASYBUY_SHOPPING ea = new EASYBUY_SHOPPING(res.getInt("EOD_ID"), res.getString("EO_USERNAME"),
							res.getInt("EP_ID"), res.getString("EP_FILE_NAME"), res.getString("EP_NAME"),
							res.getDouble("EOD_COST"));
					li.add(ea);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				baseDao.closeAll(conn, pre, res);
			}
			return li;
		}
		//删除
		public static int del(int EOD_ID)
		{	
			int a = 0;
			conn = baseDao.getconn();
			//先查询所有，等会再单独去其中的一些数据
			sql="delete EASYBUY_SHOPPING where EOD_ID=?";
			try {
				pre=conn.prepareStatement(sql);
				pre.setInt(1,EOD_ID);
				a = pre.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				baseDao.closeAll(conn, pre, res);
			}
			return a;
		}
	//修改
}

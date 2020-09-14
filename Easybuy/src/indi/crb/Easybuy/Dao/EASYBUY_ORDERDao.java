package indi.crb.Easybuy.Dao;

import indi.crb.Easybuy.eitity.EASYBUY_ORDER;
import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT;
import indi.crb.Easybuy.eitity.EASYBUY_SHOPPING;
import indi.crb.Easybuy.eitity.EASYBUY_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EASYBUY_ORDERDao {
	//设置全局变量
		private static Connection conn = null;
		private static PreparedStatement pre = null;
		private static ResultSet res = null;
		private static String sql = null;
		
		//查询所有注册的用户
		public static List<EASYBUY_ORDER> findAll()
		{
			List<EASYBUY_ORDER> li = new ArrayList<EASYBUY_ORDER>();
			EASYBUY_ORDER a = null;
			conn = baseDao.getconn();
			//先查询所有，等会再单独去其中的一些数据
			sql="select * from EASYBUY_ORDER";
			try {
				pre=conn.prepareStatement(sql);
				res = pre.executeQuery();
				while(res.next())
				{
					a = new EASYBUY_ORDER(res.getInt("eo_id"),res.getString("eo_user_id"),res.getString("eo_user_name"),
							res.getString("eo_user_tel"),res.getString("eo_user_address"),res.getInt("eo_cost"),
							res.getDate("eo_create_time"),res.getInt("eo_status"),res.getInt("eo_type"));
					//装入集合
					li.add(a);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				baseDao.closeAll(conn, pre, res);
			}
			return li;
		}
		
		//删除
		public static int del(int eo_id)
		{	
			int a = 0;
			conn = baseDao.getconn();
			//先查询所有，等会再单独去其中的一些数据
			sql="delete EASYBUY_ORDER where eo_id=?";
			try {
				pre=conn.prepareStatement(sql);
				pre.setInt(1,eo_id);
				a = pre.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				baseDao.closeAll(conn, pre, res);
			}
			return a;
		}
		
		//根据ID查询
				public static EASYBUY_ORDER FindID(int eo_id)
				{
					EASYBUY_ORDER a = null;
					conn = baseDao.getconn();
					sql = "select * from EASYBUY_ORDER where eo_id=?";
					try {
						pre = conn.prepareStatement(sql);
						pre.setInt(1,eo_id);
						res = pre.executeQuery();
						while(res.next())
						{
							a = new EASYBUY_ORDER(res.getInt("eo_id"),res.getString("eo_user_id"),res.getString("eo_user_name"),
									res.getString("eo_user_tel"),res.getString("eo_user_address"),res.getInt("eo_cost"),
									res.getDate("eo_create_time"),res.getInt("eo_status"),res.getInt("eo_type"));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return a;
				}
				
				//修改
				public static int Eupdate(EASYBUY_ORDER ea)
				{
					int a = 0;
					conn = baseDao.getconn();
					sql="update EASYBUY_ORDER set eo_user_id=?,eo_user_name=?,eo_user_tel=?,eo_user_address=?,eo_cost=?,eo_create_time=?,eo_status=?,eo_type=? where eo_id=?";
					try {
						pre = conn.prepareStatement(sql);
						pre.setString(1,ea.getEo_user_id());
						pre.setString(2,ea.getEo_user_name());
						pre.setString(3,ea.getEo_user_tel());
						pre.setString(4,ea.getEo_user_address());
						pre.setInt(5,ea.getEo_cost());
						pre.setDate(6,ea.getEo_create_time());
						pre.setInt(7,ea.getEo_status());
						pre.setInt(8,ea.getEo_type());
						pre.setInt(9,ea.getEo_id());
						
						a = pre.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						baseDao.closeAll(conn, pre, res);
					}
					return a;
				}
				//根据名称或和父id查询
				public static List<EASYBUY_ORDER> findByni(String eo_user_id,String eo_user_name)
				{
					List<EASYBUY_ORDER> li = new ArrayList<EASYBUY_ORDER>();
					conn = baseDao.getconn();
					//都为空时
					sql = "select * from EASYBUY_ORDER where 1=1";//1=1为turn
					
					//eo_user_id不为空
					if(eo_user_id!="")
					{
						sql=sql+"and eo_user_id=?";
					}
					//eo_user_name不为空
					if(eo_user_name!="")
					{
						sql=sql+"and eo_user_name=?";
					}
					try {
						pre = conn.prepareStatement(sql);
						//灵活给？位置赋值
						int i = 1;
						if(eo_user_id!="")
						{
							pre.setString(i,eo_user_id);
							i++;
						}
						if(eo_user_name!="")
						{
							pre.setString(i,eo_user_name);
						}
						res = pre.executeQuery();
						while(res.next())
						{
							EASYBUY_ORDER a = new EASYBUY_ORDER(res.getInt("eo_id"),res.getString("eo_user_id"),res.getString("eo_user_name"),
									res.getString("eo_user_tel"),res.getString("eo_user_address"),res.getInt("eo_cost"),
									res.getDate("eo_create_time"),res.getInt("eo_status"),res.getInt("eo_type"));
							li.add(a);
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
				//分页查询
				public static List<EASYBUY_ORDER> FenAll(int start,int end)
				{
					List<EASYBUY_ORDER> li = new ArrayList<EASYBUY_ORDER>();
					conn = baseDao.getconn();
					sql="select * from(select rownum r,s.* from(select * from " +
							"EASYBUY_ORDER order by eo_id asc)s)m where m.r " +
							"between ? and ?";
					try {
						pre = conn.prepareStatement(sql);
						pre.setInt(1,start);
						pre.setInt(2,end);
						res = pre.executeQuery();
						while(res.next())
						{
							//获取值
							EASYBUY_ORDER a = new EASYBUY_ORDER(res.getInt("eo_id"),res.getString("eo_user_id"),res.getString("eo_user_name"),
									res.getString("eo_user_tel"),res.getString("eo_user_address"),res.getInt("eo_cost"),
									res.getDate("eo_create_time"),res.getInt("eo_status"),res.getInt("eo_type"));
							li.add(a);
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
				//根据购物车跟用户信息作新增
				public static int add(EASYBUY_SHOPPING eas,EASYBUY_USER ea)
				{
					int count = 0;
					conn = baseDao.getconn();
					sql = "insert into EASYBUY_ORDER values(dingdan.nextval,?,?,?,?,?,?,?,?)";
					
					try {
						pre = conn.prepareStatement(sql);
						pre.setInt(1,eas.getEOD_ID());//获取订单ID
						pre.setString(2,ea.getEu_user_name());//获取用户数据中的用户名
						pre.setString(3,ea.getEu_mobile());//获取用户数据中的电话
						pre.setString(4,ea.getEu_address());//获取用户数据中的地址
						pre.setDouble(5,eas.getEOD_COST());//获取价格
						pre.setDate(6,ea.getEu_birthday());//获取用户数据中的日期
						pre.setInt(7,1);//订单状态
						pre.setInt(8,2);//付款方式
		
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
}

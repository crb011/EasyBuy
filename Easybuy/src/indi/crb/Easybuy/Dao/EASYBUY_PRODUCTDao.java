package indi.crb.Easybuy.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT;

public class EASYBUY_PRODUCTDao {
			//设置全局变量
			private static Connection conn = null;
			private static PreparedStatement pre = null;
			private static ResultSet res = null;
			private static String sql = null;
			
			//查询分类数据
			public static List<EASYBUY_PRODUCT> findAll()
			{
				List<EASYBUY_PRODUCT> li = new ArrayList<EASYBUY_PRODUCT>();
				EASYBUY_PRODUCT a = null;
				conn = baseDao.getconn();
				sql = "select * from easybuy_product";
				try {
				pre=conn.prepareStatement(sql);
				res = pre.executeQuery();
					while(res.next())
					{
						a = new EASYBUY_PRODUCT(res.getInt("ep_id"),res.getString("ep_name"),res.getString("ep_description"),
								res.getDouble("ep_price"),res.getInt("ep_stock"),res.getInt("epc_child_id"),
								res.getString("ep_file_name"));
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
			public static int del(int ep_id)
			{	
				int a = 0;
				conn = baseDao.getconn();
				//先查询所有，等会再单独去其中的一些数据
				sql="delete EASYBUY_PRODUCT where ep_id=?";
				try {
					pre=conn.prepareStatement(sql);
					pre.setInt(1,ep_id);
					a = pre.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					baseDao.closeAll(conn, pre, res);
				}
				return a;
			}
			//新增
			public static int Add(EASYBUY_PRODUCT ea)
			{
				int a = 0;
				conn = baseDao.getconn();
				sql="insert into EASYBUY_PRODUCT values(que_a.nextval,?,?,?,?,?,?)";
				try {
					pre = conn.prepareStatement(sql);
					pre.setString(1,ea.getEp_name());
					pre.setString(2,ea.getEp_description());
					pre.setDouble(3,ea.getEp_price());
					pre.setInt(4,ea.getEp_stock());
					pre.setInt(5,ea.getEp_child_id());
					pre.setString(6,ea.getEp_file_name());
					
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
			public static EASYBUY_PRODUCT userfind(int ep_id)
			{
				EASYBUY_PRODUCT a = null;
				conn = baseDao.getconn();
				//先查询所有，等会再单独去其中的一些数据
				sql="select * from EASYBUY_PRODUCT where ep_id=?";
				try {
					pre=conn.prepareStatement(sql);
					pre.setInt(1,ep_id);
					res = pre.executeQuery();
					while(res.next())
					{
						a = new EASYBUY_PRODUCT(res.getInt("ep_id"),res.getString("ep_name"),res.getString("ep_description"),
								res.getDouble("ep_price"),res.getInt("ep_stock"),res.getInt("epc_child_id"),
								res.getString("ep_file_name"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					baseDao.closeAll(conn, pre, res);
				}
				return a;
			}
			
			//前端根据ID查询,返回集合，俩表联查
			public static List<EASYBUY_PRODUCT> findID(int id)
			{
				List<EASYBUY_PRODUCT> li = new ArrayList<EASYBUY_PRODUCT>();
				EASYBUY_PRODUCT a = null;
				conn = baseDao.getconn();
				//先查询所有，等会再单独去其中的一些数据
				sql="select * from EASYBUY_PRODUCT where epc_child_id=?";
				try {
					pre=conn.prepareStatement(sql);
					pre.setInt(1,id);
					res = pre.executeQuery();
					while(res.next())
					{
						a = new EASYBUY_PRODUCT(res.getInt("ep_id"),res.getString("ep_name"),res.getString("ep_description"),
								res.getDouble("ep_price"),res.getInt("ep_stock"),res.getInt("epc_child_id"),
								res.getString("ep_file_name"));
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
			
			//修改
			public static int Eupdate(EASYBUY_PRODUCT ea)
			{
				int a = 0;
				conn = baseDao.getconn();
				sql="update EASYBUY_PRODUCT set ep_name=?,ep_description=?,ep_price=?,ep_stock=?,epc_child_id=?,ep_file_name=? where ep_id=?";
				try {
					pre = conn.prepareStatement(sql);
					pre.setString(1,ea.getEp_name());
					pre.setString(2,ea.getEp_description());
					pre.setDouble(3, ea.getEp_price());
					pre.setInt(4,ea.getEp_stock());
					pre.setInt(5,ea.getEp_child_id());
					pre.setString(6,ea.getEp_file_name());
					pre.setInt(7,ea.getEp_id());
					
					a = pre.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					baseDao.closeAll(conn, pre, res);
				}
				return a;
			}
			//分页查询
			public static List<EASYBUY_PRODUCT> FenAll(int start,int end)
			{
				List<EASYBUY_PRODUCT> li = new ArrayList<EASYBUY_PRODUCT>();
				conn = baseDao.getconn();
				sql="select * from(select rownum r,s.* from(select * from " +
						"EASYBUY_PRODUCT order by ep_id asc)s)m where m.r " +
						"between ? and ?";
				try {
					pre = conn.prepareStatement(sql);
					pre.setInt(1,start);
					pre.setInt(2,end);
					res = pre.executeQuery();
					while(res.next())
					{
						//获取值
						EASYBUY_PRODUCT a = new EASYBUY_PRODUCT(res.getInt("ep_id"),res.getString("ep_name"),res.getString("ep_description"),
								res.getDouble("ep_price"),res.getInt("ep_stock"),res.getInt("epc_child_id"),
								res.getString("ep_file_name"));
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
			
			//前端分页查询，根据ID来
			public static List<EASYBUY_PRODUCT> FenAllID(int start,int end)
			{
				List<EASYBUY_PRODUCT> li = new ArrayList<EASYBUY_PRODUCT>();
				conn = baseDao.getconn();
				sql="select * from(select rownum r,s.* from(select * from " +
						"EASYBUY_PRODUCT order by ep_id asc)s)m where m.r " +
						"between ? and ?";
				try {
					pre = conn.prepareStatement(sql);
					pre.setInt(1,start);
					pre.setInt(2,end);
					res = pre.executeQuery();
					while(res.next())
					{
						//获取值
						EASYBUY_PRODUCT a = new EASYBUY_PRODUCT(res.getInt("ep_id"),res.getString("ep_name"),res.getString("ep_description"),
								res.getDouble("ep_price"),res.getInt("ep_stock"),res.getInt("epc_child_id"),
								res.getString("ep_file_name"));
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
			//前台首页查询今日特价
			public static List<EASYBUY_PRODUCT> FindTJ()
			{
				List<EASYBUY_PRODUCT> li = new ArrayList<EASYBUY_PRODUCT>();
				EASYBUY_PRODUCT a = null;
				conn = baseDao.getconn();
				sql = "select * from" +
						"(select rownum r,s.* " +
						"from (select * from " +
						"easybuy_product order by " +
						"ep_price asc)s)t where t.r " +
						"between 1 and 8";
				try {
				pre=conn.prepareStatement(sql);
				res = pre.executeQuery();
					while(res.next())
					{
						a = new EASYBUY_PRODUCT(res.getInt("ep_id"),res.getString("ep_name"),res.getString("ep_description"),
								res.getDouble("ep_price"),res.getInt("ep_stock"),res.getInt("epc_child_id"),
								res.getString("ep_file_name"));
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
			
			//前台首页查询热卖推荐
			public static List<EASYBUY_PRODUCT> FindRM()
			{
				List<EASYBUY_PRODUCT> li = new ArrayList<EASYBUY_PRODUCT>();
				EASYBUY_PRODUCT a = null;
				conn = baseDao.getconn();
				sql = "select * from" +
						"(select rownum r,s.* " +
						"from (select * from " +
						"easybuy_product order by " +
						"ep_stock asc)s)t where t.r " +
						"between 1 and 12";
				try {
				pre=conn.prepareStatement(sql);
				res = pre.executeQuery();
					while(res.next())
					{
						a = new EASYBUY_PRODUCT(res.getInt("ep_id"),res.getString("ep_name"),res.getString("ep_description"),
								res.getDouble("ep_price"),res.getInt("ep_stock"),res.getInt("epc_child_id"),
								res.getString("ep_file_name"));
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
			//前台查询单个商品加入购物车
			public static EASYBUY_PRODUCT QuaID(int epc_id)
			{
				EASYBUY_PRODUCT a = null;
				conn = baseDao.getconn();
				sql = "select * from EASYBUY_PRODUCT where ep_id=?";
				try {
					pre = conn.prepareStatement(sql);
					pre.setInt(1,epc_id);
					res = pre.executeQuery();
					while(res.next())
					{
						a = new EASYBUY_PRODUCT(res.getInt("ep_id"),res.getString("ep_name"),res.getString("ep_description"),
								res.getInt("ep_price"),res.getInt("ep_stock"),res.getInt("epc_child_id"),
								res.getString("ep_file_name"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					baseDao.closeAll(conn, pre, res);
				}
				return a;
			}
		}

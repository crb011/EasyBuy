package indi.crb.Easybuy.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import indi.crb.Easybuy.eitity.EASYBUY_PRODUCT_CATEGORY;

public class EASYBUY_PRODUCT_CATEGORYDao {
		//设置全局变量
		private static Connection conn = null;
		private static PreparedStatement pre = null;
		private static ResultSet res = null;
		private static String sql = null;
		
		//查询分类数据
		public static List<EASYBUY_PRODUCT_CATEGORY> findAll()
		{
			List<EASYBUY_PRODUCT_CATEGORY> li = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
			EASYBUY_PRODUCT_CATEGORY a = null;
			conn = baseDao.getconn();
			//先查询所有，等会再单独去其中的一些数据
			sql="select * from easybuy_product_category";
			try {
				pre=conn.prepareStatement(sql);
				res = pre.executeQuery();
				while(res.next())
				{
					a = new EASYBUY_PRODUCT_CATEGORY(res.getInt("epc_id"),
						res.getString("epc_name"),res.getInt("epc_parent_id"));
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
		//两表联查
		public static List<EASYBUY_PRODUCT_CATEGORY> findA(int id)
		{
			List<EASYBUY_PRODUCT_CATEGORY> li = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
			EASYBUY_PRODUCT_CATEGORY a = null;
			conn = baseDao.getconn();
			//先查询所有，等会再单独去其中的一些数据
			sql="select * from easybuy_product_category epc_parent_id=?";
			try {
				pre=conn.prepareStatement(sql);
				pre.setInt(1,id);
				res = pre.executeQuery();
				while(res.next())
				{
					a = new EASYBUY_PRODUCT_CATEGORY(res.getInt("epc_id"),
						res.getString("epc_name"),res.getInt("epc_parent_id"));
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
		//前台查询分类数据
		public static EASYBUY_PRODUCT_CATEGORY find()
		{
			//List<EASYBUY_PRODUCT_CATEGORY> li = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
			EASYBUY_PRODUCT_CATEGORY a = null;
			conn = baseDao.getconn();
			//先查询所有，等会再单独去其中的一些数据
			sql="select * from easybuy_product_category";
			try {
				pre=conn.prepareStatement(sql);
				res = pre.executeQuery();
				while(res.next())
				{
					a = new EASYBUY_PRODUCT_CATEGORY(res.getInt("epc_id"),
						res.getString("epc_name"),res.getInt("epc_parent_id"));
					//装入集合
					//li.add(a);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				baseDao.closeAll(conn, pre, res);
			}
			return a;
		}
		//前端根据ID查询,俩表联查
		public static EASYBUY_PRODUCT_CATEGORY findID(int id)
		{
			//List<EASYBUY_PRODUCT_CATEGORY> li = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
			EASYBUY_PRODUCT_CATEGORY a = null;
			conn = baseDao.getconn();
			//先查询所有，等会再单独去其中的一些数据
			sql="select * from EASYBUY_PRODUCT_CATEGORY where epc_parent_id=?";
			try {
				pre=conn.prepareStatement(sql);
				pre.setInt(1,id);
				res = pre.executeQuery();
				while(res.next())
				{
					a = new EASYBUY_PRODUCT_CATEGORY(res.getInt("epc_id"),
							res.getString("epc_name"),res.getInt("epc_parent_id"));
				//	li.add(a);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				baseDao.closeAll(conn, pre, res);
			}
			return a;
		}
		//新增分类
		public static int Add(EASYBUY_PRODUCT_CATEGORY a)
		{
			int coest = 0;
			conn = baseDao.getconn();
			sql="insert into EASYBUY_PRODUCT_CATEGORY values(que_a.nextval,?,?)";//id自动增长
			try {
				pre = conn.prepareStatement(sql);
				pre.setString(1,a.getEpc_name());
				pre.setInt(2,a.getEpc_parent_id());
				
				coest = pre.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				baseDao.closeAll(conn, pre, res);
			}
			return coest;
		}
		//删除
		public static int del(int epc_id)
		{	
			int a = 0;
			conn = baseDao.getconn();
			//先查询所有，等会再单独去其中的一些数据
			sql="delete EASYBUY_PRODUCT_CATEGORY where epc_id=?";
			try {
				pre=conn.prepareStatement(sql);
				pre.setInt(1,epc_id);
				
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
		public static EASYBUY_PRODUCT_CATEGORY FindID(int epc_id)
		{
			EASYBUY_PRODUCT_CATEGORY ea = null;
			conn = baseDao.getconn();
			sql = "select * from EASYBUY_PRODUCT_CATEGORY where epc_id=?";
			try {
				pre = conn.prepareStatement(sql);
				pre.setInt(1,epc_id);
				res = pre.executeQuery();
				while(res.next())
				{
					ea = new EASYBUY_PRODUCT_CATEGORY(res.getInt("epc_id"),
							res.getString("epc_name"),res.getInt("epc_parent_id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ea;
		}
		
		//前台根据ID查询
				public static EASYBUY_PRODUCT_CATEGORY FindqtID(int epc_id)
				{
					EASYBUY_PRODUCT_CATEGORY ea = null;
					conn = baseDao.getconn();
					sql = "select * from EASYBUY_PRODUCT_CATEGORY where epc_id=?";
					try {
						pre = conn.prepareStatement(sql);
						pre.setInt(1,epc_id);
						res = pre.executeQuery();
						while(res.next())
						{
							ea = new EASYBUY_PRODUCT_CATEGORY(res.getInt("epc_id"),
									res.getString("epc_name"),res.getInt("epc_parent_id"));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return ea;
				}
		//修改
		public static int Eupdate(EASYBUY_PRODUCT_CATEGORY ea)
		{
			int a = 0;
			conn = baseDao.getconn();
			sql="update EASYBUY_PRODUCT_CATEGORY set epc_name=?,epc_parent_id=? where epc_id=?";
			try {
				pre = conn.prepareStatement(sql);
				pre.setString(1,ea.getEpc_name());
				pre.setInt(2,ea.getEpc_parent_id());
				pre.setInt(3, ea.getEpc_id());
				
				a = pre.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				baseDao.closeAll(conn, pre, res);
			}
			return a;
		}
		//前端查询分类数据
				public static EASYBUY_PRODUCT_CATEGORY findA()
				{
					//List<EASYBUY_PRODUCT_CATEGORY> li = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
					EASYBUY_PRODUCT_CATEGORY a = null;
					conn = baseDao.getconn();
					//先查询所有，等会再单独去其中的一些数据
					sql="select * from easybuy_product_category";
					try {
						pre=conn.prepareStatement(sql);
						res = pre.executeQuery();
						while(res.next())
						{
							a = new EASYBUY_PRODUCT_CATEGORY(res.getInt("epc_id"),
								res.getString("epc_name"),res.getInt("epc_parent_id"));
							//装入集合
							//li.add(a);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						baseDao.closeAll(conn, pre, res);
					}
					return a;
				}
		
}
package indi.crb.Easybuy.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import indi.crb.Easybuy.eitity.EASYBUY_NEWS;

public class EASYBUY_NEWSDao {
	//设置全局变量
	private static Connection conn = null;
	private static PreparedStatement pre = null;
	private static ResultSet res = null;
	private static String sql = null;
	
	//查询所有注册的用户
	public static List<EASYBUY_NEWS> findAll()
	{
		List<EASYBUY_NEWS> li = new ArrayList<EASYBUY_NEWS>();
		EASYBUY_NEWS a = null;
		conn = baseDao.getconn();
		//先查询所有，等会再单独去其中的一些数据
		sql="select * from EASYBUY_NEWS";
		try {
			pre=conn.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next())
			{
				a = new EASYBUY_NEWS(res.getInt("en_id"),res.getString("en_title"),
						res.getString("en_content"),res.getDate("en_create_time"));
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
	public static int del(int en_id)
	{	
		int a =0;
		conn = baseDao.getconn();
		//先查询所有，等会再单独去其中的一些数据
		sql="delete EASYBUY_NEWS where en_id=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1,en_id);
			
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
	public static int Eupdate(EASYBUY_NEWS ea)
	{
		int a = 0;
		conn = baseDao.getconn();
		sql="update EASYBUY_NEWS set en_title=?,en_content=?,en_create_time=? where en_id=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1,ea.getEn_title());
			pre.setString(2,ea.getEn_content());
			pre.setDate(3,ea.getEn_create_time());
			pre.setInt(4,ea.getEn_id());
			
			a = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			baseDao.closeAll(conn, pre, res);
		}
		return a;
	}
	
	//查询所需的消息,根据id查询
		public static EASYBUY_NEWS userfind(int en_id)
		{
			EASYBUY_NEWS a = null;
			conn = baseDao.getconn();
			//先查询所有，等会再单独去其中的一些数据
			sql="select * from EASYBUY_NEWS where en_id=?";
			try {
				pre=conn.prepareStatement(sql);
				pre.setInt(1,en_id);
				res = pre.executeQuery();
				while(res.next())
				{
					a = new EASYBUY_NEWS(res.getInt("en_id"),res.getString("en_title"),res.getString("en_content"),
							res.getDate("en_create_time"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				baseDao.closeAll(conn, pre, res);
			}
			return a;
		}
		
		//新增
		public static int Add(EASYBUY_NEWS a)
		{
			int coest = 0;
			conn = baseDao.getconn();
			sql="insert into EASYBUY_NEWS values(seq_oo.nextval,?,?,?)";
			try {
				pre = conn.prepareStatement(sql);
				pre.setString(1,a.getEn_title());
				pre.setString(2,a.getEn_content());
				pre.setDate(3,a.getEn_create_time());
			
				coest = pre.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				baseDao.closeAll(conn, pre, res);
			}
			return coest;
		}
		
		//查询所有,返回集合
		public static EASYBUY_NEWS find()
		{
		//	List<EASYBUY_NEWS> li = new ArrayList<EASYBUY_NEWS>();
			EASYBUY_NEWS a = null;
			conn = baseDao.getconn();
			//先查询所有，等会再单独去其中的一些数据
			sql="select * from EASYBUY_NEWS";
			try {
				pre=conn.prepareStatement(sql);
				res = pre.executeQuery();
				while(res.next())
				{
					a = new EASYBUY_NEWS(res.getInt("en_id"),res.getString("en_title"),
							res.getString("en_content"),res.getDate("en_create_time"));
					//装入集合
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
		//分页查询
		public static List<EASYBUY_NEWS> FenAll(int start,int end)
		{
			List<EASYBUY_NEWS> li = new ArrayList<EASYBUY_NEWS>();
			conn = baseDao.getconn();
			sql="select * from(select rownum r,s.* from(select * from " +
					"EASYBUY_NEWS order by en_id asc)s)m where m.r " +
					"between ? and ?";
			try {
				pre = conn.prepareStatement(sql);
				pre.setInt(1,start);
				pre.setInt(2,end);
				res = pre.executeQuery();
				while(res.next())
				{
					//获取值
					EASYBUY_NEWS a = new EASYBUY_NEWS(res.getInt("en_id"),res.getString("en_title"),
							res.getString("en_content"),res.getDate("en_create_time"));
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
		
}

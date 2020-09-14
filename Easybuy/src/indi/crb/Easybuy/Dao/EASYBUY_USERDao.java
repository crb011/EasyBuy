package indi.crb.Easybuy.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import indi.crb.Easybuy.eitity.EASYBUY_USER;

public class EASYBUY_USERDao {
	//设置全局变量
	private static Connection conn = null;
	private static PreparedStatement pre = null;
	private static ResultSet res = null;
	private static String sql = null;
	
	//查询所有注册的用户
	public static List<EASYBUY_USER> findAll()
	{
		List<EASYBUY_USER> li = new ArrayList<EASYBUY_USER>();
		EASYBUY_USER a = null;
		conn = baseDao.getconn();
		//先查询所有，等会再单独去其中的一些数据
		sql="select * from EASYBUY_USER";
		try {
			pre=conn.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next())
			{
				a = new EASYBUY_USER(res.getString("eu_user_id"),res.getString("eu_user_name"),
						res.getString("eu_password"),res.getString("eu_sex"),res.getDate("eu_birthday"),
						res.getString("eu_identity_code"),res.getString("eu_email"),res.getString("eu_mobile"),
						res.getString("eu_address"),res.getInt("eu_status"));
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
	
	//新增   做新增用户
	public static int Add(EASYBUY_USER a)
	{
		int coest = 0;
		conn = baseDao.getconn();
		sql="insert into EASYBUY_USER values(?,?,?,?,?,?,?,?,?,?)";
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1,a.getEu_user_id());
			pre.setString(2,a.getEu_user_name());
			pre.setString(3,a.getEu_password());
			pre.setString(4,a.getEu_sex());
			pre.setDate(5,a.getEu_birthday());
			pre.setString(6,a.getEu_mobile());
			pre.setString(7,a.getEu_address());
			pre.setString(8,a.getEu_email());
			pre.setString(9,a.getEu_identity_code());
			pre.setInt(10,a.getEu_status());
			
			coest = pre.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			baseDao.closeAll(conn, pre, res);
		}
		return coest;
	}
	
	//查询所需的消息,根据id查询
	public static EASYBUY_USER userfind(String eu_user_id)
	{
		EASYBUY_USER a = null;
		conn = baseDao.getconn();
		//先查询所有，等会再单独去其中的一些数据
		sql="select * from EASYBUY_USER where eu_user_id=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,eu_user_id);
			res = pre.executeQuery();
			while(res.next())
			{
				a = new EASYBUY_USER(res.getString("eu_user_id"),res.getString("eu_user_name"),
						res.getString("eu_password"),res.getString("eu_sex"),res.getDate("eu_birthday"),
						res.getString("eu_identity_code"),res.getString("eu_email"),res.getString("eu_mobile"),
						res.getString("eu_address"),res.getInt("eu_status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			baseDao.closeAll(conn, pre, res);
		}
		return a;
	}
	
	//修改
	public static int Eupdate(EASYBUY_USER ea)
	{
		int a = 0;
		conn = baseDao.getconn();
		sql="update EASYBUY_USER set eu_user_name=?,eu_password=?,eu_sex=?" +
				",eu_birthday=?,eu_identity_code=?,eu_email=?,eu_mobile=?,eu_address=?,eu_status=? where eu_user_id=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1,ea.getEu_user_name());
			pre.setString(2,ea.getEu_password());
			pre.setString(3,ea.getEu_sex());
			pre.setDate(4,ea.getEu_birthday());
			pre.setString(5,ea.getEu_identity_code());
			pre.setString(6,ea.getEu_email());
			pre.setString(7,ea.getEu_mobile());
			pre.setString(8,ea.getEu_address());
			pre.setInt(9,ea.getEu_status());
			pre.setString(10,ea.getEu_user_id());
			
			a = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			baseDao.closeAll(conn, pre, res);
		}
		return a;
	}
	
	//删除
	public static int del(String eu_user_id)
	{	
		int a =0;
		conn = baseDao.getconn();
		//先查询所有，等会再单独去其中的一些数据
		sql="delete EASYBUY_USER where eu_user_id=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,eu_user_id);
			
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
	public static List<EASYBUY_USER> FenAll(int ks,int js)
	{
		List<EASYBUY_USER> li = new ArrayList<EASYBUY_USER>();
		conn = baseDao.getconn();
		sql="select * from(select rownum r,s.* from(select * from " +
				"EASYBUY_USER order by eu_user_id asc)s)m where m.r " +
				"between ? and ?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1,ks);
			pre.setInt(2,js);
			res = pre.executeQuery();
			while(res.next())
			{
				//获取值
				EASYBUY_USER a = new EASYBUY_USER(res.getString("eu_user_id"),res.getString("eu_user_name"),
						res.getString("eu_password"),res.getString("eu_sex"),res.getDate("eu_birthday"),
						res.getString("eu_identity_code"),res.getString("eu_email"),res.getString("eu_mobile"),
						res.getString("eu_address"),res.getInt("eu_status"));
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
	//登录页面做条件查询
	public static EASYBUY_USER findName(String eu_user_id,String eu_password)
	{
		EASYBUY_USER a = null;
		conn = baseDao.getconn();
		//先查询所有，等会再单独去其中的一些数据
		sql="select * from EASYBUY_USER where eu_user_id=? and eu_password=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,eu_user_id);
			pre.setString(2,eu_password);
			res = pre.executeQuery();
			while(res.next())
			{
				a = new EASYBUY_USER(res.getString("eu_user_id"),
				res.getString("eu_user_name"),res.getString("eu_password"),
				res.getString("eu_sex"),res.getDate("eu_birthday"),
				res.getString("eu_identity_code"),res.getString("eu_email"),
				res.getString("eu_mobile"),res.getString("eu_address"),
				res.getInt("eu_status"));
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

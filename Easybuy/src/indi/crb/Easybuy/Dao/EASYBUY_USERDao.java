package indi.crb.Easybuy.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import indi.crb.Easybuy.eitity.EASYBUY_USER;

public class EASYBUY_USERDao {
	//����ȫ�ֱ���
	private static Connection conn = null;
	private static PreparedStatement pre = null;
	private static ResultSet res = null;
	private static String sql = null;
	
	//��ѯ����ע����û�
	public static List<EASYBUY_USER> findAll()
	{
		List<EASYBUY_USER> li = new ArrayList<EASYBUY_USER>();
		EASYBUY_USER a = null;
		conn = baseDao.getconn();
		//�Ȳ�ѯ���У��Ȼ��ٵ���ȥ���е�һЩ����
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
				//װ�뼯��
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
	
	//����   �������û�
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
	
	//��ѯ�������Ϣ,����id��ѯ
	public static EASYBUY_USER userfind(String eu_user_id)
	{
		EASYBUY_USER a = null;
		conn = baseDao.getconn();
		//�Ȳ�ѯ���У��Ȼ��ٵ���ȥ���е�һЩ����
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
	
	//�޸�
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
	
	//ɾ��
	public static int del(String eu_user_id)
	{	
		int a =0;
		conn = baseDao.getconn();
		//�Ȳ�ѯ���У��Ȼ��ٵ���ȥ���е�һЩ����
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
	
	//��ҳ��ѯ
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
				//��ȡֵ
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
	//��¼ҳ����������ѯ
	public static EASYBUY_USER findName(String eu_user_id,String eu_password)
	{
		EASYBUY_USER a = null;
		conn = baseDao.getconn();
		//�Ȳ�ѯ���У��Ȼ��ٵ���ȥ���е�һЩ����
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

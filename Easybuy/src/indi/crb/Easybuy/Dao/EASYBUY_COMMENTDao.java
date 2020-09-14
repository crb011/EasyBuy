package indi.crb.Easybuy.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import indi.crb.Easybuy.eitity.EASYBUY_COMMENT;
import indi.crb.Easybuy.eitity.EASYBUY_NEWS;

public class EASYBUY_COMMENTDao {
	//设置全局变量
	private static Connection conn = null;
	private static PreparedStatement pre = null;
	private static ResultSet res = null;
	private static String sql = null;
	
	//查询
	public static List<EASYBUY_COMMENT> findAll()
	{
		List<EASYBUY_COMMENT> li = new ArrayList<EASYBUY_COMMENT>();
		EASYBUY_COMMENT a = null;
		conn = baseDao.getconn();
		sql = "select * from EASYBUY_COMMENT";
		try {
		pre=conn.prepareStatement(sql);
		res = pre.executeQuery();
			while(res.next())
			{
				a = new EASYBUY_COMMENT(res.getInt("ec_id"),res.getString("ec_content"),res.getDate("ec_create_time"),
						res.getString("ec_reply"),res.getDate("ec_reply_time"),res.getString("ec_nick_name"));
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
	
	//根据id查询
	public static EASYBUY_COMMENT FindID(int ec_id)
	{
		EASYBUY_COMMENT a = null;
		conn = baseDao.getconn();
		sql = "select * from EASYBUY_COMMENT where ec_id=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1,ec_id);
			res = pre.executeQuery();
			while(res.next())
			{
				a = new EASYBUY_COMMENT(res.getInt("ec_id"),res.getString("ec_content"),res.getDate("ec_create_time"),
						res.getString("ec_reply"),res.getDate("ec_reply_time"),res.getString("ec_nick_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			baseDao.closeAll(conn, pre, res);
		}
		return a;
	}
	//根据id删除
		public static int DelID(int ec_id)
		{
			int a = 0;
			conn = baseDao.getconn();
			sql = "delete EASYBUY_COMMENT where ec_id=?";
			try {
				pre = conn.prepareStatement(sql);
				pre.setInt(1,ec_id);
				a = pre.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				baseDao.closeAll(conn, pre, res);
			}
			return a;
		}
		//根据ID修改
		public static int Eupdate(EASYBUY_COMMENT ea)
		{
			int a = 0;
			conn = baseDao.getconn();
			sql="update EASYBUY_COMMENT set ec_reply=?,ec_reply_time=? where ec_id=?";
			try {
				pre = conn.prepareStatement(sql);
				pre.setString(1,ea.getEc_reply());
				pre.setDate(2,ea.getEc_reply_time());
				pre.setInt(3,ea.getEc_id());
				
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
				public static List<EASYBUY_COMMENT> FenAll(int start,int end)
				{
					List<EASYBUY_COMMENT> li = new ArrayList<EASYBUY_COMMENT>();
					conn = baseDao.getconn();
					sql="select * from(select rownum r,s.* from(select * from " +
							"EASYBUY_COMMENT order by ec_id asc)s)m where m.r " +
							"between ? and ?";
					try {
						pre = conn.prepareStatement(sql);
						pre.setInt(1,start);
						pre.setInt(2,end);
						res = pre.executeQuery();
						while(res.next())
						{
							//获取值
							EASYBUY_COMMENT a = new EASYBUY_COMMENT(res.getInt("ec_id"),res.getString("ec_content"),res.getDate("ec_create_time"),
									res.getString("ec_reply"),res.getDate("ec_reply_time"),res.getString("ec_nick_name"));
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
				
				//新增
				public static int Add(EASYBUY_COMMENT a)
				{
					int coest = 0;
					conn = baseDao.getconn();
					sql="insert into EASYBUY_COMMENT values(seq_oo.nextval,?,?,?,?,?)";
					try {
						pre = conn.prepareStatement(sql);
						pre.setString(1,a.getEc_content());
						pre.setDate(2,a.getEc_create_time());
						pre.setString(3,a.getEc_reply());
						pre.setDate(4,a.getEc_reply_time());
						pre.setString(5,a.getEc_nick_name());
					
						coest = pre.executeUpdate();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						baseDao.closeAll(conn, pre, res);
					}
					return coest;
				}
}

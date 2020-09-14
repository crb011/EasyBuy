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
	//����ȫ�ֱ���
		private static Connection conn = null;
		private static PreparedStatement pre = null;
		private static ResultSet res = null;
		private static String sql = null;
		
		//��ѯ����ע����û�
		public static List<EASYBUY_ORDER> findAll()
		{
			List<EASYBUY_ORDER> li = new ArrayList<EASYBUY_ORDER>();
			EASYBUY_ORDER a = null;
			conn = baseDao.getconn();
			//�Ȳ�ѯ���У��Ȼ��ٵ���ȥ���е�һЩ����
			sql="select * from EASYBUY_ORDER";
			try {
				pre=conn.prepareStatement(sql);
				res = pre.executeQuery();
				while(res.next())
				{
					a = new EASYBUY_ORDER(res.getInt("eo_id"),res.getString("eo_user_id"),res.getString("eo_user_name"),
							res.getString("eo_user_tel"),res.getString("eo_user_address"),res.getInt("eo_cost"),
							res.getDate("eo_create_time"),res.getInt("eo_status"),res.getInt("eo_type"));
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
		
		//ɾ��
		public static int del(int eo_id)
		{	
			int a = 0;
			conn = baseDao.getconn();
			//�Ȳ�ѯ���У��Ȼ��ٵ���ȥ���е�һЩ����
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
		
		//����ID��ѯ
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
				
				//�޸�
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
				//�������ƻ�͸�id��ѯ
				public static List<EASYBUY_ORDER> findByni(String eo_user_id,String eo_user_name)
				{
					List<EASYBUY_ORDER> li = new ArrayList<EASYBUY_ORDER>();
					conn = baseDao.getconn();
					//��Ϊ��ʱ
					sql = "select * from EASYBUY_ORDER where 1=1";//1=1Ϊturn
					
					//eo_user_id��Ϊ��
					if(eo_user_id!="")
					{
						sql=sql+"and eo_user_id=?";
					}
					//eo_user_name��Ϊ��
					if(eo_user_name!="")
					{
						sql=sql+"and eo_user_name=?";
					}
					try {
						pre = conn.prepareStatement(sql);
						//������λ�ø�ֵ
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
				//��ҳ��ѯ
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
							//��ȡֵ
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
				//���ݹ��ﳵ���û���Ϣ������
				public static int add(EASYBUY_SHOPPING eas,EASYBUY_USER ea)
				{
					int count = 0;
					conn = baseDao.getconn();
					sql = "insert into EASYBUY_ORDER values(dingdan.nextval,?,?,?,?,?,?,?,?)";
					
					try {
						pre = conn.prepareStatement(sql);
						pre.setInt(1,eas.getEOD_ID());//��ȡ����ID
						pre.setString(2,ea.getEu_user_name());//��ȡ�û������е��û���
						pre.setString(3,ea.getEu_mobile());//��ȡ�û������еĵ绰
						pre.setString(4,ea.getEu_address());//��ȡ�û������еĵ�ַ
						pre.setDouble(5,eas.getEOD_COST());//��ȡ�۸�
						pre.setDate(6,ea.getEu_birthday());//��ȡ�û������е�����
						pre.setInt(7,1);//����״̬
						pre.setInt(8,2);//���ʽ
		
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

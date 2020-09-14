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
	//����ȫ�ֱ���
	private static Connection conn = null;
	private static PreparedStatement pre = null;
	private static ResultSet res = null;
	private static String sql = null;
	//��ѯ
	public static List<EASYBUY_SHOPPING> FindAll()//����Ϊ�û����е��û�����
	{
		List<EASYBUY_SHOPPING> li = new ArrayList<EASYBUY_SHOPPING>();
		conn = baseDao.getconn();
		sql = "select * from EASYBUY_SHOPPING";//�ж��û����Ƶ���ȡ�����û��˺�
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
	//�����û�����Ʒ�������
		public static int add(EASYBUY_USER ea,EASYBUY_PRODUCT eas)
		{
			int count = 0;
			conn = baseDao.getconn();
			sql = "insert into EASYBUY_SHOPPING values(seq_eod_id.nextval,?,?,?,?,?)";
			
			try {
				pre = conn.prepareStatement(sql);
				pre.setString(1,ea.getEu_user_name());//��ȡ�û���
				pre.setInt(2,eas.getEp_id());//��ȡ��Ʒid
				pre.setString(3,eas.getEp_file_name());//��ȡ��ƷͼƬ
				pre.setString(4,eas.getEp_name());//��ȡ��Ʒ����
				pre.setDouble(5,eas.getEp_price());//��ȡ��Ʒ�۸�
				
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
		
		//��ѯ���ﳵ�������û��ǳƣ�
		public static List<EASYBUY_SHOPPING> Find(String ep_user_name)//����Ϊ�û����е��û�����
		{
			List<EASYBUY_SHOPPING> li = new ArrayList<EASYBUY_SHOPPING>();
			conn = baseDao.getconn();
			sql = "select * from EASYBUY_SHOPPING where EO_USERNAME=?";//�ж��û����Ƶ���ȡ�����û��˺�
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
		//ɾ��
		public static int del(int EOD_ID)
		{	
			int a = 0;
			conn = baseDao.getconn();
			//�Ȳ�ѯ���У��Ȼ��ٵ���ȥ���е�һЩ����
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
	//�޸�
}

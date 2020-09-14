package indi.crb.Easybuy.eitity;

import java.sql.Date;
//前台登录注册表
//后台用户管理页
public class EASYBUY_USER {
		private String eu_user_id; //登录名
		private String eu_user_name; //用户名
		private String eu_password; //密码
		private String eu_sex; //性别
		private Date eu_birthday; //生日
		private String eu_identity_code;//身份证
		private String eu_email; //邮箱
		private String eu_mobile; //电话
		private String eu_address; //地址
		private int eu_status; //用户权限
		
		public String getEu_user_id() {
			return eu_user_id;
		}
		public void setEu_user_id(String eu_user_id) {
			this.eu_user_id = eu_user_id;
		}
		public String getEu_user_name() {
			return eu_user_name;
		}
		public void setEu_user_name(String eu_user_name) {
			this.eu_user_name = eu_user_name;
		}
		public String getEu_password() {
			return eu_password;
		}
		public void setEu_password(String eu_password) {
			this.eu_password = eu_password;
		}
		public String getEu_sex() {
			return eu_sex;
		}
		public void setEu_sex(String eu_sex) {
			this.eu_sex = eu_sex;
		}
		public Date getEu_birthday() {
			return eu_birthday;
		}
		public void setEu_birthday(Date eu_birthday) {
			this.eu_birthday = eu_birthday;
		}
		public String getEu_identity_code() {
			return eu_identity_code;
		}
		public void setEu_identity_code(String eu_identity_code) {
			this.eu_identity_code = eu_identity_code;
		}
		public String getEu_email() {
			return eu_email;
		}
		public void setEu_email(String eu_email) {
			this.eu_email = eu_email;
		}
		public String getEu_mobile() {
			return eu_mobile;
		}
		public void setEu_mobile(String eu_mobile) {
			this.eu_mobile = eu_mobile;
		}
		public String getEu_address() {
			return eu_address;
		}
		public void setEu_address(String eu_address) {
			this.eu_address = eu_address;
		}
		public int getEu_status() {
			return eu_status;
		}
		public void setEu_status(int eu_status) {
			this.eu_status = eu_status;
		}
		public EASYBUY_USER(String eu_user_id, String eu_user_name,
				String eu_password, String eu_sex, Date eu_birthday,
				String eu_identity_code, String eu_email, String eu_mobile,
				String eu_address, int eu_status) {
			super();
			this.eu_user_id = eu_user_id;
			this.eu_user_name = eu_user_name;
			this.eu_password = eu_password;
			this.eu_sex = eu_sex;
			this.eu_birthday = eu_birthday;
			this.eu_identity_code = eu_identity_code;
			this.eu_email = eu_email;
			this.eu_mobile = eu_mobile;
			this.eu_address = eu_address;
			this.eu_status = eu_status;
		}
		public EASYBUY_USER(String eu_user_name, String eu_password,
				String eu_sex, Date eu_birthday, String eu_identity_code,
				String eu_email, String eu_mobile, String eu_address,
				int eu_status) {
			super();
			this.eu_user_name = eu_user_name;
			this.eu_password = eu_password;
			this.eu_sex = eu_sex;
			this.eu_birthday = eu_birthday;
			this.eu_identity_code = eu_identity_code;
			this.eu_email = eu_email;
			this.eu_mobile = eu_mobile;
			this.eu_address = eu_address;
			this.eu_status = eu_status;
		}
		public EASYBUY_USER() {
			super();
		}
}

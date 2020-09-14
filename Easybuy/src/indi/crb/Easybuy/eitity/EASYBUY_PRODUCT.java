package indi.crb.Easybuy.eitity;
//商品信息表---后台商品管理
public class EASYBUY_PRODUCT {
		private int ep_id;
		private String ep_name;
		private String ep_description;
		private double ep_price;
		private int ep_stock;
		private int epc_child_id;
		private String ep_file_name;
		
		//重写equals方法，判断二个值相等
		public boolean equals(Object obj) {
			EASYBUY_PRODUCT ea =(EASYBUY_PRODUCT)obj;
			return this.ep_id == ea.ep_id;
		}
		
		public int getEp_id() {
			return ep_id;
		}
		public void setEp_id(int ep_id) {
			this.ep_id = ep_id;
		}
		public String getEp_name() {
			return ep_name;
		}
		public void setEp_name(String ep_name) {
			this.ep_name = ep_name;
		}
		public String getEp_description() {
			return ep_description;
		}
		public void setEp_description(String ep_description) {
			this.ep_description = ep_description;
		}
		public double getEp_price() {
			return ep_price;
		}
		public void setEp_price(double ep_price) {
			this.ep_price = ep_price;
		}
		public int getEp_stock() {
			return ep_stock;
		}
		public void setEp_stock(int ep_stock) {
			this.ep_stock = ep_stock;
		}
		public int getEp_child_id() {
			return epc_child_id;
		}
		public void setEp_child_id(int epc_child_id) {
			this.epc_child_id = epc_child_id;
		}
		public String getEp_file_name() {
			return ep_file_name;
		}
		public void setEp_file_name(String ep_file_name) {
			this.ep_file_name = ep_file_name;
		}
		public EASYBUY_PRODUCT(int ep_id, String ep_name,
				String ep_description, double ep_price, int ep_stock,
				int epc_child_id, String ep_file_name) {
			super();
			this.ep_id = ep_id;
			this.ep_name = ep_name;
			this.ep_description = ep_description;
			this.ep_price = ep_price;
			this.ep_stock = ep_stock;
			this.epc_child_id = epc_child_id;
			this.ep_file_name = ep_file_name;
		}
		public EASYBUY_PRODUCT(String ep_name, String ep_description,
				double ep_price, int ep_stock, int epc_child_id,
				String ep_file_name) {
			super();
			this.ep_name = ep_name;
			this.ep_description = ep_description;
			this.ep_price = ep_price;
			this.ep_stock = ep_stock;
			this.epc_child_id = epc_child_id;
			this.ep_file_name = ep_file_name;
		}
		public EASYBUY_PRODUCT() {
			super();
		}
		
		
}

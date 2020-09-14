package indi.crb.Easybuy.eitity;

public class EASYBUY_SHOPPING {
		private int EOD_ID;
		private String EO_USERNAME;//用户账号：ID
		private int EP_ID;//商品ID
		private String EP_FILE_NAME;//商品图片
		private String EP_NAME;//商品名称
		private double EOD_COST;//此商品的总价钱
		public int getEOD_ID() {
			return EOD_ID;
		}
		public void setEOD_ID(int eOD_ID) {
			EOD_ID = eOD_ID;
		}
		public String getEO_USERNAME() {
			return EO_USERNAME;
		}
		public void setEO_USERNAME(String eO_USERNAME) {
			EO_USERNAME = eO_USERNAME;
		}
		public int getEP_ID() {
			return EP_ID;
		}
		public void setEP_ID(int eP_ID) {
			EP_ID = eP_ID;
		}
		public String getEP_FILE_NAME() {
			return EP_FILE_NAME;
		}
		public void setEP_FILE_NAME(String eP_FILE_NAME) {
			EP_FILE_NAME = eP_FILE_NAME;
		}
		public String getEP_NAME() {
			return EP_NAME;
		}
		public void setEP_NAME(String eP_NAME) {
			EP_NAME = eP_NAME;
		}
		public double getEOD_COST() {
			return EOD_COST;
		}
		public void setEOD_COST(double eOD_COST) {
			EOD_COST = eOD_COST;
		}
		public EASYBUY_SHOPPING(int eOD_ID, String eO_USERNAME, int eP_ID,
				String eP_FILE_NAME, String eP_NAME, double eOD_COST) {
			super();
			EOD_ID = eOD_ID;
			EO_USERNAME = eO_USERNAME;
			EP_ID = eP_ID;
			EP_FILE_NAME = eP_FILE_NAME;
			EP_NAME = eP_NAME;
			EOD_COST = eOD_COST;
		}
		public EASYBUY_SHOPPING(String eO_USERNAME, int eP_ID,
				String eP_FILE_NAME, String eP_NAME, double eOD_COST) {
			super();
			EO_USERNAME = eO_USERNAME;
			EP_ID = eP_ID;
			EP_FILE_NAME = eP_FILE_NAME;
			EP_NAME = eP_NAME;
			EOD_COST = eOD_COST;
		}
		public EASYBUY_SHOPPING() {
			super();
		}
		
}

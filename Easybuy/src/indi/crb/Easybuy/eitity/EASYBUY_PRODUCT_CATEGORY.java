package indi.crb.Easybuy.eitity;
//商品分类表--后台分类管理
public class EASYBUY_PRODUCT_CATEGORY {
			private int epc_id;
			private String epc_name;
			private int epc_parent_id;
			public EASYBUY_PRODUCT_CATEGORY(int epc_id, String epc_name,
					int epc_parent_id) {
				super();
				this.epc_id = epc_id;
				this.epc_name = epc_name;
				this.epc_parent_id = epc_parent_id;
			}
			public EASYBUY_PRODUCT_CATEGORY(String epc_name, int epc_parent_id) {
				super();
				this.epc_name = epc_name;
				this.epc_parent_id = epc_parent_id;
			}
			public EASYBUY_PRODUCT_CATEGORY() {
				super();
			}
			public int getEpc_id() {
				return epc_id;
			}
			public void setEpc_id(int epc_id) {
				this.epc_id = epc_id;
			}
			public String getEpc_name() {
				return epc_name;
			}
			public void setEpc_name(String epc_name) {
				this.epc_name = epc_name;
			}
			public int getEpc_parent_id() {
				return epc_parent_id;
			}
			public void setEpc_parent_id(int epc_parent_id) {
				this.epc_parent_id = epc_parent_id;
			}
}

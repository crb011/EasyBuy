package indi.crb.Easybuy.eitity;

import java.sql.Date;

//新闻表---后台新闻管理
public class EASYBUY_NEWS {  
	private int en_id;
	private String en_title;
	private String en_content;
	private Date en_create_time;
	public int getEn_id() {
		return en_id;
	}
	public void setEn_id(int en_id) {
		this.en_id = en_id;
	}
	public String getEn_title() {
		return en_title;
	}
	public void setEn_title(String en_title) {
		this.en_title = en_title;
	}
	public String getEn_content() {
		return en_content;
	}
	public void setEn_content(String en_content) {
		this.en_content = en_content;
	}
	public Date getEn_create_time() {
		return en_create_time;
	}
	public void setEn_create_time(Date en_create_time) {
		this.en_create_time = en_create_time;
	}
	public EASYBUY_NEWS(int en_id, String en_title, String en_content,
			Date en_create_time) {
		super();
		this.en_id = en_id;
		this.en_title = en_title;
		this.en_content = en_content;
		this.en_create_time = en_create_time;
	}
	public EASYBUY_NEWS(String en_title, String en_content, Date en_create_time) {
		super();
		this.en_title = en_title;
		this.en_content = en_content;
		this.en_create_time = en_create_time;
	}
	public EASYBUY_NEWS() {
		super();
	}
	
	
	
}
	
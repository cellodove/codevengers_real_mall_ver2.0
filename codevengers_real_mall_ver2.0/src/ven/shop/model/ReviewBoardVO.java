package ven.shop.model;

import java.sql.Date;

public class ReviewBoardVO {
	
	private int rbrd_num;
	private String mem_id;
	private String rbrd_title;
	private String rbrd_passwd;
	private String rbrd_content;
	private String rbrd_file;
	private Date rbrd_date;
	
	public int getRbrd_num() {
		return rbrd_num;
	}
	public void setRbrd_num(int rbrd_num) {
		this.rbrd_num = rbrd_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getRbrd_title() {
		return rbrd_title;
	}
	public void setRbrd_title(String rbrd_title) {
		this.rbrd_title = rbrd_title;
	}
	public String getRbrd_passwd() {
		return rbrd_passwd;
	}
	public void setRbrd_passwd(String rbrd_passwd) {
		this.rbrd_passwd = rbrd_passwd;
	}
	public String getRbrd_content() {
		return rbrd_content;
	}
	public void setRbrd_content(String rbrd_content) {
		this.rbrd_content = rbrd_content;
	}
	public String getRbrd_file() {
		return rbrd_file;
	}
	public void setRbrd_file(String rbrd_file) {
		this.rbrd_file = rbrd_file;
	}
	public Date getRbrd_date() {
		return rbrd_date;
	}
	public void setRbrd_date(Date rbrd_date) {
		this.rbrd_date = rbrd_date;
	}

}

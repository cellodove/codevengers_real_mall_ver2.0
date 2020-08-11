package ven.shop.model;

import java.sql.Date;

public class QnABoardVO {
	
	private int qbrd_num;
	private String mem_id;
	private String qbrd_title;
	private String qbrd_passwd;
	private String qbrd_content;
	private String qbrd_file;
	private Date qbrd_date;
	
	public int getQbrd_num() {
		return qbrd_num;
	}
	public void setQbrd_num(int qbrd_num) {
		this.qbrd_num = qbrd_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getQbrd_title() {
		return qbrd_title;
	}
	public void setQbrd_title(String qbrd_title) {
		this.qbrd_title = qbrd_title;
	}
	public String getQbrd_passwd() {
		return qbrd_passwd;
	}
	public void setQbrd_passwd(String qbrd_passwd) {
		this.qbrd_passwd = qbrd_passwd;
	}
	public String getQbrd_content() {
		return qbrd_content;
	}
	public void setQbrd_content(String qbrd_content) {
		this.qbrd_content = qbrd_content;
	}
	public String getQbrd_file() {
		return qbrd_file;
	}
	public void setQbrd_file(String qbrd_file) {
		this.qbrd_file = qbrd_file;
	}
	public Date getQbrd_date() {
		return qbrd_date;
	}
	public void setQbrd_date(Date qbrd_date) {
		this.qbrd_date = qbrd_date;
	}

}

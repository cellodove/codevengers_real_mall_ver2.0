package ven.shop.model;

import java.sql.Date;

public class MallOrderVO {
	
	private int cor_num;
	private String mem_id;
	private int item_num;
	private String mem_name;
	private String mem_email;
	private int mem_tel;
	private int mem_zipcode;
	private String mem_fulladress;
	private String cor_memo;
	private int cor_total_money;
	private int cor_count;
	private String cor_pay_type;
	private String cor_pay_bank;
	private Date cor_datetime;
	private String cor_status;
	
	public int getCor_num() {
		return cor_num;
	}
	public void setCor_num(int cor_num) {
		this.cor_num = cor_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public int getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(int mem_tel) {
		this.mem_tel = mem_tel;
	}
	public int getMem_zipcode() {
		return mem_zipcode;
	}
	public void setMem_zipcode(int mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}
	public String getMem_fulladress() {
		return mem_fulladress;
	}
	public void setMem_fulladress(String mem_fulladress) {
		this.mem_fulladress = mem_fulladress;
	}
	public String getCor_memo() {
		return cor_memo;
	}
	public void setCor_memo(String cor_memo) {
		this.cor_memo = cor_memo;
	}
	public int getCor_total_money() {
		return cor_total_money;
	}
	public void setCor_total_money(int cor_total_money) {
		this.cor_total_money = cor_total_money;
	}
	public int getCor_count() {
		return cor_count;
	}
	public void setCor_count(int cor_count) {
		this.cor_count = cor_count;
	}
	public String getCor_pay_type() {
		return cor_pay_type;
	}
	public void setCor_pay_type(String cor_pay_type) {
		this.cor_pay_type = cor_pay_type;
	}
	public String getCor_pay_bank() {
		return cor_pay_bank;
	}
	public void setCor_pay_bank(String cor_pay_bank) {
		this.cor_pay_bank = cor_pay_bank;
	}
	public Date getCor_datetime() {
		return cor_datetime;
	}
	public void setCor_datetime(Date cor_datetime) {
		this.cor_datetime = cor_datetime;
	}
	public String getCor_status() {
		return cor_status;
	}
	public void setCor_status(String cor_status) {
		this.cor_status = cor_status;
	}
}

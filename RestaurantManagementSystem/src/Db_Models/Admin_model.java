package Db_Models;

import java.util.Date;

public class Admin_model {
	String customer_name;
	String delivery_boy;
	Date date;
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public void setDelivery_boy(String delivery_boy) {
		this.delivery_boy = delivery_boy;
	}
	public String getDelivery_boy() {
		return delivery_boy;
	}
	public String getCustomer_name() {
		return customer_name;
	}

}

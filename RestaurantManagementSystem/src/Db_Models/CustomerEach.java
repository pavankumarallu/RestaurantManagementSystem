package Db_Models;

import java.util.Date;

public class CustomerEach {
	String item_name;
	int quantity;
	double item_price;
	Date date;
	
	public void setitem_name(String item_name) {
		this.item_name = item_name;
	}
	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	public void setitem_price(double item_price) {
		this.item_price = item_price;
	}
	public String getitem_name() {
		return item_name;
	}
	public double getItem_price() {
		return item_price;
	}
	public int getquantity() {
		return quantity;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
}

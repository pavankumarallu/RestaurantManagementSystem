package Db_Models;

public class MenuItems {
	private String item_name;
	private String review;
	private int quantity;
	private double item_price;
	
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}
	public String getItem_name() {
		return item_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getReview() {
		return review;
	}
	public double getItem_price() {
		return item_price;
	}
}

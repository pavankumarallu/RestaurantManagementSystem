package Db_Models;

public class BillModel {
	String itemname;
	int quantity;
	Double rate;
	public String getItemname() {
		return itemname;
	}
	public int getQuantity() {
		return quantity;
	}
	public Double getRate() {
		return rate;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public void setQuantity(int quan) {
		this.quantity = quan;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	

}

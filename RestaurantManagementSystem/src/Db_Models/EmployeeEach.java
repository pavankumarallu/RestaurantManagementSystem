package Db_Models;

import java.util.Date;

public class EmployeeEach {
	String menu_item;
	String cust_ph_no;
	int quantity;
	String customer_name;
	String Address;
	String pincode;
	Date date;
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public void setmenu_item(String name)
	{
		menu_item = name;
	}
	public void setcust_ph_no(String number)
	{
		cust_ph_no = number;
	}
	public void setquantity(int quantity)
	{
		this.quantity = quantity;
	}
	public void setcustomer_name(String name)
	{
		customer_name = name;
	}
	
	public String getmenu_item()
	{
		return menu_item;
	}
	public String getcust_ph_no()
	{
		return cust_ph_no;
	}
	public int getquantity()
	{
		return quantity;
	}
	public String getcustomer_name()
	{
		return customer_name;
	}
	
}

package db_Connection_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Db_Models.Admin_model;
import Db_Models.EmployeeEach;

public class Admin_db {
	static String url = "jdbc:mysql://localhost:3306/restaurantmanagementsystem";
	static String username = "root";
	static String password = "pavan@123";
	Connection connection;
	public Admin_db() {
		try {
			connection = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<Admin_model> getorders() {
		ArrayList<Admin_model> amList = new ArrayList<Admin_model>();
		String query = "SELECT * FROM admin";
		java.sql.Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				Admin_model am = new Admin_model();
				am.setCustomer_name(rs.getString("Customername"));
				am.setItemname(rs.getString("menuitem"));
				am.setDate(rs.getDate("date"));
				am.setQuantity(rs.getInt("quantity"));
				am.setDelivery_boy(rs.getString("Delivaryboy"));
				am.setDelivaryStatus(rs.getBoolean("delivaryStatus"));
				amList.add(am);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return amList;
		
		
	}
	
	public void assignOrders(String customer_name, String deliveryboy,Date date ,String itemname,int quantity) {
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		String query = "UPDATE admin SET Delivaryboy='"+deliveryboy+"' WHERE Customername = '"+customer_name+"' AND menuitem = '"+itemname+"' AND date= '"+sqldate+"'";
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.execute();
			JOptionPane.showMessageDialog(null, "Order Assigned");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmployeeEach eee = new EmployeeEach();
		eee.setcust_ph_no(getPhoneNumber(customer_name));
		eee.setcustomer_name(customer_name);
		eee.setmenu_item(itemname);
		eee.setquantity(quantity);
		assigntoEmploy(eee,deliveryboy);
		OrderStatus(customer_name,deliveryboy,itemname,sqldate);
		
	}
	
	private void OrderStatus(String customer_name, String deliveryboy, String itemname, java.sql.Date sqldate) {
		String query = "UPDATE "+customer_name+" SET orderStatus=True , Delivaryboy='"+deliveryboy+"' WHERE itemname = '"+itemname+"' AND date= '"+sqldate+"'";
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String getPhoneNumber(String name)
	{
		String query = "SELECT Phonenumber FROM Userdetails WHERE Username='"+name+"'";
		Statement stmt;
		String ph = "";
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
			ph = rs.getString("Phonenumber");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		return ph;
	}
	
	private void assigntoEmploy(EmployeeEach eee,String delivaryboy) {
		String query = "INSERT INTO "+delivaryboy+"(customername,customerphone,itemname,date,itemquantity) VALUES(?,?,?,?,?)";
		Date date = new Date();
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.setString(1,eee.getcustomer_name());
			pa.setString(2, eee.getcust_ph_no());
			pa.setString(3, eee.getmenu_item());
			pa.setDate(4, sqldate);
			pa.setInt(5, eee.getquantity());
			pa.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
		
	}

}

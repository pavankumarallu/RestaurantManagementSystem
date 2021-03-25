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
		String query = "SELECT * FROM admin Where delivaryStatus = False";
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
		String query = "UPDATE admin SET Delivaryboy='"+deliveryboy+"' ,OrderStatus=True  WHERE Customername = '"+customer_name+"' AND menuitem = '"+itemname+"' AND date= '"+sqldate+"'";
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.execute();
			JOptionPane.showMessageDialog(null, "Order Assigned");
			
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
	
}

package db_Connection_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Db_Models.EmployeeEach;
import Db_Models.MenuItems;

public class Employee_db {
	static String url = "jdbc:mysql://localhost:3306/restaurantmanagementsystem";
	static String username = "root";
	static String password = "pavan@123";
	Connection connection;
	String Employeename;
	public Employee_db(String name) {
		try {
			connection = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.Employeename = name;
	}
	
	public ArrayList<EmployeeEach> getmyOrders() {
		ArrayList<EmployeeEach> eelist = new ArrayList<EmployeeEach>();
		String query = "Select * from admin WHERE Delivaryboy = '"+Employeename+"' AND delivaryStatus = FALSE";
		
		java.sql.Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				EmployeeEach ee = new EmployeeEach();
				ee.setcustomer_name(rs.getString("Customername"));
				ee.setAddress(getAddress(rs.getString("Customername")));
				ee.setcust_ph_no(getPhone(rs.getString("Customername")));
				ee.setPincode(getPin(rs.getString("Customername")));
				ee.setmenu_item(rs.getString("menuitem"));
				ee.setquantity(rs.getInt("quantity"));
				eelist.add(ee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eelist;
		
		

	}


	public void updatedeliverystatus(String custname,String itemname) {
		String query = "UPDATE admin SET delivaryStatus = True WHERE menuitem= '"+itemname+"' AND Delivaryboy='"+Employeename+"' AND Customername = '"+custname+"'";
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private String getAddress(String custname)
	{
		String query = "Select * from userdetails Where Username = '"+custname+"'";
		java.sql.Statement st;
		String Add = "";
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				Add = rs.getString("Address");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Add;
		
	}
	private String getPhone(String custname)
	{
		String query = "Select * from userdetails Where Username = '"+custname+"'";
		java.sql.Statement st;
		String Add = "";
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				Add = rs.getString("Phonenumber");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Add;
		
	}
	private String getPin(String custname)
	{
		String query = "Select * from userdetails Where Username = '"+custname+"'";
		java.sql.Statement st;
		String Add = "";
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				Add = rs.getString("pincode");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Add;
		
	}

	
	
}

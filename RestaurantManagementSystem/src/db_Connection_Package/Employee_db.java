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
		String query = "Select * from "+Employeename+"";
		
		java.sql.Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				EmployeeEach ee = new EmployeeEach();
				ee.setcustomer_name(rs.getString("customername"));
				ee.setcust_ph_no(rs.getString("customerphone"));
				ee.setmenu_item(rs.getString("itemname"));
				ee.setquantity(rs.getInt("itemquantity"));
				eelist.add(ee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eelist;
		
		

	}

	public void removedb(String itemname, String phone, String custname) {
		String query = "DELETE from "+ Employeename+" where itemname = '"+itemname+"' AND customername= '"+custname+"'";
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.execute();
			JOptionPane.showMessageDialog(null, "Delivered");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		removefromAdmin(itemname,custname);
		updatedeliverystatus(custname,itemname);
		
	}

	private void updatedeliverystatus(String custname,String itemname) {
		String query = "UPDATE "+custname+" SET Deliverystatus = True WHERE itemname= '"+itemname+"' AND Delivaryboy='"+Employeename+"'";
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void removefromAdmin(String itemname, String custname) {
		String query = "DELETE from admin where menuitem = '"+itemname+"' AND Customername= '"+custname+"'";
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package db_Connection_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}

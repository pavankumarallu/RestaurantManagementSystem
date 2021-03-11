package db_Connection_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import Db_Models.CustomerEach;

public class Customerordersdb {
	static String url = "jdbc:mysql://localhost:3306/restaurantmanagementsystem";
	static String username = "root";
	static String password = "pavan@123";
	Connection connection;
	String Customername;
	
	public Customerordersdb(String name) {
		try {
			connection = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.Customername = name;
	}
	
	public void MakeOrder(CustomerEach ce)
	{
		String query = "INSERT INTO "+Customername+"(itemname,date,itemrate,itemquantity) VALUES(?,?,?,?)";
		Date date = new Date();
		java.sql.Date sqldate;
		sqldate = new java.sql.Date(date.getTime());
	}
	

}

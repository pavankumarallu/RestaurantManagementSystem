package db_Connection_Package;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class UserConnections {
	static String url = "jdbc:mysql://localhost:3306/restaurantmanagementsystem";
	static String username = "root";
	static String password = "pavan@123";
	Connection connection;
	
	public UserConnections() {
		// TODO Auto-generated constructor stub
	
		try {
			connection = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void RegisterUser(String Username,String Password,String Phonenumber)
	{
		String query = "INSERT INTO userdetails(Username,Password,Phonenumber) VALUES(?,?,?)";
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.setString(1,Username);
			pa.setString(2,Password);
			pa.setString(3,Phonenumber);
			Create_Table(Username);
			int i = pa.executeUpdate();
			if (i>0) {
				JOptionPane.showMessageDialog(null, "REGISTERED");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}


	private void Create_Table(String Username) {
		// TODO Auto-generated method stub
		String query = "CREATE TABLE "+Username+"(Id int(20) primary key auto_increment,itemname varchar(200),date date,itemrate double,itemquantity int)";
		Statement stmt;
		try {
			stmt = connection.createStatement();
			stmt.execute(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
		
	}



}

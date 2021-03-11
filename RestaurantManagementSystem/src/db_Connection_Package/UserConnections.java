package db_Connection_Package;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import Db_Models.Userdetails;

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
	
	
	public void RegisterUser(Userdetails user)
	{
		String query = "INSERT INTO userdetails(Username,Password,Phonenumber) VALUES(?,?,?)";
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.setString(1,user.getName());
			pa.setString(2,user.getPassword());
			pa.setString(3,user.getPhoneNo());
			Create_Table(user.getName());
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
	public boolean LoginUser(Userdetails user)
	{
		String query = "SELECT Username,Password FROM userdetails WHERE Username = '"+user.getName()+"' and Password = '"+user.getPassword()+"'";
		
		java.sql.Statement st;
		try {
			st = connection.createStatement();
			ResultSet set = st.executeQuery(query);
			if (!set.next()) {
				return false;
			}
			else
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	public ArrayList<Userdetails> getUsers()
	{
		ArrayList<Userdetails> usd = new ArrayList<Userdetails>();
		String query = "SELECT * FROM userdetails";
		java.sql.Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				Userdetails m = new Userdetails();
				m.setName(rs.getString("Username"));
				m.setPhoneNo(rs.getString("Phonenumber"));
				
				usd.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usd;
		
	}



}

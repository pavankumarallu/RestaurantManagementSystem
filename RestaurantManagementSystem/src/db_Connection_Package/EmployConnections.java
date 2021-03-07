package db_Connection_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Db_Models.Employdetail;
import Db_Models.Userdetails;

public class EmployConnections {
	
	static String url = "jdbc:mysql://localhost:3306/restaurantmanagementsystem";
	static String username = "root";
	static String password = "pavan@123";
	Connection connection;
	
	public EmployConnections() {
		try {
			connection = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void registerEmployes(Employdetail ed)
	{
		String query = "INSERT INTO emplydetails(employname,password,phonenumber) VALUES(?,?,?)";
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.setString(1,ed.getName());
			pa.setString(2,ed.getPassword());
			pa.setString(3,ed.getPhoneNo());
			Create_Table(ed.getName());
			int i = pa.executeUpdate();
			if (i>0) {
				JOptionPane.showMessageDialog(null, "REGISTERED");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}
	private void Create_Table(String name) {
		String query = "CREATE TABLE "+name+"(Id int(20) primary key auto_increment,customername varchar(200),customerphone varchar(200),itemname varchar(200),date date,itemquantity int)";
		try {
			Statement stmt = connection.createStatement();
			stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean EmplyeeLogin(Employdetail ed)
	{
		String query = "SELECT employname,password FROM emplydetails WHERE employname = '"+ed.getName()+"' and password = '"+ed.getPassword()+"'";
		
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
	public ArrayList<Employdetail> getEmploys()
	{
		ArrayList<Employdetail> usd = new ArrayList<Employdetail>();
		String query = "SELECT * FROM emplydetails";
		java.sql.Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				Employdetail m = new Employdetail();
				m.setName(rs.getString("employname"));
				m.setPhoneNo(rs.getString("phonenumber"));
				
				usd.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usd;
		
	}

}

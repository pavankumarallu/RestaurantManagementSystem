package db_Connection_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Db_Models.Admin_model;
import Db_Models.CustomerEach;
import Db_Models.EmployeeEach;
import Db_Models.MenuItems;

public class CustomerConnections {
	static String url = "jdbc:mysql://localhost:3306/restaurantmanagementsystem";
	static String username = "root";
	static String password = "pavan@123";
	Connection connection;
	String Customername;
	public CustomerConnections(String name) {
		try {
			connection = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.Customername = name;
	}
	public void MakeOrder(CustomerEach ce)
	{
		Date date = new Date();
		java.sql.Date sqldate;
		Admin_model am = new Admin_model();
		am.setItemrate(ce.getItem_price());
		am.setCustomer_name(Customername);
		am.setItemname(ce.getitem_name());
		am.setQuantity(ce.getquantity());
		addAdmin(am);
	}
	private void addAdmin(Admin_model am)
	{
		String query = "INSERT INTO admin(Customername,menuitem,date,quantity) VALUES(?,?,?,?)";
		Date date = new Date();
		java.sql.Date sqldate;
		sqldate = new java.sql.Date(date.getTime());
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.setString(1,am.getCustomer_name());
			pa.setString(2, am.getItemname());
			pa.setDate(3, sqldate);
			pa.setInt(4, am.getQuantity());
			pa.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<CustomerEach> getTrackdetails()
	{
		Date date = new Date();
		java.sql.Date sqldate= new java.sql.Date(date.getTime());
		ArrayList<CustomerEach>	celist = new ArrayList<CustomerEach>();
		String query = "SELECT * FROM admin WHERE date = '"+sqldate+"' AND Customername = '"+Customername+"'";
		java.sql.Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				CustomerEach m = new CustomerEach();
				m.setitem_name(rs.getString("menuitem"));
				m.setquantity(rs.getInt("quantity"));
				m.setDelivaryboy(rs.getString("Delivaryboy"));
				m.setOrderstatus(rs.getBoolean("OrderStatus"));
				m.setDelivaryStatus(rs.getBoolean("delivaryStatus"));
				celist.add(m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return celist;
		
	}
	public ArrayList<CustomerEach> getHistory()
	{
		ArrayList<CustomerEach>	celist = new ArrayList<CustomerEach>();
		String query = "SELECT * FROM admin WHERE Customername = '"+Customername+"'";
		java.sql.Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				CustomerEach m = new CustomerEach();
				m.setitem_name(rs.getString("menuitem"));
				m.setquantity(rs.getInt("quantity"));
				m.setDelivaryboy(rs.getString("Delivaryboy"));
				m.setOrderstatus(rs.getBoolean("OrderStatus"));
				m.setDelivaryStatus(rs.getBoolean("delivaryStatus"));
				celist.add(m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return celist;
		
	}
	public ArrayList<MenuItems> getmenuPref() throws SQLException
	{
		ArrayList<MenuItems> mi = new ArrayList<MenuItems>();
		String pref = getPref();
		String query;
		if (pref.equals("Veg")) {
			query = "SELECT * FROM menuitems WHERE type = 'Veg'";
		}
		else {
			query = "SELECT * FROM menuitems";
		}
		java.sql.Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			MenuItems m = new MenuItems();
			m.setItem_name(rs.getString("itemname"));
			m.setItem_price(rs.getDouble("itemprice"));
			m.setQuantity(rs.getInt("itemquantity"));
			m.setReview(rs.getString("itemreview"));
			mi.add(m);
		}
		return mi;
	}
	private String getPref() {
		String query = "SELECT * FROM userdetails WHERE Username = '"+Customername+"'";
		String pref = "";
		java.sql.Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				pref = rs.getString("Preferences");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pref;
		
	}
	

}

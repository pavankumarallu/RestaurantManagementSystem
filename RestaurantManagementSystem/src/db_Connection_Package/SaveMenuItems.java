package db_Connection_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Db_Models.MenuItems;

public class SaveMenuItems {

	static String url = "jdbc:mysql://localhost:3306/restaurantmanagementsystem";
	static String username = "root";
	static String password = "pavan@123";
	Connection connection;
	
	public SaveMenuItems() {
		try {
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setmenu(MenuItems mi)
	{
		String query = "INSERT INTO menuitems(itemname,itemPrice,itemquantity,itemreview,type) VALUES(?,?,?,?,?)";
		PreparedStatement pa;
		try {
			pa = connection.prepareStatement(query);
			pa.setString(1,mi.getItem_name());
			pa.setDouble(2, mi.getItem_price());
			pa.setInt(3, mi.getQuantity());
			pa.setString(4, mi.getReview());
			pa.setString(5, mi.getType());
			pa.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void deleteMenu(String Item_name) 
	{
		String query = "DELETE from menuitems where itemname = '"+Item_name+"'";
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.execute();
			JOptionPane.showMessageDialog(null, "deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<MenuItems> getmenu() throws SQLException
	{
		ArrayList<MenuItems> mi = new ArrayList<MenuItems>();
		String query = "SELECT * FROM menuitems";
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
	
	public double getpriceofItem(String itemname) {
		double price = 0;
		String query = "Select * from menuitems where itemname = '"+itemname+"'";
		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
			price = Double.parseDouble(rs.getString("itemPrice"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
		return price;
	}
}

package db_Connection_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Db_Models.SuggestionModel;

public class Suggestions_db {
	static String url = "jdbc:mysql://localhost:3306/restaurantmanagementsystem";
	static String username = "root";
	static String password = "pavan@123";
	Connection connection;
	public Suggestions_db() {
		try {
			connection = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setSuggestions(SuggestionModel sm)
	{
		String query = "INSERT INTO suggestions(Customername,suggestion,Rating) VALUES(?,?,?)";
		PreparedStatement pa;
		try {
			pa = connection.prepareStatement(query);
			pa.setString(1, sm.getCustomername());
			pa.setString(2, sm.getSuggestion());
			pa.setString(3, sm.getRating());
			pa.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<SuggestionModel> getSuggestions() {
		ArrayList<SuggestionModel> smlist = new ArrayList<SuggestionModel>();
		String query = "SELECT * FROM suggestions";
		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				SuggestionModel sm = new SuggestionModel();
				sm.setCustomername(rs.getString("Customername"));
				sm.setSuggestion(rs.getString("suggestion"));
				smlist.add(sm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
		return smlist;
		
		
	}

}

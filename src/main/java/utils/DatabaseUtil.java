package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtil {
	static Connection conn;
	
	public void getResults() throws SQLException {
		conn=DriverManager.getConnection("", "", "");
		PreparedStatement ps=conn.prepareStatement("Select * from db");
	}
	
	
}

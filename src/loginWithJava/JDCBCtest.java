package loginWithJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDCBCtest {

	public static void main(String[] args) {
	
		// Step 1. Get a connection
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=JST","root","voice008");
			
				if (conn!=null) {
					System.out.println("ok");
				} else {
					System.out.println("no");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

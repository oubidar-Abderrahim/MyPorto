package net.satityr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent" ;
		try {
			System.out.println("connecting to : " + jdbcUrl);
			
			@SuppressWarnings("unused")
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, user);
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}

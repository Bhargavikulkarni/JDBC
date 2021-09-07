package com.Assignment.JDBC;

import java.sql.*;

public class BatchProcessingExample {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Load and register is done");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=Dairymilk44@");
			con.setAutoCommit(false);
			System.out.println("2.Connection has been established");
			System.out.println("3.Creating Statement");
			Statement stmt = con.createStatement();
			stmt.addBatch("insert into accountdetails values(3,1234567,'Suchet',6000,'SuchetK','Suchet@123')");

			stmt.addBatch("insert into accountdetails values(4,45656,'Varun',25000,'VarunMP','Vmp@123')");
			System.out.println("4.Processing Statement");
			stmt.executeBatch();
			con.commit();
			con.close();
			System.out.println("5.Query Executed");
			System.out.println("");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				System.out.println("6.Connection is closed..");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
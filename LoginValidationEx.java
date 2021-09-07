package com.Assignment.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginValidationEx {

	public static void main(String[] args) {
		Connection con = null;
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Load and register is done");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=Dairymilk44@");
			System.out.println("2.Connection has been established");
			for (int passAttempts = 0; passAttempts < 3; passAttempts++) {
				count++;
				Scanner sc = new Scanner(System.in);

				System.out.println("Enter UserName:");
				String Name = sc.next();

				System.out.println("Enter Password:");
				String password = sc.next();

				PreparedStatement pst = con.prepareStatement("select * from Accountdetails where Name = ? and password = ?");
				pst.setString(1, Name);
				pst.setString(2, password);
				ResultSet rs = pst.executeQuery();
				System.out.println("Query Executed");
				System.out.println("Processing resulset");

				if (rs.next()) {
					System.out.println(rs.getInt(1) + " " + rs.getLong(2) + " " + rs.getString(3) + " "
							+ rs.getLong(4));
					break;
				} else {
					System.out.println("Wrong Credentials,Try again.....!!");
					if (count >= 3) {
						System.out.println("User is blocked");
						break;
					}
				}

			}

		} catch (

		ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				System.out.println("6.Close the Connection");
			} catch (SQLException e) {
					e.printStackTrace();
			}
		}

	}

}
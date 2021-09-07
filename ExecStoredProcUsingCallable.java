package com.Assignment.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ExecStoredProcUsingCallable {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Load and register is done");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=Dairymilk44@");
			System.out.println("2.Connection has been established");
			Scanner sc = new Scanner(System.in);
	          
		    System.out.println("Enter Id:");
			int Id = sc.nextInt();
			
			System.out.println("Enter UserName:");
			String Name = sc.next();
			
			System.out.println("Enter Password:");
			String password = sc.next();
			
			System.out.println("Enter AccHolderName:");
			String AccHolderName = sc.next();
			
			sc.nextLine();
			
			System.out.println("Enter Acc/No:");
			String Acc_No= sc.nextLine();
			
			System.out.println("Enter Balance");
			String balance = sc.nextLine();
			
			
			CallableStatement cst = con.prepareCall("call test.Accountdetails (?,?,?,?,?,?)");
			System.out.println("3.Statement has been created");

			cst.setInt(1, Id);
			cst.setString(2, Acc_No);
			cst.setString(3, AccHolderName);
			cst.setString(4, balance);
			cst.setString(5, Name);
			cst.setString(6, password);
			cst.execute();
	
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

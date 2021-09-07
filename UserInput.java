package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.print.attribute.standard.RequestingUserName;

public class UserInput {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Load and register is done");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=Dairymilk44@");
			System.out.println("2.Connection has been established");
			System.out.println("set the values");
			Scanner sc = new Scanner(System.in);
          
		    System.out.println("Enter Id:");
			int Id = sc.nextInt();
			
			System.out.println("Enter UserName:");
			String Name = sc.next();
			
			System.out.println("Enter Password:");
			String password = sc.next();
			
			System.out.println("Enter Phone_Number:");
			String Ph_No = sc.next();
			
			sc.nextLine();
			
			System.out.println("Enter Full_Nmae:");
			String fullname = sc.nextLine();
			
			System.out.println("Enter Address");
			String address = sc.nextLine();
			
			PreparedStatement pst = con.prepareStatement("Insert into user" + "(Id,Name,password,Ph_No,fullname,address)" + "values (?,?,?,?,?,?)");
		    System.out.println("3.Statement has been created");
			pst.setInt(1, Id);
			pst.setString(2, Name);
			pst.setString(3, password);
			pst.setString(4, Ph_No);
			pst.setString(5, fullname);
			pst.setString(6, address);
			pst.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
	}
}
package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserUpdate {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.Load and register is done");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=Dairymilk44@");
			System.out.println("2.Connection has been established");

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter UserName:");
			String Name = sc.next();

			System.out.println("Enter Password:");
			String password = sc.next();

			System.out.println("Enter update Address");
			String address = sc.next();
			PreparedStatement pst = con.prepareStatement("update user set address= ? where Name=? and password=? ");
			System.out.println("3. Statement has been created");

			pst.setString(2, Name);
			pst.setString(3, password);
			pst.setString(1, address);
			pst.execute();
			System.out.println("4.Query Executed");
			int row = pst.executeUpdate();
			if (row > 0) {
				System.out.println("record updated successfully");
			} else {
				System.out.println("record not found");
			}
		} catch (ClassNotFoundException e) {
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
package com.RegLogin.Example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("em");
		String password = request.getParameter("pw");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?", "root", "Dairymilk44@");
			PreparedStatement pst = con.prepareStatement("delete from userinfo where email =? and password=?");
			pst.setString(1, email);
			pst.setString(2, password);
			//pst.execute();
			int rowsDeleted = pst.executeUpdate();
			if (rowsDeleted > 0) {
				pw.print("User details are deleted");
			} else {
				pw.print("No result found");
			}
		} catch (ClassNotFoundException e) {
			pw.print("Deletion failed try again");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
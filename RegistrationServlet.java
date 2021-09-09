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

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String firstName = request.getParameter("fn");
		String lastName = request.getParameter("ln");
		String email = request.getParameter("em");
		String password = request.getParameter("pw");
		String phone = request.getParameter("ph");
		long phoneNumber = Long.parseLong(phone);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?", "root", "Dairymilk44@");
			PreparedStatement pst = con.prepareStatement("insert into userinfo values(?,?,?,?,?)");
			pst.setLong(1, phoneNumber);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setString(4, email);
			pst.setString(5, password);
			pst.execute();
			pw.print("Registration successful");
		} catch (ClassNotFoundException e) {
			pw.print("Registration failed try again");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
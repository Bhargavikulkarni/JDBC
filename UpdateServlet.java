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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("em");
		String phone = request.getParameter("phone");
		long phoneNumber = Long.parseLong(phone);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?", "root", "Dairymilk44@");
			PreparedStatement pst = con.prepareStatement("Update userinfo set phoneNumber =? where email=?");
			pst.setLong(1, phoneNumber);
			pst.setString(2, email);
			pst.execute();
			int row = pst.executeUpdate();
			if (row > 0) {
				pw.print("Record Updated successfully");
			} else {
				pw.print("Record not found");
			}
		} catch (ClassNotFoundException e) {
			pw.print("Update failed try again");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
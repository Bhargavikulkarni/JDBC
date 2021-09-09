package com.RegLogin.Example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("em");
		String password = request.getParameter("pw");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?", "root","Dairymilk44@");
				PreparedStatement pst = con.prepareStatement("select * from userinfo where email=? and password =?");
				pst.setString(1, email);
				pst.setString(2, password);
				Resultset rs =  (Resultset) pst.executeQuery();
				if( ((ResultSet) rs).next()) {
					pw.print("Login Successful");
				}else {
					pw.print("Login Failed, Try again...!");
				}
					} catch (SQLException e) {
				e.printStackTrace();
			}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}


	}



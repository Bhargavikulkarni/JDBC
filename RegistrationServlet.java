package com.bhargavi.hbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.*;
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
		String userName = request.getParameter("un");
		String password = request.getParameter("pw");
		String phone = request.getParameter("ph");
		String address = request.getParameter("addr");
		long phoneNumber = Long.parseLong(phone);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		AssignmentDTO dto = new AssignmentDTO();
        dto.setFirst_Name(firstName);
        dto.setUserName(userName);
        dto.setPassword(password);
        dto.setPhone(phone);
        dto.setAddress(address);
		
		manager.persist(dto);
	
		transaction.commit();
		manager.close();
		factory.close();
        pw.print("Registered successfully....");
	}

}

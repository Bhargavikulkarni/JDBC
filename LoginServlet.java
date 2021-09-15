package com.bhargavi.hbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String userName = request.getParameter("un");
		String password = request.getParameter("pw");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
		Query query = manager
				.createQuery("from AssignmentDTO where userName='" + userName + "' and password ='" + password + "'");
		try {
			AssignmentDTO dto = (AssignmentDTO) query.getSingleResult();

			pw.print(dto.getFirst_Name() + " " + dto.getPhone() + " " + dto.getAddress());
		} catch (NoResultException e) {

			pw.print("Login failed please try again");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
		manager.close();
		factory.close();
	}

}

package com.bhargavi.hbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			String userName = request.getParameter("un");
			String password = request.getParameter("pw");
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
			EntityManager manager =    factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
	     	Query query = manager
					.createQuery("delete from AssignmentDTO  where userName='" + userName + "' and password ='" + password + "'");
			AssignmentDTO dto = new AssignmentDTO();
			int rows = query.executeUpdate();
			if (rows>0) {
				pw.print("deleted Successfully....");
			} else {
				pw.print("delete failed please try again");
				RequestDispatcher rd = request.getRequestDispatcher("delete.html");
				rd.include(request, response);
			}
			transaction.commit();
			manager.close();
			factory.close();
			
		}

		
		}


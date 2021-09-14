package com.bhargavi.Assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bhargavi.hb.EmpDTO;

public class StudentDeleteDAO {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager =    factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
	 	transaction.begin();
		Query query = manager.createQuery("delete from StudentCreateDTO where sPer<50");
		int rows = query.executeUpdate();
		System.out.println("No of rows affected:"+" "+rows);
		transaction.commit();
	
	}
	}
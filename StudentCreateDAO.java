package com.bhargavi.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentCreateDAO {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager =    factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student name:");
		String sName = scanner.nextLine();
		
		System.out.println("Enter student stream:");
		String sStream = scanner.nextLine();
		
		System.out.println("Enter student Percentage:");
		Double sPer = scanner.nextDouble();
		
		System.out.println("Enter student Phone:");
		Integer sPhone = scanner.nextInt();
		
		System.out.println("Enter student Age:");
		Integer sAge = scanner.nextInt();
		
		scanner.nextLine();
		
		
		  System.out.println("Enter student Address:"); 
		  String sAddr = scanner.nextLine();
		 	
		StudentCreateDTO sdto = new StudentCreateDTO();
		sdto.setsName(sName);
		sdto.setsStream(sStream);
		sdto.setsPer(sPer);
		sdto.setsPhone(sPhone);
		sdto.setsAge(sAge);
		sdto.setsAddr(sAddr);
		manager.persist(sdto);
		
		
		transaction.commit();
		manager.close();
		factory.close();		
		
	}

}

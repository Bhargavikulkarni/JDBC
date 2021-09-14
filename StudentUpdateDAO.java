package com.bhargavi.Assignment;

import java.util.List;

import javax.naming.ldap.ManageReferralControl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bhargavi.hb.EmpDTO;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.Result;

public class StudentUpdateDAO {

	private static Object sName;

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager =    factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
	
		transaction.begin();
		Query query = manager.createQuery("update StudentCreateDTO set sPer = sPer+10");
	    int rows = query.executeUpdate();
	    System.out.println("No,of rows affected :"+rows);
	    transaction.commit();
	}
}

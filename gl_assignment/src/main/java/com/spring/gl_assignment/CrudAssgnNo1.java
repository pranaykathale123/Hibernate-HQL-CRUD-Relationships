package com.spring.gl_assignment;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Teacher;

public class CrudAssgnNo1 {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		// Creating first object
		Teacher t = new Teacher();
		t.setId(101);
		t.setF_Name("priyanka");
		t.setEmail("xyz@gmail.com");
		t.setL_Name("chopra");

		// Creating second object
		Teacher t1 = new Teacher();
		t1.setId(102);
		t1.setF_Name("pariniti");
		t1.setEmail("pari@gmail.com");
		t1.setL_Name("chopra");

		// Creating third object
		Teacher t2 = new Teacher();
		t2.setId(103);
		t2.setF_Name("amitabh");
		t2.setEmail("bachpan@gmail.com");
		t2.setL_Name("bachpan");

		// Creating fourth object
		Teacher t3 = new Teacher();
		t3.setId(104);
		t3.setF_Name("salmon");
		t3.setEmail("bhoi@gmail.com");
		t3.setL_Name("bhoi");

		Transaction tx = session.beginTransaction();
		// Insert operation
		session.save(t);
		session.save(t1);
		session.save(t2);
		session.save(t3);

		// fetching data/Read data
		String query = "from Teacher";
		Query q = session.createQuery(query);
		List<Teacher> list1 = q.getResultList();
		for (Teacher teacher : list1) {
			System.out.println("Fist name: " + teacher.getF_Name() + " Last name: " + teacher.getL_Name()
					+ " Teacher Id: " + teacher.getId() + " Teacher's Email: " + teacher.getEmail());
		}
		//Update Operation
		Query q1 = session.createQuery("update  Teacher set f_Name=:f where id=:i");
		q1.setParameter("f", "priti");
		q1.setParameter("i", 101);
		int count = q1.executeUpdate();// the number of entities updated or deleted
		System.out.println(count + "Updated");
		
		//Delete Operation
		 Query q2 = session.createQuery("delete from  Teacher  t where t.id=:id");
		 q2.setParameter("id",103);
		 int count1 = q2.executeUpdate();//the number of entities updated or deleted
		 System.out.println("Deleted");
		 System.out.println(count);
		tx.commit();
		session.close();
		factory.close();
	}
}

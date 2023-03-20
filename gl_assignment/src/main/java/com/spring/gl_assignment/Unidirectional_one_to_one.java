package com.spring.gl_assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Address;
import entity.Student;

public class Unidirectional_one_to_one {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// Creating Student
		Student student = new Student();
		student.setName("John Doe");

		Address address = new Address();
		address.setStreet("123 Main St");
		address.setCity("New York");
		address.setState("NY");
		address.setZipCode("10001");

		// setting address for student
		student.setAddress(address);

		// Creating Student
		Student student1 = new Student();
		student1.setName("John cena");

		Address address1 = new Address();
		address1.setStreet("selsura");
		address1.setCity("Mumbai");
		address1.setState("MH");
		address1.setZipCode("10002");

		// setting address for student
		student.setAddress(address);
		student1.setAddress(address1);

		session.save(student);
		session.save(student1); 
		
        //Delete student with One-To-One Cascade effect
		Student student2 = (Student) session.get(Student.class, 1);
		System.out.println(student2);
		session.delete(student2);

		tx.commit();
		session.close();

	}

}

package bidirectional_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Bidirectional_one_to_one {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		// creating Student
		Student1 st = new Student1();
		st.setName("John");

		// Creating address
		Address1 ad = new Address1();
		ad.setCity("nagpur");
		ad.setStreet("nagam nager");
		ad.setState("maharashtra");
		ad.setZipCode("442001");

		ad.setStudent(st);
		st.setAddress(ad);

		// Creating Student
		Student1 st1 = new Student1();
		st1.setName("goldberg");

		// Creating address
		Address1 ad1 = new Address1();
		ad1.setCity("Pune");
		ad1.setStreet("Ram nager");
		ad1.setState("Vidarbha");
		ad1.setZipCode("442010");

		ad1.setStudent(st1);
		st1.setAddress(ad1);

		Transaction tx = session.beginTransaction();
		session.save(ad);
		session.save(st);
		session.save(st1);
		session.save(ad1);
		// Fetching the student object with the associated address object
		Address1 address = session.get(Address1.class, 1);
		Student1 student = address.getStudent();
		System.out.println(student.getName());

		// Deleting the address object, which will cascade the delete operation to the
		// associated student object
		session.delete(address);
		tx.commit();
		session.close();
		factory.close();

	}

}

package bidirectional_one_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Bidirectional_OneToMany {
	private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();
		Student_OneToMany student = new Student_OneToMany();
		student.setName("amulya shetty");
		student.setEmail("amulya@gmail.com");

		List<Course> courses = new ArrayList<Course>();
		Course course = new Course();
		course.setCourseName("foot practise");
		course.setCoursePrice(175000);
		course.setStudent_onetomany(student);

		courses.add(course);

		System.out.println("creating tables in DB");

		Transaction tx = session.beginTransaction();

		for (Course c : courses) {
			session.save(c);
		}
		session.save(student);
		tx.commit();
		session.close();

		System.out.println("Removing Course without affecting Student:");
		deleteCourse(1);
	}

	public static void deleteCourse(int courseId) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Course course = session.get(Course.class, courseId);
		System.out.println(course.getCourseName()+"is Removed from DB");
		session.remove(course);
		tx.commit();
		session.close();
	}
}

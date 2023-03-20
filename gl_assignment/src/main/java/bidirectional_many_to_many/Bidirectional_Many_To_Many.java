package bidirectional_many_to_many;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Bidirectional_Many_To_Many {
	private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setEid(34);
		emp.setName("ram");

		Employee emp1 = new Employee();
		emp1.setEid(35);
		emp1.setName("Shyam");

		Project p1 = new Project();
		Project p2 = new Project();
		p1.setP_id(1212);
		p1.setProjectName("library management System");
		p2.setP_id(132);
		p2.setProjectName("CHATBOT");

		List<Employee> list1 = new ArrayList<Employee>();
		List<Project> list2 = new ArrayList<Project>();

		list1.add(emp);
		list1.add(emp1);

		list2.add(p1);
		list2.add(p2);

		emp.setProjects(list2);
		p2.setEmployees(list1);

		Session s = factory.openSession();

		Transaction tx = s.beginTransaction();
		s.save(emp);
		s.save(emp1);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
		System.out.println("fetch employees whom projects are assigned");
	    fetchemployess();
		System.out.println("fetch projects which assigned to employees");
		//fetchprojects();
		s.close();
		factory.close();
	}
	private static void fetchemployess() {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("SELECT e FROM Employee e JOIN e.projects p WHERE p.p_id IN (:pid1, :pid2)");
		q.setParameter("pid1", 132);
		q.setParameter("pid2", 1212);
		List<Employee> list1 = q.getResultList();
		for (Employee emp : list1) {
			System.out.println("Employee_ID: "+emp.getEid()+"Employee_Name: "+emp.getName());
			//System.out.println(Arrays.toString(emp));
		}
		
		tx.commit();
		s.close();
		
	}
	private static void fetchprojects() {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("SELECT p FROM project p JOIN p.employees e WHERE e.e_id IN (:eid1)");
		q.setParameter("eid1", 34);
		//q.setParameter("eid2", 1212);
		List<Project> list1 = q.getResultList();
		for (Project project : list1) {
			System.out.println("Project_ID: "+project.getP_id()+"Employee_Name: "+project.getProjectName());
			//System.out.println(Arrays.toString(obj));
		}
		tx.commit();
		s.close();
	}

}

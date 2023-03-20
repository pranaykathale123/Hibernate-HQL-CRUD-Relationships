package bidirectional_one_to_many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Student_OneToMany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String name;
	private String email;
	@OneToMany(mappedBy = "student_onetomany", cascade = CascadeType.ALL)
	private List<Course> courses;

	// parameterised constructor
	public Student_OneToMany(int studentId, String name, String email, List<Course> courses) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.courses = courses;
	}

	// Default Constructor
	public Student_OneToMany() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getters & Setters
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	// Tostring
	@Override
	public String toString() {
		return "Student_OneToMany [studentId=" + studentId + ", name=" + name + ", email=" + email + ", courses="
				+ courses + "]";
	}

}

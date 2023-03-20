package bidirectional_one_to_many;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	private double coursePrice;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student_OneToMany student_onetomany;

	// Default Constructor
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	//parameterised Constructor

	public Course(int courseId, String courseName, double coursePrice, Student_OneToMany student_onetomany) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.student_onetomany = student_onetomany;
	}
	//Getters & Setters

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(double coursePrice) {
		this.coursePrice = coursePrice;
	}

	public Student_OneToMany getStudent_onetomany() {
		return student_onetomany;
	}

	public void setStudent_onetomany(Student_OneToMany student_onetomany) {
		this.student_onetomany = student_onetomany;
	}
	//toString

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", coursePrice=" + coursePrice
				+ ", student_onetomany=" + student_onetomany + "]";
	}
	

}

package bidirectional_one_to_one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addressBOtoO")
public class Address1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String street;

	private String city;

	private String state;

	private String zipCode;

//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "student_id")
//	private Student1 student;
	
	@JoinColumn(name = "student_id")
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
	private Student1 student;

	public Address1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address1(int id, String street, String city, String state, String zipCode, Student1 student) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Student1 getStudent() {
		return student;
	}

	public void setStudent(Student1 student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", zipCode="
				+ zipCode + ", student=" + student + "]";
	}

}

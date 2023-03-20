package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	public Student(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getter and setter methods

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}

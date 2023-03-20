package bidirectional_many_to_many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int p_id;
	@Column(name = "Project_Name")
	private String projectName;
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int p_id, String projectName, List<Employee> employees) {
		super();
		this.p_id = p_id;
		this.projectName = projectName;
		this.employees = employees;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [p_id=" + p_id + ", projectName=" + projectName + ", employees=" + employees + "]";
	}
}

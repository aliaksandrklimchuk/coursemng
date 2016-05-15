package by.kochergin.app.domain;
// Generated 24.04.2016 10:10:15 by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Child generated by hbm2java
 */
@Entity
@Table(name = "child", catalog = "mydb")
public class Child implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Parent_id", nullable = false)
	private Parent parent;
	@Column(name = "firstname", nullable = false, length = 120)
	private String firstname;
	@Column(name = "patronomic", length = 45)
	private String patronomic;
	@Column(name = "lastname", nullable = false, length = 120)
	private String lastname;
	@Temporal(TemporalType.DATE)
	@Column(name = "dob", nullable = false, length = 10)
	private Date dob;
	@Column(name = "childrenGardenMember", nullable = false)
	private boolean childrenGardenMember;
	@Column(name = "canSpeak", nullable = false)
	private boolean canSpeak;
	private Boolean hasSpeachIssues;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "child_course", catalog = "mydb", joinColumns = {
			@JoinColumn(name = "Child_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Course_id", nullable = false, updatable = false) })
	private Set<Course> courses = new HashSet<Course>(0);
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "child")
	private Set<Attendency> attendencies = new HashSet<Attendency>(0);
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "child")
	private Set<Payment> payments = new HashSet<Payment>(0);

	public Child() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Parent getParent() {
		return this.parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}


	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
	public String getPatronomic() {
		return this.patronomic;
	}

	public void setPatronomic(String patronomic) {
		this.patronomic = patronomic;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isChildrenGardenMember() {
		return this.childrenGardenMember;
	}

	public void setChildrenGardenMember(boolean childrenGardenMember) {
		this.childrenGardenMember = childrenGardenMember;
	}

	public boolean isCanSpeak() {
		return this.canSpeak;
	}

	public void setCanSpeak(boolean canSpeak) {
		this.canSpeak = canSpeak;
	}

	@Column(name = "hasSpeachIssues")
	public Boolean getHasSpeachIssues() {
		return this.hasSpeachIssues;
	}

	public void setHasSpeachIssues(Boolean hasSpeachIssues) {
		this.hasSpeachIssues = hasSpeachIssues;
	}

	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<Attendency> getAttendencies() {
		return this.attendencies;
	}

	public void setAttendencies(Set<Attendency> attendencies) {
		this.attendencies = attendencies;
	}

	public Set<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

}

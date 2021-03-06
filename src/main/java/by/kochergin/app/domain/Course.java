package by.kochergin.app.domain;
// Generated 24.04.2016 10:10:15 by Hibernate Tools 3.2.2.GA

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Course generated by hbm2java
 */
@Entity
@Table(name = "course", catalog = "mydb")
public class Course implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Course_has_Trainer", joinColumns = { @JoinColumn(name = "Course_id", nullable = true, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "Trainer_id", nullable = true, updatable = false) })
	@JsonIgnore
	private Set<Trainer> trainers = new HashSet<Trainer>(0);

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "child_course", catalog = "mydb", joinColumns = { @JoinColumn(name = "Course_id", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "Child_id", nullable = false, updatable = false) })
	@JsonIgnore
	private Set<Child> children = new HashSet<Child>(0);

	public Set<Child> getChildren() {
		return children;
	}

	public void setChildren(Set<Child> children) {
		this.children = children;
	}

	public Set<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(Set<Trainer> trainers) {
		this.trainers = trainers;
	}

	public Course() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

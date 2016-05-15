package by.kochergin.app.domain;
// Generated 24.04.2016 10:10:15 by Hibernate Tools 3.2.2.GA

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Clientstatus generated by hbm2java
 */
@Entity
@Table(name = "clientstatus", catalog = "mydb")
public class Clientstatus implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "name", nullable = false, length = 45)
	private String name;
	@Column(name = "discountPercent", nullable = false, precision = 10, scale = 0)
	private BigDecimal discountPercent;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clientstatus")
	@JsonIgnore
	private Set<Parent> parents = new HashSet<Parent>(0);

	public Clientstatus() {
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

	public BigDecimal getDiscountPercent() {
		return this.discountPercent;
	}

	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Set<Parent> getParents() {
		return this.parents;
	}

	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}
}

package net.models;

// Generated 27 mars 2014 20:49:56 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "scrumtool")
public class Role implements java.io.Serializable {

	private Integer id;
	private String name;
	private Set<Playrole> playroles = new HashSet<Playrole>(0);
	private Set<Participate> participates = new HashSet<Participate>(0);

	public Role() {
	}

	public Role(String name, Set<Playrole> playroles,
			Set<Participate> participates) {
		this.name = name;
		this.playroles = playroles;
		this.participates = participates;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<Playrole> getPlayroles() {
		return this.playroles;
	}

	public void setPlayroles(Set<Playrole> playroles) {
		this.playroles = playroles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<Participate> getParticipates() {
		return this.participates;
	}

	public void setParticipates(Set<Participate> participates) {
		this.participates = participates;
	}

}
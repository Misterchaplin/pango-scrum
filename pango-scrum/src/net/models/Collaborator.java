package net.models;

// Generated 27 mars 2014 20:49:56 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Collaborator generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "collaborator", catalog = "scrumtool")
public class Collaborator implements java.io.Serializable {

	private Integer id;
	private String login;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private Boolean administrator;
	private Set<Userstory> userstories = new HashSet<Userstory>(0);
	private Set<Participate> participates = new HashSet<Participate>(0);
	private Set<Playrole> playroles = new HashSet<Playrole>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);

	public Collaborator() {
	}

	public Collaborator(String login, String password, String firstname,
			String lastname, String email, Boolean administrator,
			Set<Userstory> userstories, Set<Participate> participates,
			Set<Playrole> playroles, Set<Comment> comments) {
		this.login = login;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.administrator = administrator;
		this.userstories = userstories;
		this.participates = participates;
		this.playroles = playroles;
		this.comments = comments;
	}

	public Collaborator(String login, String password, String firstname, String lastname, String email, Boolean administrator) {
		super();
		this.login = login;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.administrator = administrator;
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

	@Column(name = "login", length = 45)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "firstname", length = 45)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", length = 45)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "administrator")
	public Boolean getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "realize", catalog = "scrumtool", joinColumns = { @JoinColumn(name = "idCollaborator", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "idUserStory", nullable = false, updatable = false) })
	public Set<Userstory> getUserstories() {
		return this.userstories;
	}

	public void setUserstories(Set<Userstory> userstories) {
		this.userstories = userstories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "collaborator")
	public Set<Participate> getParticipates() {
		return this.participates;
	}

	public void setParticipates(Set<Participate> participates) {
		this.participates = participates;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "collaborator")
	public Set<Playrole> getPlayroles() {
		return this.playroles;
	}

	public void setPlayroles(Set<Playrole> playroles) {
		this.playroles = playroles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "collaborator")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}

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
 * Commenttype generated by hbm2java
 */
@Entity
@Table(name = "commenttype", catalog = "scrumtool")
public class Commenttype implements java.io.Serializable {

	private Integer id;
	private String name;
	private String defaultContent;
	private Set<Comment> comments = new HashSet<Comment>(0);

	public Commenttype() {
	}

	public Commenttype(String name, String defaultContent, Set<Comment> comments) {
		this.name = name;
		this.defaultContent = defaultContent;
		this.comments = comments;
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

	@Column(name = "defaultContent", length = 65535)
	public String getDefaultContent() {
		return this.defaultContent;
	}

	public void setDefaultContent(String defaultContent) {
		this.defaultContent = defaultContent;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "commenttype")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}

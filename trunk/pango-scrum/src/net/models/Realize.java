package net.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* Realize
*/
@Entity
@Table(name = "realize", catalog = "scrumtool")
public class Realize implements java.io.Serializable {

	private RealizeId id;
	private Userstory userStory;
	private Collaborator collaborator;

	public Realize() {
	}

	public Realize(RealizeId id, Userstory userStory,Collaborator collaborator) {
		this.id = id;
		this.userStory = userStory;
		this.collaborator = collaborator;
	}

	@EmbeddedId
	@AttributeOverrides({
	@AttributeOverride(name = "idCollaborator", column = @Column(name = "idCollaborator", nullable = false)),
	@AttributeOverride(name = "idUserStory", column = @Column(name = "idUserStory", nullable = false))})
	
	public RealizeId getId() {
		return this.id;
	}

	public void setId(RealizeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUserStory", nullable = false, insertable = false, updatable = false)
	public Userstory getUserStory() {
		return this.userStory;
	}

	public void setUserStory(Userstory userStory) {
		this.userStory = userStory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCollaborator", nullable = false, insertable = false, updatable = false)
	public Collaborator getCollaborator() {
		return this.collaborator;
	}

	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(obj.getClass().equals(this.getClass())){
			Realize realize=(Realize) obj;
			return id.equals(realize.getId());
		}
		return false;
	}
}
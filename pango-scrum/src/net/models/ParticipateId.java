package net.models;

// Generated 27 mars 2014 20:49:56 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ParticipateId generated by hbm2java
 */
@Embeddable
public class ParticipateId implements java.io.Serializable {

	private int idSprint;
	private int idCollaborator;
	private int idRole;

	public ParticipateId() {
	}

	public ParticipateId(int idSprint, int idCollaborator, int idRole) {
		this.idSprint = idSprint;
		this.idCollaborator = idCollaborator;
		this.idRole = idRole;
	}

	@Column(name = "idSprint", nullable = false)
	public int getIdSprint() {
		return this.idSprint;
	}

	public void setIdSprint(int idSprint) {
		this.idSprint = idSprint;
	}

	@Column(name = "idCollaborator", nullable = false)
	public int getIdCollaborator() {
		return this.idCollaborator;
	}

	public void setIdCollaborator(int idCollaborator) {
		this.idCollaborator = idCollaborator;
	}

	@Column(name = "idRole", nullable = false)
	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ParticipateId))
			return false;
		ParticipateId castOther = (ParticipateId) other;

		return (this.getIdSprint() == castOther.getIdSprint())
				&& (this.getIdCollaborator() == castOther.getIdCollaborator())
				&& (this.getIdRole() == castOther.getIdRole());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdSprint();
		result = 37 * result + this.getIdCollaborator();
		result = 37 * result + this.getIdRole();
		return result;
	}

}

package net.models;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
* Realize
*/
@Embeddable
public class RealizeId implements java.io.Serializable {

	private int idCollaborator;
	private int idUserStory;

	public RealizeId() {
	}

	public RealizeId(int idCollaborator, int idUserStory) {
		this.idCollaborator = idCollaborator;
		this.idUserStory = idUserStory;
	}

	@Column(name = "idCollaborator", nullable = false)
	public int getIdCollaborator() {
		return this.idCollaborator;
	}

	public void setIdCollaborator(int idCollaborator) {
		this.idCollaborator = idCollaborator;
	}

	@Column(name = "idUserStory", nullable = false)
	public int getIdUserStory() {
		return this.idUserStory;
	}

	public void setidUserStory(int idUserStory) {
		this.idUserStory = idUserStory;
	}
	
	

}
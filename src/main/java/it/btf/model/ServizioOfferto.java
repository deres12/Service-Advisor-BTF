package it.btf.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*@Entity*/
public class ServizioOfferto  {
	
	/*@Id*/
	private String id;

	private String description;
	
	private Professione professione;
	
	

	public Professione getProfessione() {
		return professione;
	}



	public void setProfessione(Professione professione) {
		this.professione = professione;
	}



	public ServizioOfferto() {
		
	}
	
	

	public String getId() {
		return id;
	}



	public void setId(String idServiceOffer) {
		this.id = idServiceOffer;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String descServ) {
		this.description = descServ;
	}



}

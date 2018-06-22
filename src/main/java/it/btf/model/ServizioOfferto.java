package it.btf.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ServizioOfferto  {
	
	@Id
	private String idServiceOffer;

	private String descServ;

	public ServizioOfferto() {
		
	}
	
	

	public String getIdServiceOffer() {
		return idServiceOffer;
	}



	public void setIdServiceOffer(String idServiceOffer) {
		this.idServiceOffer = idServiceOffer;
	}



	public String getDescServ() {
		return descServ;
	}

	public void setDescServ(String descServ) {
		this.descServ = descServ;
	}



}

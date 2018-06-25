package it.btf.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 	
@DiscriminatorValue("C")
public class Cliente extends Guest{
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String cognome, String username, String via, String email) {
		super(nome, cognome, username, via, email);
		

	}
}

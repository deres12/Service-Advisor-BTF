package it.btf.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 	
@DiscriminatorValue("C")
public class Cliente extends Guest{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String cognome, String username, String via, String email, String pass) {
		super(nome, cognome, username, via, email, pass);
	}
}

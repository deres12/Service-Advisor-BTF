package it.btf.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 	
@DiscriminatorValue("C")
public class Cliente extends Guest{
	
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}
	
	public Cliente(String email, String pass, String nome, Luogo via) {
		super(email, pass, nome, via);
	}
}

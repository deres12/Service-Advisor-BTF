package it.btf.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_GUEST")
@Table(name="GUEST")
public abstract class Guest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String email;
	private String pass;
	private String nome;
		
	@Embedded
	private Luogo via;


	public Guest() {
		
	}

	public Guest(String email, String password, String name, Luogo via) {
		this.email = email;
		this.pass = password;
		this.nome = name;
		this.via = via;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Luogo getVia() {
		return via;
	}

	public void setVia(Luogo via) {
		this.via = via;
	}

}

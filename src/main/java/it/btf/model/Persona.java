package it.btf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "PERSONE")
@Entity
public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	private String nome;
	private String cognome;
	private String via;
	private String email;

	@Temporal(TemporalType.DATE)
	private Date timeBirth;


	public Persona() {

	}

	public Persona(String nome, String cognome, String username, String via, String email) {
		this.nome = nome;
		this.username = username;
		this.cognome = cognome;
		this.via = via;
		this.email=email;
		

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	
	public String getOid() {
		return getUsername();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTimeBirth() {
		return timeBirth;
	}

	public void setTimeBirth(Date timeBirth) {
		this.timeBirth = timeBirth;
	}

}

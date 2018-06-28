package it.btf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_GUEST")
@Table(name="GUEST")
public abstract class Guest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String username;
	private String nome;
	private String cognome;
	private String via;
	private String pass;
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Id
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeBirth;


	public Guest() {
		this.timeBirth=new Date();
	}

	public Guest(String nome, String cognome, String username, String via, String email, String pass) {
		this.email=email;
		this.nome = nome;
		this.username = username;
		this.cognome = cognome;
		this.via = via;
		this.pass=pass;
		this.timeBirth=new Date();
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

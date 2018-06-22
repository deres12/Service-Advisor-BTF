package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "USERX")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends AEntity<String> {

	@Id
	private String username;
	private String nome;
	private String cognome;
	private String via;
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

	private String email;

	@Temporal(TemporalType.DATE)
	private Date timeBirth;

	/*@Embedded
	private Address address;*/
	public User() {
		
	}
	
	/*public User(String nome, String cognome, String username, String via) {
		this.nome=nome;
		this.username=username;
		this.cognome=cognome;
		this.via=via;
		
	}*/
	
	public String getOid() {
		return getUsername();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/*public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
*/
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

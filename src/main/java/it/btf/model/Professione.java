package it.btf.model;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*@Entity
@Embeddable*/
public class Professione {
	
/*	@Id
	@GeneratedValue*/
	private Long id;
	private String nome;
	
/*	@OneToMany(mappedBy="username")
	@Embedded*/
	private List<Fornitore> fornitore;
	
	
	
	
	/*@OneToMany(mappedBy="id")
	@Embedded*/
	private List<ServizioOfferto> servizio;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	//private String servizio;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<ServizioOfferto> getServizi() {
		return servizio;
	}
	public void setTipiServizi(List<ServizioOfferto> tipiServizi) {
		this.servizio = tipiServizi;
	}

}

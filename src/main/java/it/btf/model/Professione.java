package it.btf.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professione {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;

	@OneToMany(mappedBy = "id")
	private List<Servizio> servizi;
	
	@OneToMany(mappedBy="username")
	private List<Fornitore> fornitori;
	
	
	public List<Servizio> getServizi() {
		return servizi;
	}

	public void setServizi(List<Servizio> servizi) {
		this.servizi = servizi;
	}

	public List<Fornitore> getFornitori() {
		return fornitori;
	}

	public void setFornitori(List<Fornitore> fornitori) {
		this.fornitori = fornitori;
	}

	public void addServizio(Servizio servizio) {
		this.servizi.add(servizio);
	}
	
	public void addFornitori(Fornitore fornitore) {
		this.fornitori.add(fornitore);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

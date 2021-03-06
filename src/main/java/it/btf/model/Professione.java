package it.btf.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professione {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;

	@OneToMany
	private List<Servizio> servizi;
	
	@OneToMany(mappedBy="professione")
	private List<Fornitore> fornitori;


	//Costruttore vuoto come detto da Giancarlo per le entità
	public Professione() {
		this.fornitori =new ArrayList<Fornitore>();
		this.servizi =new ArrayList<Servizio>();

	}

	public Professione(String nome, List<Servizio> servizi, List<Fornitore> fornitori) {
		this.nome = nome;
		this.servizi= servizi;
		this.fornitori = fornitori;
	}

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

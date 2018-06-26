package it.btf.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity 	
@DiscriminatorValue("F")
public class Fornitore extends Guest {
	
	private int valutazione;
	private String descrizione;
	private String numero;

	@ManyToOne
	private Professione professione;
	
	@OneToMany(mappedBy="fornitore")
	private List<Offerta> offerte;
	
	@OneToMany
	private List<Servizio> servizi;

	private static final long serialVersionUID = 1L;

	public Fornitore(String nome, String cognome, String username, String via, String email, String numero,String descrizione, List<Offerta> offerte, List<Servizio> servizi, Professione professione) {
		super(nome, cognome, username, via, email);
		this.valutazione=0;
		this.numero=numero;
		this.descrizione=descrizione;
		this.offerte=offerte;
		this.servizi=servizi;
		this.professione=professione;
		// TODO Auto-generated constructor stub
	}
	
	public Fornitore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professione getProfessione() {
		return professione;
	}

	public void setProfessione(Professione lavoro) {
		this.professione = lavoro;
	}

	public List<Servizio> getServizi() {
		return servizi;
	}

	public void setServizi(List<Servizio> servizi) {
		this.servizi = servizi;
	}

	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}

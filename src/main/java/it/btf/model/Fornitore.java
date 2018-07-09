package it.btf.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity 	
@DiscriminatorValue("F")
public class Fornitore extends Guest {

	private static final long serialVersionUID = 1L;
	
	private int valutazione;
	private String descrizione;

	@ManyToOne
	private Professione professione;
	
	@OneToMany(mappedBy="fornitore")
	private List<Offerta> offerte;
	
	@ManyToMany
	private List<Servizio> servizi;


	public Fornitore() {
		super();
		this.servizi=new ArrayList<Servizio>();
		this.offerte=new ArrayList<Offerta>();
		this.professione=new Professione();
	}

	public Fornitore(String email, String pass, String nome, Luogo via) {
		super(email, pass, nome, via);
		
		this.valutazione = 0;
		this.descrizione = "";
		this.servizi = new ArrayList<Servizio>();
		this.offerte = new ArrayList<Offerta>();
		this.professione = new Professione();
	}
	

	public List<Offerta> getOfferte() {
		return offerte;
	}

	public void setOfferte(List<Offerta> offerte) {
		this.offerte = offerte;
	}

	public Professione getProfessione() {
		return professione;
	}

	public void setProfessione(Professione lavoro) {
		this.professione = lavoro;
	}

	public void setProfessione(Long idLavoro) {
		this.professione = new Professione();
		professione.setId(idLavoro);
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
	
	public void addServizio(Servizio servizio) {
		this.servizi.add(servizio);
	}

}

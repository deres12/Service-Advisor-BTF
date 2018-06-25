package it.btf.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity 	
@DiscriminatorValue("F")
public class Fornitore extends Guest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Fornitore(String nome, String cognome, String username, String via) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Fornitore() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	private int valutazione;
	private String descrizione;
	private String numero;
	
	/*@OneToOne
	private Persona utente;*/
	
	/*@ManyToOne
	private Professione lavoro;
	*/
	
	/*public Persona getUtente() {
		return utente;
	}

	public void setUtente(Persona utente) {
		this.utente = utente;
	}*/

	
	// private

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

/*	public Professione getLavoro() {
		return lavoro;
	}

	public void setLavoro(Professione lavoro) {
		this.lavoro = lavoro;
	}*/
	
	

}

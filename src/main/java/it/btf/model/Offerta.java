package it.btf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Offerta {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private float prezzo;
	
	private String descrizione;
	
	private STATO stato;
	
	@ManyToOne
	private Fornitore fornitore;
	
	@ManyToOne
	private RichiestaCliente richiesta;
	
	public Offerta() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public STATO getStato() {
		return stato;
	}

	public void setStato(STATO stato) {
		this.stato = stato;
	}

	public Fornitore getFornitore() {
		return fornitore;
	}

	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}

	public RichiestaCliente getRichiesta() {
		return richiesta;
	}

	public void setRichiesta(RichiestaCliente richiesta) {
		this.richiesta = richiesta;
	}

	enum STATO {
		APERTA,
		SOSPESA,
		CHIUSA
	}

}

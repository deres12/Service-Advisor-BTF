package it.btf.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Offerta {
	
	enum STATO {
		ACCETTATA,
		RIFIUTATA,
		SOSPESA
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	private float prezzo;
	
	private String descrizione;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInizio;

	private STATO stato;

	@ManyToOne
	private Fornitore fornitore;

	@ManyToOne
	private RichiestaCliente richiesta;
	
	
	public Offerta() {
		stato=STATO.SOSPESA;
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

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

}

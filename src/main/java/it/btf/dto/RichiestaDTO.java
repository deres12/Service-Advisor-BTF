package it.btf.dto;

import java.util.Date;
import java.util.List;
import it.btf.model.Cliente;
import it.btf.model.Fornitore;
import it.btf.model.Offerta;
import it.btf.model.Servizio;

public class RichiestaDTO {

	private String descrizione;
	private String via;
	private long prezzoMassimo;
	private Date dataInizio;
	private Date dataFine;

	private String servizioRichiesto;

	private STATO stato;


	enum STATO {
		APERTA, SOSPESA, CHIUSA
	}
	
	public RichiestaDTO() {
		
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public long getPrezzoMassimo() {
		return prezzoMassimo;
	}

	public void setPrezzoMassimo(long prezzoMassimo) {
		this.prezzoMassimo = prezzoMassimo;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public String getServizioRichiesto() {
		return servizioRichiesto;
	}

	public void setServizioRichiesto(String servizioRichiesto) {
		this.servizioRichiesto = servizioRichiesto;
	}

	public STATO getStato() {
		return stato;
	}

	public void setStato(STATO stato) {
		this.stato = stato;
	}
	
	
	
	

}
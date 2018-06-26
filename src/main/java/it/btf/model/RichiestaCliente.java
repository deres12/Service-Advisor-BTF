package it.btf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class RichiestaCliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Cliente cliente;

	private String descrizione;
	private String via;

	private long prezzoMassimo;

	@Temporal(TemporalType.DATE)
	private Date dataInizio;
	@Temporal(TemporalType.DATE)
	private Date dataFine;

	private STATO stato;
	
	@ManyToOne
	private Fornitore fornitore;
	
	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public Fornitore getFornitore() {
		return fornitore;
	}

	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}

	@OneToMany(mappedBy="richiesta")
	private List<Offerta> offerte;
	
	@ManyToOne
	private Servizio servizioRichiesto;

	public RichiestaCliente() {
		offerte=new ArrayList<Offerta>();
		stato=STATO.APERTA;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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

	public STATO getStato() {
		return stato;
	}

	public void setStato(STATO stato) {
		this.stato = stato;
	}

	public List<Offerta> getOfferte() {
		return offerte;
	}

	public void setOfferte(List<Offerta> offerte) {
		this.offerte = offerte;
	}

	public Servizio getServizioRichiesto() {
		return servizioRichiesto;
	}

	public void setServizioRichiesto(Servizio servizioRichiesto) {
		this.servizioRichiesto = servizioRichiesto;
	}

	enum STATO {
		APERTA, SOSPESA, CHIUSA
	}

}

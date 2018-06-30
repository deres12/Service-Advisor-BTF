package it.btf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class RichiestaCliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Cliente cliente;

	@OneToMany(mappedBy="richiesta")
	private List<Offerta> offerte;

	@ManyToOne
	private Servizio servizioRichiesto;

	@ManyToOne
	private Fornitore fornitore;

	private String descrizione;
	@Embedded
	private Luogo via;
	private long prezzoMassimo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInizio;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFine;

	private STATO stato;
	

	public Luogo getVia() {
		return via;
	}

	public void setVia(Luogo via) {
		this.via = via;
	}

	public Fornitore getFornitore() {
		return fornitore;
	}

	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}


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

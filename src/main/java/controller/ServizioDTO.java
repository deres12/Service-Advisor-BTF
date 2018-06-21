package controller;

public class ServizioDTO {

	private String descrizione;
	private String tipoServizio;
	private String dataInizio;
	private String dataFine;
	private int prezzoMassimo;
	private String via;
	private int prezzoFissato;
	

	public ServizioDTO() {
		super();
		this.prezzoFissato=0;
	}
	
	
	public ServizioDTO(ServizioDTO a) {
		super();
		
		this.descrizione = a.getDescrizione();
		this.tipoServizio = a.getTipoServizio();
		this.dataInizio = a.getDataFine();
		this.dataFine = a.getDataFine();
		this.prezzoMassimo = a.getPrezzoMassimo();
		this.prezzoFissato=0;
		this.via=a.getVia();
		//this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipoServizio() {
		return tipoServizio;
	}

	public void setTipoServizio(String tipoServizio) {
		this.tipoServizio = tipoServizio;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public int getPrezzoMassimo() {
		return prezzoMassimo;
	}

	public void setPrezzoMassimo(int prezzoMassimo) {
		this.prezzoMassimo = prezzoMassimo;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getPrezzoFissato() {
		return prezzoFissato;
	}

	public void setPrezzoFissato(int prezzoFissato) {
		this.prezzoFissato = prezzoFissato;
	}

	
	
	
	
}

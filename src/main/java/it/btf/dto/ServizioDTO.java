package it.btf.dto;

public class ServizioDTO {

	private String descrizione;
	private String tipoServizio;
	private  long id;


	public ServizioDTO() {
	}

	public ServizioDTO(String descrizione, String tipoServizio, long id) {
		this.descrizione = descrizione;
		this.tipoServizio = tipoServizio;
		this.id = id;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

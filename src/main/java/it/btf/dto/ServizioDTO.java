package it.btf.dto;

public class ServizioDTO {

	private Long id;

	private String descrizione;

	public ServizioDTO(Long id, String descrizione) {
		this.id = id;
		this.descrizione = descrizione;
	}

	public ServizioDTO(Long id) {
		this.id = id;
	}

	public ServizioDTO() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}

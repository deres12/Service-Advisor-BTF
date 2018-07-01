package it.btf.dto;

public class RispostaExampleDTO {

	private String messaggio;

	public RispostaExampleDTO() {
		
	}

	public RispostaExampleDTO(String messaggio) {
		super();
		this.messaggio = messaggio;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

}
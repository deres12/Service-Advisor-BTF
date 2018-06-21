package controller;

public class RispostaDTO {

	private String messaggio;

	public RispostaDTO() {
		
	}

	public RispostaDTO(String messaggio) {
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
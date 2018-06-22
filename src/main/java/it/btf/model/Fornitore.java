package it.btf.model;


public class Fornitore extends User {

	public Fornitore(String nome, String cognome, String username, String via) {
		super();
		// TODO Auto-generated constructor stub
	}

	private int valutazione;
	private String descrizione;
	private String numero;
	private Professione lavoro;
	// private

	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Professione getLavoro() {
		return lavoro;
	}

	public void setLavoro(Professione lavoro) {
		this.lavoro = lavoro;
	}

}

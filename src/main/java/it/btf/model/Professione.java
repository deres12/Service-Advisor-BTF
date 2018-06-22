package it.btf.model;

import java.util.List;

public class Professione {
	private String nome;
	//private String servizio;
	private List<ServizioOfferto> tipiServizi;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<ServizioOfferto> getTipiServizi() {
		return tipiServizi;
	}
	public void setTipiServizi(List<ServizioOfferto> tipiServizi) {
		this.tipiServizi = tipiServizi;
	}

}

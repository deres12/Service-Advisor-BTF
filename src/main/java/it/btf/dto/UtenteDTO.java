package it.btf.dto;

public class UtenteDTO {

	private String nome;
	private String cognome;
	private String via;
	private String username;
	private String email;
	
	public UtenteDTO(String nome, String cognome, String username, String via, String email) {
		this.nome=nome;
		this.username=username;
		this.cognome=cognome;
		this.via=via;
		this.email=email;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

}
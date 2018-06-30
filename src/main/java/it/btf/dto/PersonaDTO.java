package it.btf.dto;

import it.btf.model.Luogo;
import it.btf.model.Professione;

import java.util.List;

public class PersonaDTO {

	private String nome;
	private String cognome;
	private Luogo via;
	private String username;
	private String email;
	private String pass;
    private int valutazione;
    private String descrizione;
    private String numero;
    private String type;
    private ProfessioneDTO professione;
    private List<ServizioDTO> servizi;

    public PersonaDTO() {

    }


    public PersonaDTO(String nome, String cognome, String username, Luogo via, String email, String pass, int valutazione, String descrizione, String numero, String type, List<ServizioDTO>servizi, ProfessioneDTO professione) {
        this.nome=nome;
        this.username=username;
        this.cognome=cognome;
        this.via=via;
        this.email=email;
        this.pass=pass;
        this.descrizione=descrizione;
        this.numero=numero;
        this.valutazione=valutazione;
        this.type=type;
        this.professione=professione;
        this.servizi=servizi;
    }


    public ProfessioneDTO getProfessione() {
        return professione;
    }

    public void setProfessione(ProfessioneDTO professione) {
        this.professione = professione;
    }

    public List<ServizioDTO> getServizi() {
        return servizi;
    }

    public void setServizi(List<ServizioDTO> servizi) {
        this.servizi = servizi;
    }



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

	public Luogo getVia() {
		return via;
	}

	public void setVia(Luogo via) {
		this.via = via;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
package it.btf.dto;

import java.util.ArrayList;
import java.util.List;

import it.btf.model.Luogo;

public class PersonaDTO {

	private String email;
	private String pass;
	private String nome;
	private LuogoDTO via;
	
	private String type;
    
	private int valutazione;
    private String descrizione;
    private String numero;
    
    private ProfessioneDTO professione;
    private List<ServizioDTO> servizi;

    public PersonaDTO() {
        this.professione = null;
        this.servizi = new ArrayList<ServizioDTO>();
    }


    public PersonaDTO(String email, String pass, String nome, Luogo via, String type) {
    	this.email = email;
    	this.pass = pass;
        this.nome = nome;
        this.via = new LuogoDTO(via);
        
        this.type = type;
        
        this.descrizione = "";
        this.numero = "";
        this.valutazione = 0;
        this.professione = null;
        this.servizi = new ArrayList<ServizioDTO>();
    }

    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	} 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LuogoDTO getVia() {
		return via;
	}

	public void setVia(LuogoDTO via) {
		this.via = via;
	}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
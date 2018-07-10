package it.btf.dto;

import java.util.List;

import it.btf.model.Fornitore;
import it.btf.model.Luogo;

public class FornitoreDTO  {

	private String email;
	
    private String nome;
    private String descrizione;
    
    private Luogo via;

    private Long professione;
    private int valutazione;

    private List<OffertaDTO> offerte;
    private List<ServizioDTO> servizi;
    
    public FornitoreDTO() {
    	
    }
    
    public FornitoreDTO(Fornitore f) {
    	this.email = f.getEmail();
    	this.nome = f.getNome();
    	this.descrizione = f.getDescrizione();
    	this.via = f.getVia();
		this.professione = f.getProfessione().getId();
		this.valutazione = f.getValutazione();
		// TODO: servizi...
    }

    //------METODI-----------
    
    public Luogo getVia() {
    	return this.via;
    }

    public void setVia(Luogo pvia) {
    	this.via = pvia;
    }


    public Long getProfessione() {
        return this.professione;
    }

    public void setProfessione(Long prof) {
        this.professione = prof;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<OffertaDTO> getOfferte() {
        return offerte;
    }

    public void setOfferte(List<OffertaDTO> offerte) {
        this.offerte = offerte;
    }

    public List<ServizioDTO> getServizi() {
        return servizi;
    }

    public void setServizi(List<ServizioDTO> servizi) {
        this.servizi = servizi;
    }
}

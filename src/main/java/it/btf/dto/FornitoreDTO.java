package it.btf.dto;

import java.util.List;

public class FornitoreDTO  {

    private int valutazione;
    private String descrizione;
    private String numero;
    private String email;


    //private ProfessioneDTO professione;
    private List<OffertaDTO> offerte;
    private List<ServizioDTO> servizi;

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

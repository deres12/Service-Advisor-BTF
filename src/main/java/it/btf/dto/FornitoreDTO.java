package it.btf.dto;

import java.util.ArrayList;
import java.util.List;

public class FornitoreDTO  {

    private String nome;
    private int valutazione;
    private String descrizione;
    private String numero;
    private String email;

    private String comune;
    private Double latit;
    private Double longit;


    private String nomeProfessione;

    private List<OffertaDTO> offerte;
    private List<ServizioDTO> servizi;



    //------METODI-----------

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public Double getLatit() {
        return latit;
    }

    public void setLatit(Double latit) {
        this.latit = latit;
    }

    public Double getLongit() {
        return longit;
    }

    public void setLongit(Double longit) {
        this.longit = longit;
    }

    public String getNomeProfessione() {
        return nomeProfessione;
    }

    public void setNomeProfessione(String nomeProfessione) {
        this.nomeProfessione = nomeProfessione;
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

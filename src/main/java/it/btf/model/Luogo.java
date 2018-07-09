package it.btf.model;

import javax.persistence.Embeddable;

import it.btf.dto.LuogoDTO;

import java.io.Serializable;

@Embeddable
public class Luogo implements Serializable {
    
    private static final long serialVersionUID = 1L;
	
	private int numeroCivico;
    private String via;
    private String paese;
    private String nazione;

    private Double latit;
    private Double longit;
    

    public Luogo() {
    
    }

    public Luogo(int numeroCivico, String via, String paese, String nazione, Double latit, Double longit) {
        this.numeroCivico = numeroCivico;
        this.via = via;
        this.paese = paese;
        this.nazione = nazione;
        this.latit = latit;
        this.longit = longit;
    }
    
    public Luogo(LuogoDTO dto) {
        this.numeroCivico = dto.getNumeroCivico();
        this.via = dto.getVia();
        this.paese = dto.getPaese();
        this.nazione = dto.getNazione();
    }


    
    @Override
    public String toString(){
        String richiesta=String.valueOf(this.numeroCivico)+" "+via+", "+paese+", "+nazione;
        return richiesta;
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


    public int getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(int numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

}

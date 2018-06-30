package it.btf.dto;

public class OffertaDTO {


    private float prezzo;
    private String descrizione;


    // private RichiestaDTO.STATO stato;
    private FornitoreDTO fornitore;
    private RichiestaDTO richiesta;



    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public FornitoreDTO getFornitore() {
        return fornitore;
    }

    public void setFornitore(FornitoreDTO fornitore) {
        this.fornitore = fornitore;
    }

    public RichiestaDTO getRichiesta() {
        return richiesta;
    }

    public void setRichiesta(RichiestaDTO richiesta) {
        this.richiesta = richiesta;
    }
}

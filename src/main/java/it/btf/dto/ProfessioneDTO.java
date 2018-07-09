package it.btf.dto;

import java.util.List;

public class ProfessioneDTO {

    private Long id;

    private String nome;



    private List<ServizioDTO> servizi;


    public ProfessioneDTO(Long id, String nome, List<ServizioDTO> servizi) {
        this.id = id;
        this.nome = nome;
        this.servizi=servizi;
    }

    public ProfessioneDTO() {

    }

    public List<ServizioDTO> getServizi() {
        return servizi;
    }

    public void setServizi(List<ServizioDTO> servizi) {
        this.servizi = servizi;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addServizio(ServizioDTO a){

        servizi.add(a);
    }
}

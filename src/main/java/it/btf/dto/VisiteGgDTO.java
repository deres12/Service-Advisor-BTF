package it.btf.dto;

public class VisiteGgDTO {

    private String dataStr;
    private Long numero;

    public VisiteGgDTO(String dataStr, Long numero) {
        this.dataStr = dataStr;
        this.numero = numero;
    }

    public VisiteGgDTO() {

    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}

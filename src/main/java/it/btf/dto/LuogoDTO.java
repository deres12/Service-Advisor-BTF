package it.btf.dto;

public class LuogoDTO {

        private int numeroCivico;
        private String via;
        private String paese;
        private String nazione;

        public LuogoDTO(int numeroCivico, String via, String paese, String nazione) {
            this.numeroCivico = numeroCivico;
            this.via = via;
            this.paese = paese;
            this.nazione = nazione;

        }

        public LuogoDTO() {
        }

        /**/

        @Override
        public String toString(){
            String richiesta=String.valueOf(this.numeroCivico)+" "+via+", "+paese+", "+nazione;
            return richiesta;
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



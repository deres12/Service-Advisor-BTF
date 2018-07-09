export interface Offerta {
  prezzo: number,
  descrizione: string,
  richiesta: {
    descrizione: string,
    prezzoMassimo: number
  },
}

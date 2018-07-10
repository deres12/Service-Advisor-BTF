import {Luogo} from "./luogo";

export interface Fornitore {
    nome: string;
    email: string;
    professione: number,
    descrizione: string;
    valutazione: string;
    via: {
        numeroCivico: number,
        via: string,
        paese: string,
        nazione: string,
        latit: number,
        longit: number
    }
}

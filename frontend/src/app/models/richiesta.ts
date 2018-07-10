import {Luogo} from "./luogo";
import {User} from "./user";

export interface Richiesta {
  prezzoMassimo:number;
  descrizione:string;
  professione:string;
  via:Luogo;
  data:string;
  persona: User;
  emailfornitore:string;
}

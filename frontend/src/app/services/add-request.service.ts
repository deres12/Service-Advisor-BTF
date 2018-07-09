import { Injectable } from '@angular/core';
import {Richiesta} from "../models/richiesta";
import {HttpClient} from "@angular/common/http";
import {any} from "codelyzer/util/function";

@Injectable({
  providedIn: 'root'
})
export class AddRequestService {

  richieste: Richiesta[] = [];

  constructor(private http: HttpClient) { }

  get richjeste(): Richiesta[] {
    return this.richieste;
  }

  esempioMock(type: Richiesta) {
    this.richieste.push(type);
  }
  addRichiesta(type: Richiesta) {
    let example:any;
    console.log(type.persona.email);
    example=this.http.post<any>("/services/richieste/inserisci", type);
    console.log(example);
    this.richieste.push(type);
    return example;
  }

}

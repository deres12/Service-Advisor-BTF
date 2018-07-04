import { Injectable } from '@angular/core';
import {Richiesta} from "../interfaces/richiesta";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AddRequestService {

  richieste:Richiesta[]=[];
  constructor(private http: HttpClient) { }

  get richjeste(): Richiesta[] {
    return this.richieste;
  }

  addRichiesta(type: Richiesta) {
    this.richieste.push(type);
  }



}

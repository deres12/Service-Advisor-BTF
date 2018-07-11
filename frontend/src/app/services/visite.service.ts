import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {any} from "codelyzer/util/function";
import {Visita} from "../models/Visita";

@Injectable({
  providedIn: 'root'
})
export class VisiteService {

  constructor(private httpClient: HttpClient) {
  }

  getVisite(id: string) {
    //console.log("dfasdad");
  //  let ex : Visita[] =;
    //console.log(prova);
    let ex : Visita[] =this.httpClient.get("/services/conta/",{params: {email: id}});
    console.log("ecco: "+ex);
    return ex;
  }

  setVisite(id: string) :any {
    return this.httpClient.get("/services/conta/addVisita/", {params: {email: id}});
  }
}

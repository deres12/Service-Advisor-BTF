import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {any} from "codelyzer/util/function";
import {Visita} from "../models/Visita";
import {Observable} from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class VisiteService {

  constructor(private httpClient: HttpClient) {
  }

  getVisite(id: string){
    return this.httpClient.get("/services/conta/",{params: {email: id}});
  }

  setVisite(id: string) :any {
    return this.httpClient.get("/services/conta/addVisita/", {params: {email: id}});
  }
}

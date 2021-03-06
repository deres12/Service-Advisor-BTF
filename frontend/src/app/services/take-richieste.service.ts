import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TakeRichiesteService {

  constructor(private httpClient:HttpClient) { }

  getRichieste () {
    return this.httpClient.get("/services/richieste/findAll");
  }
}

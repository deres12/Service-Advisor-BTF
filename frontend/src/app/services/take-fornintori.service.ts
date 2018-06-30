import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";




@Injectable({
  providedIn: 'root'
})
export class TakeFornintoriService {

  constructor(private httpClient:HttpClient) { }

  getFornitori () {
    return this.httpClient.get("/services/fornitore/find");
}
}

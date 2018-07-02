import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";




@Injectable({
  providedIn: 'root'
})
export class TakeFornintoriService {

  constructor(private httpClient:HttpClient) { }

  getFornitori () {
    //this.httpClient.request()
  //  ;
    return this.httpClient.get("http://localhost/services/fornitore/find");
}
}

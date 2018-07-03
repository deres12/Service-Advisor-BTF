import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Luogo} from "../interfaces/luogo";


@Injectable({
  providedIn: 'root'
})
export class TakeFornintoriService {

  constructor(private httpClient: HttpClient) {
  }

  getFornitori() {
    return this.httpClient.get("http://localhost/services/fornitore/find");
  }

  getFornitoriByAddress(place: Luogo) {
    return this.httpClient.post("http://localhost/services/fornitore/findByRadius",place);
  }




}

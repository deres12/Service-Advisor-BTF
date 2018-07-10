import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Luogo} from "../models/luogo";
import {Offerta} from "../models/offerta";


@Injectable({
  providedIn: 'root'
})
export class TakeFornintoriService {

  constructor(private httpClient: HttpClient) {}

  getFornitori() {
    return this.httpClient.get("/services/fornitore/find");
  }

  getFornitoriByAddress(place: Luogo) {
    return this.httpClient.post("/services/fornitore/findByRadius", place);
  }

  getRichiesteByFornitoreEmail(id: string) {
    return this.httpClient.post("/services/offerte/findByEmail", id);
  }


}

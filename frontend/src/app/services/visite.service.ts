import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class VisiteService {

  constructor(private httpClient: HttpClient) {
  }

  getVisite(id: string) {
    return this.httpClient.get("/services/conta/",{params: {email: id}});
  }

  setVisite(id: string) :any {
    return this.httpClient.get("/services/conta/addVisita/", {params: {email: id}});
  }
}

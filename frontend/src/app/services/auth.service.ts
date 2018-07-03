import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from "../../environments/environment.prod";
import { ProfileInfo, UserType } from '../interfaces/user';
import { LoginData, SignupData } from '../interfaces/auth';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loginUrl: string = environment.apiUrl+"/user/login";
  private signupUrl: string = environment.apiUrl+"/user/registrati";


  userInfo: ProfileInfo = {
    name: "",
    type: UserType.Guest
  };

  constructor(private http: HttpClient) {}

  get userType(): UserType {
    return this.userInfo.type;
  }

  set userType(type: UserType) {
    this.userInfo.type = type;
  }

  login(data: LoginData): Observable<any> {
    return this.http.post<any>(this.loginUrl, data);
  }

  signup(data: SignupData): Observable<any> {
    //console.log(data);
    /*environment.utente.email=data.email;
    environment.utente.indirizzo=data.indirizzo;
    environment.utente.nome=data.nome;
    environment.utente.password=data.password;
    environment.utente.professione=data.professione;
    environment.utente.tipo=data.type;*/
    let response: any=this.http.post<any>("http://localhost/services/user/registrati", data);

    if(data.type== UserType.Client) {
      this.userInfo.type = UserType.Client;
    }else if(data.type== UserType.Vendor){
      this.userInfo.type = UserType.Vendor;
    }

    console.log(response);
    return response;
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from "../../environments/environment.prod";
import { User, UserType } from '../interfaces/user';
import { LoginData, SignupData } from '../interfaces/auth';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private host: string = environment.hostname;
  private apiUrl: string = environment.apiUrl;
  private loginUrl: string = this.host + this.apiUrl + "/user/login";
  private signupUrl: string = this.host + this.apiUrl + "/user/registrati";


  userInfo: User = {
    type: UserType.Guest,
    email: "",
    password: "",
    nome: ""
  };

  constructor(private http: HttpClient) {}

  get userType(): UserType {
    return this.userInfo.type;
  }

  set userType(type: UserType) {
    this.userInfo.type = type;
  }

  signup(data: SignupData): Observable<any> {
<<<<<<< HEAD
    let request = this.http.post<any>("/services/user/registrati", data);
=======
    let request = this.http.post<any>(this.signupUrl, data);

>>>>>>> Logout service refactor
    return request;
  }

  login(data: LoginData): Observable<any> {
    return this.http.post<any>(this.loginUrl, data);
  }

<<<<<<< HEAD

}
=======
  logout() {
    this.userInfo.type = UserType.Guest;
    this.userInfo.email = "";
    this.userInfo.nome = "";
    this.userInfo.password = "";
  }
}
>>>>>>> Logout service refactor

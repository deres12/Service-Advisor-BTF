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
    password: ""
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
    let request = this.http.post<any>("http://localhost/services/user/registrati", data);

    request.subscribe(
      response => {
        this.userInfo = response;
      }
    );
    
    return request;
  }
}

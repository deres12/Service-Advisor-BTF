import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from "../../environments/environment.prod";
import { User, UserType } from '../models/user';
import { LoginData, SignupData } from '../models/auth';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private host: string = environment.hostname;
  private apiUrl: string = environment.apiUrl;
  private loginUrl: string = this.host + this.apiUrl + "/user/login";
  private signupUrl: string = this.host + this.apiUrl + "/user/registrati";

  userInfo: User = new User();

  constructor(private http: HttpClient) {
    const jsondata = localStorage.getItem("user-profile");
    if(jsondata) {
      this.userInfo = JSON.parse(jsondata);
    } else {
      this.userInfo = new User();
    }
  }

  get userType(): UserType {
    return this.userInfo.type;
  }

  set userType(type: UserType) {
    this.userInfo.type = type;
  }

  signup(data: SignupData): Observable<any> {

    let request = this.http.post<any>(this.signupUrl, data);
    return request;
  }

  login(data: LoginData): Observable<any> {
    let request = this.http.post<any>(this.loginUrl, data);
    return request;
  }

  logout() {
    this.userInfo = new User();
    localStorage.removeItem("user-profile");
  }
}

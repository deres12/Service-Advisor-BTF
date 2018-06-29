import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from "../../environments/environment.prod";

/* TODO: spostare le interfacce in file separati */
export interface SignupData {
  type: UserType,
  email: string,
  pass: string
}

export interface LoginData {
  email: string,
  pass: string
}

export enum UserType {
  Guest  = "",
  Client = "C",
  Vendor = "F"
}

interface ProfileInfo {
  name: string,
  type: UserType
  /*...*/
}

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
    console.log(data.email);
    console.log(data.pass);
    console.log(data.type);
    console.log(this.signupUrl);
    return this.http.post<any>(this.signupUrl, data);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

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
  private loginUrl: string = "/services/user/login";
  private signupUrl: string = "/services/user/registrati";


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
    return this.http.post<any>(this.signupUrl, data);
  }
}

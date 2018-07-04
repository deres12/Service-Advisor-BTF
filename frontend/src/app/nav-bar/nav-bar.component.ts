import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import {UserType} from "../interfaces/user";
import {Router} from "@angular/router";


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  userType = UserType;
  constructor(public auth: AuthService,public router: Router) { }
  logout(){
    this.auth.userInfo.type=UserType.Guest;
    this.auth.userInfo.email="";
    this.auth.userInfo.nome="";
    this.auth.userInfo.password="";
    this.router.navigate([""]);

  }
  ngOnInit() {}

}

import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import {UserType} from "../models/user";
import {Router} from "@angular/router";


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  nome: string = "Service Advisor";

  userType = UserType;
  
  constructor(
    public auth: AuthService,
    public router: Router) { }
  
  ngOnInit() {}

  logout() {
    this.auth.logout();
    this.router.navigate([""]);
  }
}

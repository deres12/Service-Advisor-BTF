import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import {UserType} from "../interfaces/user";


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  userType = UserType;
  constructor(public auth: AuthService) { }

  ngOnInit() {}

}

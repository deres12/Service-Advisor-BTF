import { Component, OnInit } from '@angular/core';
import { AuthService, UserType } from '../services/auth.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  userType = UserType;

  constructor(private auth: AuthService) { }

  ngOnInit() {}

}

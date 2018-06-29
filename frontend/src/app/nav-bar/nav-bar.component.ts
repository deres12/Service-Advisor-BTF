import { Component, OnInit } from '@angular/core';
import { AuthService, UserType } from '../services/auth.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  private _menu_open: boolean = false;

  userType = UserType;

  constructor(private auth: AuthService) { }

  ngOnInit() {}

  get isMenuOpen() {
    return this._menu_open;
  }

  closeSideMenu() {
    this._menu_open = false;
  }
  
  openSideMenu() {
    this._menu_open = true;
  }

  toggleSideMenu() {
    this._menu_open = !this._menu_open;
  }
}

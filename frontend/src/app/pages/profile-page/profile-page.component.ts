import {Component, OnInit} from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { UserType } from '../../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {
  userType = UserType;

  constructor(
    private auth: AuthService,
    private router: Router) {}

  ngOnInit() {
    if(this.auth.userType == UserType.Guest) {
      this.router.navigateByUrl("/login");
    }
  }
}

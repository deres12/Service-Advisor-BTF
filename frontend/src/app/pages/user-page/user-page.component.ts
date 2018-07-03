import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { UserType } from '../../interfaces/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {
  userType = UserType;

  constructor(
    public auth: AuthService,
    public router: Router) { }

  ngOnInit() {
    if(this.auth.userType == UserType.Guest) {
      console.log("unauthorized");
      this.router.navigateByUrl("");
    }
  }
}

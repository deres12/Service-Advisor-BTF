import {Component, OnInit} from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { LoginData } from '../../models/auth';
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  data: LoginData = {email: "", pass: ""};
  error: boolean=false;

  constructor(
    private auth: AuthService,
    public router: Router) {}

  ngOnInit() {}

  validate(): boolean {
    if(this.data.email.length == 0 || this.data.email.search('@') < 0) {
      return false;
    }

    if(this.data.pass.length == 0) {
      return false;
    }
    return true;
  }

  submit() {
    if (this.validate() == false) {
      return;
    }

    this.auth.login(this.data).subscribe(
      res => {
        console.log(res);

        this.auth.userInfo = res;

        localStorage.setItem("user-profile", JSON.stringify(this.auth.userInfo));

        this.router.navigateByUrl("/profile");
      },
      err => {
        this.error = true;
      }
    );
  }
}

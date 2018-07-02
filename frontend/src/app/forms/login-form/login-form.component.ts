import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { LoginData } from '../../interfaces/auth';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  data: LoginData = {email: "", pass: ""};

  constructor(private auth: AuthService) {}

  ngOnInit() {}

  validate(): boolean {
    if(this.data.email.length == 0 || this.data.pass.length == 0) {
      return false;
    }
    return true;
  }

  submit(event) {
    event.preventDefault();
    if(this.validate() == false) {
      alert("compila bene il form");
      return;
    }
    this.auth.login(this.data).subscribe(
      res => console.info,
      err => console.error
    );
  }
}

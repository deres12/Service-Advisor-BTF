import {Component, Inject, OnInit} from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { LoginData } from '../../interfaces/auth';
import {LOCAL_STORAGE, WebStorageService} from "angular-webstorage-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  data: LoginData = {email: "", pass: ""};
  error:boolean=false;

  constructor(
    private auth: AuthService,
    public router: Router) {}

  ngOnInit() {}

  validate(): boolean {
    if(this.data.email.length == 0 || !this.data.email.search('@')||this.data.pass.length == 0) {
      return false;
    }
    return true;
  }

  submit() {
    if (this.validate() == false) {
      return;
    }
    console.error(this.data);
    this.auth.login(this.data).subscribe(
      res => {

        localStorage.setItem("email",this.auth.userInfo.email);
        localStorage.setItem("nome",this.auth.userInfo.nome);
        localStorage.setItem("tipo",this.auth.userInfo.type);

        this.auth.userInfo.email = res.email;
        this.auth.userInfo.nome = res.nome;
        this.auth.userInfo.type = res.tipo;
        this.router.navigate(["profile"]);
      },
      err => {
        this.error = true;
      }
    );
  }
}

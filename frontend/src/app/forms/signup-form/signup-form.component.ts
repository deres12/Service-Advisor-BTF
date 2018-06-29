import { Component, OnInit } from '@angular/core';
import { UserType, AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.css']
})
export class SignupFormComponent implements OnInit {
  private _step: number = 0;

  userType = UserType;

  type: UserType = UserType.Guest;
  email: string;
  pass1: string;
  pass2: string;

  constructor(private auth: AuthService) { }

  ngOnInit() {}

  get step() {return this._step;}

  next(n: number) {
    if(n < 0 || n > 1) return;
    this._step = n;
  }

  validate(): boolean {
    if(this.type != UserType.Client && this.type != UserType.Vendor) {
      return false;
    }

    if(this.email.length == 0) {
      return false;
    }

    if(this.pass1.length == 0) {
      return false;
    }

    if(this.pass2.length == 0) {
      return false;
    }

    if(this.pass1 != this.pass2) {
      return false;
    }

    return true;
  }

  submit(event) {
    event.preventDefault();
    if(!this.validate()) return;
    // call REST API
    this.auth.signup({type: this.type, email: this.email, pass: this.pass1}).subscribe(
      res => {},
      err => {}
    );
  }
}

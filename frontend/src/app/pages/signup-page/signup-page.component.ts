import {Component, Inject, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import {UserType} from '../../models/user';
import {Job} from '../../models/job';
import {JobsDataService} from '../../services/jobs.service';


@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css']
})
export class SignupPageComponent implements OnInit {

  private _step: number;
  private _history: number[];
  userType = UserType;

  error: boolean = false;

  type: UserType;
  professione: Job;

  jobs: Job[];

  constructor(
    public auth: AuthService,
    public jobsData: JobsDataService,
    public router: Router){}

  ngOnInit() {
    this._step = 0;
    this._history = [];

    this.jobs = this.jobsData.getAll();
  }

  get step() {
    return this._step;
  }

  back() {
    if (this._history.length > 0) {
      this._step = this._history.pop();
    }
  }

  next() {
    if (this._step == 3) {
      return;
    }
    this._history.push(this._step);
    if (this._step == 0 && this.type == UserType.Client) {
      this._step = 3;
    } else {
      this._step++;
    }
  }

  valid(form: NgForm): boolean {

    if (this.step == 3) {
      if (form.value["nome"].length == 0) {
        return false;
      }
      if (form.value["email"].length == 0) {
        return false;
      }
      if (form.value["password"].length == 0) {
        return false;
      }

      if ((form.value["password"] != form.value["password2"])) {
        return false;
      }
    }

    return true;
  }

  submit(form: NgForm) {
    this.error = false;
    
    let submitData;

    // collect form data
    if (this.type == UserType.Client) {
      submitData = {
        type: this.type,
        nome: form.value["nome"],
        email: form.value["email"],
        pass: form.value["password"],
        professione: {id: 0},
        via: null
      };
    } else {
      submitData = {
        type: this.type,
        nome: form.value["nome"],
        email: form.value["email"],
        pass: form.value["password"],
        professione: {id: this.professione.id},
        via: {
          nazione: "IT",
          paese: form.value["city"],
          via: form.value["address"],
          numeroCivico: form.value["civic-num"]
        }
      };
    }

    // call REST api
    this.auth.signup(submitData).subscribe(
      res => {
        console.log(res);
        this.auth.userInfo = res;

        localStorage.setItem("user-profile", JSON.stringify(this.auth.userInfo));
        this.router.navigateByUrl("/profile");
      },
      err => {
        console.log(err)
        this.error = true;
      }
    );
  }
}

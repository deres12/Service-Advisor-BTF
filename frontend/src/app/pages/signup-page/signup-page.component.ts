import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { SignupData } from '../../interfaces/auth';
import { Router } from '@angular/router';
import { UserType } from '../../interfaces/user';
import { Job } from '../../interfaces/job';
import { JobsDataService } from '../../services/jobs.service';
import {environment} from "../../../environments/environment";

@Component({
    selector: 'app-signup-page',
    templateUrl: './signup-page.component.html',
    styleUrls: ['./signup-page.component.css']
})
export class SignupPageComponent implements OnInit {

    private _step: number;
    private _history: number[];
    //private route:Router;
    userType = UserType;

    error: boolean = false;

    type: UserType;
    professione: Job;

    jobs: Job[];

    constructor(
        public auth: AuthService,
        public jobsData: JobsDataService,
        public router: Router) {}

    ngOnInit() {
        this._step = 0;
        this._history = [];

        this.jobs = this.jobsData.getAll();
    }

    get step() {
        return this._step;
    }

    back() {
        if(this._history.length > 0) {
            this._step = this._history.pop();
        }
    }

    next() {
        if(this._step == 3) {
            return;
        }
        this._history.push(this._step);
        if(this._step == 0 && this.type == UserType.Client) {
            this._step = 3;
        } else {
        this._step++;
        }
    }

    valid(form: NgForm) {
        return true;
    }

    submit(form: NgForm) {
        this.error = false;
        var submitData;
        // collect form data
      if(this.type==UserType.Client){
        submitData = {
            type: this.type,
            nome: form.value["nome"],
            email: form.value["email"],
            password: form.value["password"],
            professione:{id:0} ,
            indirizzo: form.value["address"],
        };
      }else{
        submitData = {
          type: this.type,
          nome: form.value["nome"],
          email: form.value["email"],
          password: form.value["password"],
          professione:{id:this.professione.id} ,
          indirizzo: form.value["address"],
        };
        //this.professione.id
      }

        // call REST api
        let result = this.auth.signup(submitData);
        result.subscribe(
            res => {
                //console.log(res);
                this.router.navigate(["profile"]);
            },
            err => {
                //console.log("ERRORE");
                this.error = true;
            }
        );
    }
}

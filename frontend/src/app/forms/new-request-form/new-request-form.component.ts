import {Component, Inject, NgModule, OnInit} from '@angular/core';
import {JobsDataService} from '../../services/jobs.service';
import {NgForm} from '@angular/forms';
import {LOCAL_STORAGE, WebStorageService} from "angular-webstorage-service";
import {ActivatedRoute, Router} from "@angular/router";
import {MockJob} from "../../mock-data/models";
import {AddRequestService} from "../../services/add-request.service";
import {Richiesta} from "../../models/richiesta";
import {AuthService} from "../../services/auth.service";
import {UserType} from "../../models/user";
import {Luogo} from "../../models/luogo";


export class NgbdDatepickerPopup {
  model;
}

@Component({
  selector: 'app-new-request-form',
  templateUrl: './new-request-form.component.html',
  styleUrls: ['./new-request-form.component.css']
})
export class NewRequestFormComponent implements OnInit {
  model;

  constructor(public router: Router, public prova: AddRequestService, public jobs: JobsDataService, public auth: AuthService) {
  }

  private sub: any;
  id: number;
  emailfornit: string;
  //jobs:MockJob[];
  richiesta: Richiesta = {
    prezzoMassimo: 0,
    descrizione: "",
    professione: "",
    via: {numeroCivico:0,via:"",paese:"",nazione:"IT",lat:0,longi:0,radius:0},
    data: "",
    persona: {email:"",type: null, pass:"",nome:""},
    emailfornitore: null
  };

  ngOnInit() {
    if(localStorage.getItem("emailfornitore")!=null){
      this.richiesta.emailfornitore=localStorage.getItem("emailfornitore");
      localStorage.removeItem("emailfornitore");
      console.log(this.richiesta.emailfornitore);
    }else{
      this.richiesta.emailfornitore=null;
    }
    if (this.auth.userType == UserType.Guest)
      this.router.navigate([""]);
  }

  valid(form: NgForm): boolean {
    return true;
  }

  submit(form: NgForm) {
    //console.log(form.value["data"]);
    this.richiesta.descrizione = form.value["descrizione"];
    //this.richiesta.descrizione="descrizione";
    //console.log("EMAIL:  "+this.auth.userInfo.email);

    this.richiesta.persona.email=this.auth.userInfo.email;
    this.richiesta.professione = form.value["job"];
    this.richiesta.via.via = form.value["address"];
    this.richiesta.via.paese = form.value["paese"];
    this.richiesta.via.numeroCivico = form.value["numeroCivico"];
    this.richiesta.data =form.value["data"].day.toString()+"/"+form.value["data"].month.toString() +"/"+form.value["data"].year.toString();
    this.richiesta.prezzoMassimo = form.value["prezzoMassimo"];
    //console.log(this.richiesta.emailfornitore);
    //console.log(this.richiesta);
    // call REST api
    this.prova.addRichiesta(this.richiesta).subscribe(
      res => {
        console.log(res);
      },
      err => {
        console.log(err)
        /*this.error = true;*/
      }
    );
    this.prova.esempioMock(this.richiesta);
    // console.log(this.request.richjeste());
    // {job, address data: descrizione: ""}
    this.router.navigate(["profile"]);

    //if(!this.valid(form)) return; {year: 2018, month: 7, day: 7}


    // call REST API
  }
}

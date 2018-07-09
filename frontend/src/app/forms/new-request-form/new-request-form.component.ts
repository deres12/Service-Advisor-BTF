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
    indirizzo: "",
    data: "",
    email: ""
  };

  ngOnInit() {
    if (this.auth.userType == UserType.Guest)
      this.router.navigate([""]);
  }

  valid(form: NgForm): boolean {
    return true;
  }

  submit(form: NgForm) {
    console.log(form.value["data"]);
    this.richiesta.descrizione = form.value["descrizione"];
    //this.richiesta.descrizione="descrizione";
    this.richiesta.email=this.auth.userInfo.email;
    this.richiesta.professione = form.value["job"];
    this.richiesta.indirizzo = form.value["address"];
    this.richiesta.data =form.value["data"].day.toString()+"/"+form.value["data"].month.toString() +"/"+form.value["data"].year.toString();
    this.richiesta.prezzoMassimo = form.value["prezzoMassimo"];
    this.prova.addRichiesta(this.richiesta);
    // console.log(this.request.richjeste());
    // {job, address data: descrizione: ""}
    this.router.navigate(["profile"]);

    //if(!this.valid(form)) return; {year: 2018, month: 7, day: 7}


    // call REST API
  }
}

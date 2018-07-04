import {Component, Inject, OnInit} from '@angular/core';
import {JobsDataService} from '../../services/jobs.service';
import {NgForm} from '@angular/forms';
import {LOCAL_STORAGE, WebStorageService} from "angular-webstorage-service";
import {ActivatedRoute, Router} from "@angular/router";
import {MockJob} from "../../mock-data/models";
import {AddRequestService} from "../../services/add-request.service";
import {Richiesta} from "../../interfaces/richiesta";
import {AuthService} from "../../services/auth.service";
import {UserType} from "../../interfaces/user";
import {log} from "util";

@Component({
  selector: 'app-new-request-form',
  templateUrl: './new-request-form.component.html',
  styleUrls: ['./new-request-form.component.css']
})
export class NewRequestFormComponent implements OnInit {

  constructor(public router: Router, public prova: AddRequestService, @Inject(LOCAL_STORAGE) private storage: WebStorageService, private jobs: JobsDataService, public auth: AuthService) {
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
    /*this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
    });*/
    /*this.id = 0;
    console.log(this.storage.get("fornitori"));
    this.emailfornit = this.storage.get("fornitori")[this.id];
    console.log(this.emailfornit);*/
    if (this.auth.userType == UserType.Guest)
      this.router.navigate([""]);
  }

  valid(form: NgForm): boolean {
    return true;
  }

  submit(form: NgForm) {
    console.log(form.value);
    this.richiesta.descrizione = form.value["descrizione"];
    //this.richiesta.descrizione="descrizione";
    this.richiesta.email=this.auth.userInfo.email;
    this.richiesta.professione = form.value["job"];
    this.richiesta.indirizzo = form.value["address"];
    this.richiesta.data = form.value["data"];
    this.richiesta.prezzoMassimo = form.value["prezzoMassimo"];
    this.prova.addRichiesta(this.richiesta);
    // console.log(this.request.richjeste());
    // {job, address data: descrizione: ""}
    this.router.navigate(["profile"]);

    //if(!this.valid(form)) return;


    // call REST API
  }
}

import {Component, Inject, OnInit} from '@angular/core';
import { JobsDataService } from '../../services/jobs.service';
import { NgForm } from '@angular/forms';
import {LOCAL_STORAGE, WebStorageService} from "angular-webstorage-service";
import {ActivatedRoute} from "@angular/router";
import {MockJob} from "../../mock-data/models";
import {AddRequestService} from "../../services/add-request.service";
import {Richiesta} from "../../interfaces/richiesta";

@Component({
  selector: 'app-new-request-form',
  templateUrl: './new-request-form.component.html',
  styleUrls: ['./new-request-form.component.css']
})
export class NewRequestFormComponent implements OnInit {

  constructor(public prova: AddRequestService,@Inject(LOCAL_STORAGE) private storage: WebStorageService,private jobs: JobsDataService, private route: ActivatedRoute) { }
  private sub: any;
  id: number;
  emailfornit:string;
  //jobs:MockJob[];
  richiesta: Richiesta;

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
    });
    console.log(this.storage.get("fornitori"));
    this.emailfornit= this.storage.get("fornitori")[this.id];
    console.log(this.emailfornit);
  }

  valid(form: NgForm): boolean {
    return true;
  }

  submit(form: NgForm) {

    this.richiesta.descrizione=form.value["descrizione"];
    this.richiesta.professione=form.value["job"];
    this.richiesta.indirizzo=form.value["address"];
    this.richiesta.data=form.value["data"];
    this.prova.addRichiesta(this.richiesta);
   // console.log(this.request.richjeste());
   // {job, address data: descrizione: ""}

    //if(!this.valid(form)) return;



    // call REST API
  }
}

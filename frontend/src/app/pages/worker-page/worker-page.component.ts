import { Component, OnInit } from '@angular/core';
import {Richiesta} from "../../models/richiesta";
import {TakeFornintoriService} from "../../services/take-fornintori.service";
import {User, UserType} from "../../models/user";
import {Router} from "@angular/router";
import {AddRequestService} from "../../services/add-request.service";
import {AuthService} from "../../services/auth.service";
import {Fornitore} from "../../models/fornitore";
import {Offerta} from "../../models/offerta";

@Component({
  selector: 'app-worker-page',
  templateUrl: './worker-page.component.html',
  styleUrls: ['./worker-page.component.css']
})
export class WorkerPageComponent implements OnInit {

  user: User;
    richieste: Richiesta[] = [];
    fornitori: Fornitore[];
    offerte: Offerta[]=[];
    empty: boolean = true;

    constructor(public auth: AuthService,
      public router: Router, private serv: TakeFornintoriService,
      public prova: AddRequestService) {
    }

    ngOnInit() {
      this.user = this.auth.userInfo;

      this.serv.getRichiesteByFornitoreEmail(this.auth.userInfo.email).subscribe((list: Offerta[]) => {
        this.offerte = list;
        if (this.offerte.length>0)
          this.empty = false;
      }, (error) => {
        console.log(error.toString());
      });

      if (this.auth.userInfo.type == UserType.Guest) {
        console.log("unauthorized");
        this.router.navigateByUrl("login");
      }

    }
  }



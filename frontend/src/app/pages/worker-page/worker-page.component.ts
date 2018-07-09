import { Component, OnInit } from '@angular/core';
import {Richiesta} from "../../models/richiesta";
import {TakeFornintoriService} from "../../services/take-fornintori.service";
import {User, UserType} from "../../models/user";
import {Router} from "@angular/router";
import {AddRequestService} from "../../services/add-request.service";
import {AuthService} from "../../services/auth.service";
import {Fornitore} from "../../models/fornitore";

@Component({
  selector: 'app-worker-page',
  templateUrl: './worker-page.component.html',
  styleUrls: ['./worker-page.component.css']
})
export class WorkerPageComponent implements OnInit {

  user: User;
    richieste: Richiesta[] = [];
    fornitori: Fornitore[];
    empty: boolean = true;

    constructor(public auth: AuthService,
      public router: Router, private serv: TakeFornintoriService,
      public prova: AddRequestService) {
    }

    ngOnInit() {
      this.user = this.auth.userInfo;
      if (this.richieste.length == 0) {
        this.empty = true;
      } else {
        this.empty = false;
      }
      if (this.auth.userInfo.type == UserType.Guest) {
        console.log("unauthorized");
        this.router.navigateByUrl("login");
      }
    }
  }



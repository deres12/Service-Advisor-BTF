import { Component, OnInit } from '@angular/core';
import {Richiesta} from "../../models/richiesta";
import {TakeFornintoriService} from "../../services/take-fornintori.service";
import {User, UserType} from "../../models/user";
import {Router} from "@angular/router";
import {AddRequestService} from "../../services/add-request.service";
import {AuthService} from "../../services/auth.service";
import {Fornitore} from "../../models/fornitore";
import {Offerta} from "../../models/offerta";
import {LineChartConfig} from "../../models/LineChartConfig";
import {VisiteService} from "../../services/visite.service";
import {Visita} from "../../models/Visita";


@Component({
  selector: 'app-worker-page',
  templateUrl: './worker-page.component.html',
  styleUrls: ['./worker-page.component.css']
})
export class WorkerPageComponent implements OnInit {
  /*data1: any[];
  config1: LineChartConfig;
  elementId1: String;*/
  title = 'Reusable charts sample';

  user: User;
  richieste: Richiesta[] = [];
  fornitori: Fornitore[];
  offerte: Offerta[]=[];
  empty: boolean = true;
  pippo:Map<string, number>=new Map<string, number>();

  constructor(public auth: AuthService,
              public router: Router, private serv: TakeFornintoriService,
              public prova: AddRequestService) {
  }


  ngOnInit() {

    /*this.data1 = [["Giorno", "Click"],["",0]];




    this.config1 = new LineChartConfig("Visite Settimanali", '',{ position: 'bottom' });
    this.elementId1 = 'myLineChart1';
*/


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

    this.pippo.set("adfad",5);
    this.user = this.auth.userInfo;





  }
}



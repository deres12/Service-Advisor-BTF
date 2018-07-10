import {Component, Inject, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {User, UserType} from '../../models/user';
import {Router} from '@angular/router';
import {Fornitore} from "../../models/fornitore";
import {TakeFornintoriService} from "../../services/take-fornintori.service";
import {Richiesta} from "../../models/richiesta";
import {AddRequestService} from "../../services/add-request.service";
import {Offerta} from "../../models/offerta";
import {TakeRichiesteService} from "../../services/take-richieste.service";

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {
  //userType = UserType;
  user: User;
  richieste: Richiesta[] = [];
  fornitori: Fornitore[];
  offerte: Offerta[]=[];
  empty: boolean = true;
  emptyOfferte: boolean = true;

  constructor(public auth: AuthService,
              public router: Router, private serv: TakeFornintoriService,
              private servRichieste: TakeRichiesteService,
              public prova: AddRequestService) {
  }

  ngOnInit() {

    this.user = this.auth.userInfo;

    this.servRichieste.getRichiesteByCliente(this.auth.userInfo.email).subscribe((list: Richiesta[]) => {
      this.richieste = list;
      if (this.richieste.length>0)
        this.empty = false;
    }, (error) => {
      console.log(error.toString());
    });

    this.serv.getRichiesteByClientEmail(this.auth.userInfo.email).subscribe((list: Offerta[]) => {
      this.offerte = list;
      if (this.offerte.length>0)
        this.emptyOfferte = false;
    }, (error) => {
      console.log(error.toString());
    });

    if (this.auth.userInfo.type == UserType.Guest) {
      console.log("unauthorized");
      this.router.navigateByUrl("login");
    }
  }
}





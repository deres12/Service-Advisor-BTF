import {Component, Inject, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {User, UserType} from '../../models/user';
import {Router} from '@angular/router';
import {Fornitore} from "../../models/fornitore";
import {TakeFornintoriService} from "../../services/take-fornintori.service";
import {Richiesta} from "../../models/richiesta";
import {AddRequestService} from "../../services/add-request.service";

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
  empty: boolean = true;

  constructor(public auth: AuthService,
              public router: Router, private serv: TakeFornintoriService,
              public prova: AddRequestService) {
  }

  ngOnInit() {

    this.richieste = this.prova.richieste;


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





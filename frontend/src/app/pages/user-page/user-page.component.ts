import {Component, Inject, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {User, UserType} from '../../interfaces/user';
import {Router} from '@angular/router';
import {isStorageAvailable, LOCAL_STORAGE, WebStorageService} from "angular-webstorage-service";
import {Fornitore} from "../../interfaces/fornitore";
import {TakeFornintoriService} from "../../services/take-fornintori.service";
import {Richiesta} from "../../interfaces/richiesta";
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
    this.user = this.auth.userInfo;

    //this.richieste=this.prova.richieste;
    console.log(this.richieste.length);
    this.prova.richieste.forEach(item => {
      if (item.email == this.auth.userInfo.email) {
        this.richieste.push(item);
      }
    })
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





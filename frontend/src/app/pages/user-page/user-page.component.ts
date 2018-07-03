import {Component, Inject, OnInit} from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {User, UserType} from '../../interfaces/user';
import { Router } from '@angular/router';
import {isStorageAvailable, LOCAL_STORAGE, WebStorageService} from "angular-webstorage-service";
import {Fornitore} from "../../interfaces/fornitore";
import {TakeFornintoriService} from "../../services/take-fornintori.service";

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {
  //userType = UserType;
  user: User;
  fornitori: Fornitore[];

  constructor(@Inject(LOCAL_STORAGE) private storage: WebStorageService,
    public auth: AuthService,
    public router: Router, private serv: TakeFornintoriService) { }

  ngOnInit() {
    this.user=this.auth.userInfo;
    this.serv.getFornitori().subscribe((list: Fornitore[]) => {
      this.fornitori=list;
      this.storage.set("fornitori",[]);

      this.fornitori.forEach(item=>{
        this.storage.get("fornitori").push(this.fornitori.indexOf(item),item.email);
      });
      console.log(this.storage.get("fornitori"));
      console.log(this.storage);
      //this.storage.

    },(error)=>{
      console.log(error.toString());});
    if(this.auth.userType == UserType.Guest) {
      console.log("unauthorized");
      this.router.navigateByUrl("login");
    }
  }
}





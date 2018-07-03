import {Component, Inject, OnInit} from '@angular/core';
import {Fornitore} from "../../interfaces/fornitore";
import {TakeFornintoriService} from "../../services/take-fornintori.service";
import {LOCAL_STORAGE, WebStorageService} from "angular-webstorage-service";

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  fornitori: Fornitore[];
  constructor(@Inject(LOCAL_STORAGE) private storage: WebStorageService,
              private serv: TakeFornintoriService) { }

  ngOnInit() {
    this.serv.getFornitori().subscribe((list: Fornitore[]) => {
      this.fornitori=list;
    },(error)=>{
      console.log(error.toString());});
  }

}

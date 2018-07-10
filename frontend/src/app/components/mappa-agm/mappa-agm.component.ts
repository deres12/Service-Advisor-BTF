import { Component, OnInit } from '@angular/core';
import {Fornitore} from "../../models/fornitore";
import {Router} from "@angular/router";
import {TakeFornintoriService} from "../../services/take-fornintori.service";
import {AuthService} from "../../services/auth.service";
import {UserType} from "../../models/user";

@Component({
  selector: 'app-mappa-agm',
  templateUrl: './mappa-agm.component.html',
  styleUrls: ['./mappa-agm.component.css']
})
export class MappaAGMComponent implements OnInit {

  //title: string = 'My first AGM project';
  lat: number = 51.678418;
  lng: number = 7.809007;
  fornitori: Fornitore[];
  constructor(public serv: TakeFornintoriService, public router: Router, public auth: AuthService) { }

  ngOnInit() {
    this.serv.getFornitori().subscribe((list: Fornitore[]) => {

      this.fornitori = list;
    }, (error) => {
      console.log(error.toString());
    });
  }

  richiesta(email:string){
    if(this.auth.userType==UserType.Guest){
      this.router.navigate(["/signup"]);
    }else
      if(this.auth.userType==UserType.Client) {
      localStorage.setItem("emailfornitore",email);
        this.router.navigate(["/new-request"]);
      }

    }



}

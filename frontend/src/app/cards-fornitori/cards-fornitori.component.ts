import { Component, OnInit } from '@angular/core';
import {TakeFornintoriService} from "../services/take-fornintori.service";
import {Fornitore} from "../models/fornitore";

@Component({
  selector: 'app-cards-fornitori',
  templateUrl: './cards-fornitori.component.html',
  styleUrls: ['./cards-fornitori.component.css']
})
export class CardsFornitoriComponent implements OnInit {
  fornitori: Fornitore[];
  showFornit: Fornitore[];
  empty = false;


  constructor(public serv: TakeFornintoriService) {}

  ngOnInit() {
    this.serv.getFornitori().subscribe((list: Fornitore[]) => {
      this.fornitori=list;
      this.showFornit=list;
    },(error)=>{
      this.empty=true;
      console.log(error.toString());});
  }

}

import { Component, OnInit } from '@angular/core';
import {Fornitore} from "../../models/fornitore";
import {TakeFornintoriService} from "../../services/take-fornintori.service";

@Component({
  selector: 'app-ricerca',
  templateUrl: './ricerca.component.html',
  styleUrls: ['./ricerca.component.css']
})
export class RicercaComponent implements OnInit {

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

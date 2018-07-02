import { Component, OnInit } from '@angular/core';
import {Fornitore} from "../../services/fornitore";
import {TakeFornintoriService} from "../../services/take-fornintori.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  fornitori: Fornitore[];

  workers = [
    {nome: "tizio"    , professione: "Elettricista"},
    {nome: "caio"     , professione: "Idraulico"},
    {nome: "sempronio", professione: "Gommista"},
    {nome: "sempronio", professione: "Elettricista"},
    {nome: "tizio"    , professione: "Gommista"},
    {nome: "caio"     , professione: "Idraulico"},
    {nome: "sempronio", professione: "Gommista"},
    {nome: "tizio"    , professione: "Massaggiatore"},
    {nome: "caio"     , professione: "Disoccupato?"}
  ];

  constructor(private serv: TakeFornintoriService) { }

  ngOnInit() {
    this.serv.getFornitori().subscribe((list: Fornitore[]) => {
      this.fornitori=list;
    },(error)=>{console.log(error);});

  }

}

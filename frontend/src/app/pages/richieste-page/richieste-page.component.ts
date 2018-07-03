import { Component, OnInit } from '@angular/core';
import {Richiesta} from "../../interfaces/richiesta";
import {TakeRichiesteService} from "../../services/take-richieste.service";

@Component({
  selector: 'app-offerte-page',
  templateUrl: './richieste-page.component.html',
  styleUrls: ['./richieste-page.component.css']
})
export class RichiestePageComponent implements OnInit {

  richieste: Richiesta[];

  constructor(private serv: TakeRichiesteService) {
  }

  ngOnInit() {
    this.serv.getRichieste().subscribe((list: Richiesta[]) => {
      this.richieste = list;
    }, (error) => {
      console.log(error);
    });
  }

}

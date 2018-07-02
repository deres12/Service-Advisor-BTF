import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
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

  constructor() { }

  ngOnInit() {}

  filterByProf(){}


}

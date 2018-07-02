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
  showFornit: Fornitore[];

 /* workers = [
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
*/
  constructor(private serv: TakeFornintoriService) { }

  ngOnInit() {
    this.serv.getFornitori().subscribe((list: Fornitore[]) => {
      this.fornitori=list;
      this.showFornit=list;
    },(error)=>{console.log(error.toString());});

  }

  filterByProf(query: string){
    console.log(query);
    let re = new RegExp(query, "i");
    this.showFornit=[];
    this.fornitori.forEach(item => {
      if(re.test(item.nomeProfessione) || re.test(item.descrizione) || re.test(item.nome))
        this.showFornit.push(item);
    });
    console.log(this.showFornit.length);
    if(this.showFornit.length===0)
      this.showFornit=this.fornitori;

  }

}

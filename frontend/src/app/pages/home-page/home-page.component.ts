import {Component, OnInit, ViewChild} from '@angular/core';
import {Fornitore} from "../../services/fornitore";
import {TakeFornintoriService} from "../../services/take-fornintori.service";
import { } from '@types/googlemaps';
//import { Google } from 'http://maps.googleapis.com/maps/api/js';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  fornitori: Fornitore[];
  showFornit: Fornitore[];

  @ViewChild('gmap') gmapElement: any;
  map: google.maps.Map;

  constructor(private serv: TakeFornintoriService) {
    /*System.import("http://maps.googleapis.com/maps/api/js").then(refToLoadedModule => {
        refToLoadedModule.someFunction();
      }
    );*/
  }

  ngOnInit() {
    this.serv.getFornitori().subscribe((list: Fornitore[]) => {
      this.fornitori=list;
      this.showFornit=list;
    },(error)=>{console.log(error.toString());});
    var mapProp = {
      center: new google.maps.LatLng(18.5793, 73.8143),
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    this.map = new google.maps.Map(this.gmapElement.nativeElement, mapProp);

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

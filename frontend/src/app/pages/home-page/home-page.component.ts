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
  markers:any;
  latitude:number;

  longitude:number;



  setCenter(e:any){
    var myLatlng = new google.maps.LatLng(this.latitude, this.longitude);
    e.preventDefault();
    var marker = new google.maps.Marker({
      position: myLatlng,
      map: this.map,
      title: 'Click to zoom'
    });

    this.markers=marker;

    this.map.setCenter(new google.maps.LatLng(this.latitude, this.longitude));
    this.markers.setMap(this.map);

  }

  constructor(private serv: TakeFornintoriService) {
  }


  ngOnInit() {
    this.serv.getFornitori().subscribe((list: Fornitore[]) => {
      this.fornitori=list;
      this.showFornit=list;
    },(error)=>{console.log(error.toString());});

    var myLatlng = {lat: 45.4654666, lng: 9.2313484};
    var mapProp = {
      center: myLatlng,
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP,
      };

    var marker = new google.maps.Marker({
      position: myLatlng,
      map: this.map,
      title: 'Click to zoom'
    });
    //this.markers.push(marker);
    //mapProp.panTo(marker.getPosition());
    this.markers=marker;
    //console.log("PROVAAAAAA");
    this.map = new google.maps.Map(this.gmapElement.nativeElement, mapProp);
    this.markers.setMap(this.map);
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

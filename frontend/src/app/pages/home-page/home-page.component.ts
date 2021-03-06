import {Component, OnInit, ViewChild} from '@angular/core';

import {Fornitore} from "../../interfaces/fornitore";

import {TakeFornintoriService} from "../../services/take-fornintori.service";
import { } from '@types/googlemaps';
import {any} from "codelyzer/util/function";
import {Luogo} from "../../interfaces/luogo";
import {FornitorePlace} from "../../interfaces/fornitore-place";
//import { Google } from 'http://maps.googleapis.com/maps/api/js';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  fornitori: Fornitore[];
  showFornit: Fornitore[];
  fornitoriOnMap: FornitorePlace[];
  place:Luogo;

  @ViewChild('gmap') gmapElement: any;
  map: google.maps.Map;

  markerCenter:any;
  markers:any[];
  circle: any;
  radius: number=150.0;
  latitude:number;

  longitude:number;
  empty = false;



  setCenter(e:any){
    this.disableMarkersRadius();
    var myLatlng = new google.maps.LatLng(this.latitude, this.longitude);
    e.preventDefault();
    var marker = new google.maps.Marker({
      position: myLatlng,
      map: this.map,
      title: 'Click to zoom'
    });

    var circle = new google.maps.Circle({
      map: this.map,
      radius: this.radius,    // 10 miles in metres
      fillColor: '#347baa'
    });
    circle.bindTo('center', marker, 'position');
    this.circle=circle;
    this.markerCenter=marker;
    this.map.setCenter(new google.maps.LatLng(this.latitude, this.longitude));
    this.markerCenter.setMap(this.map);
  }






  constructor(private serv: TakeFornintoriService) {
  }

  disableMarkersRadius(){
    this.circle.setMap(null);
    this.markerCenter.setMap(null);
  }


  ngOnInit() {
    this.serv.getFornitori().subscribe((list: Fornitore[]) => {
      this.fornitori=list;
      this.showFornit=list;
    },(error)=>{
      this.empty=true;
      console.log(error.toString());});

    this.place={numeroCivico: 50,via: "giancarlo sismondi",paese:"Milano",nazione:"IT",latit:45.4654666, longit: 9.2313484, radius:150};

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
    var circle = new google.maps.Circle({
      map: this.map,
      radius: 150,    // 10 miles in metres
      fillColor: '#347baa'
    });
    this.markerCenter=marker;
    this.map = new google.maps.Map(this.gmapElement.nativeElement, mapProp);
    this.markerCenter.setMap(this.map);
    circle.bindTo('center', marker, 'position');
    this.circle=circle;
  }

  filterByProf(query: string) {
    console.log(query);
    let re = new RegExp(query, "i");
    this.showFornit = [];
    this.fornitori.forEach(item => {
      if (re.test(item.nomeProfessione) || re.test(item.descrizione) || re.test(item.nome))
        this.showFornit.push(item);
    });
    console.log(this.showFornit.length);
    if (this.showFornit.length === 0) {
      this.empty = true;
      this.showFornit = this.fornitori;
    } else {
      this.empty = false;
    }

  }

  setMarkerRadius(){
    this.disableMarkersRadius();
    var myLatlng = new google.maps.LatLng(this.latitude, this.longitude);
    var marker = new google.maps.Marker({
      position: myLatlng,
      map: this.map,
      title: 'Click to zoom'
    });
    var circle = new google.maps.Circle({
      map: this.map,
      radius: this.radius,    // 10 miles in metres
      fillColor: '#347baa'
    });
    circle.bindTo('center', marker, 'position');
    this.circle=circle;
    this.markerCenter=marker;
    this.map.setCenter(new google.maps.LatLng(this.latitude, this.longitude));
    this.markerCenter.setMap(this.map);
  }

  searchOnMap(){
    console.log(this.place.numeroCivico+" => "+this.place.via+" => "+this.place.paese+" => "+this.place.nazione)
    this.place.longit=0.0;
    this.place.latit=0.0;
    this.place.radius=this.radius;
    this.disableMarkersRadius();
    this.markers=[];
    this.serv.getFornitoriByAddress(this.place).subscribe((list: FornitorePlace[]) => {
      this.fornitoriOnMap=list;
      this.fornitoriOnMap.forEach(item=>{

        if(this.fornitoriOnMap[0].luogo===item.luogo){
          this.markerCenter=new google.maps.Marker({
            position: {lat: item.luogo.latit, lng: item.luogo.longit},
            map: this.map,
            title: 'Click to zoom'
          });
          this.latitude=item.luogo.latit;
          this.longitude=item.luogo.longit;
          var circle = new google.maps.Circle({
            map: this.map,
            radius: item.luogo.radius,    // 10 miles in metres
            fillColor: '#347baa'
          });
          this.markerCenter.setMap(this.map);
          circle.bindTo('center', this.markerCenter, 'position');
          this.circle=circle;
          this.map.setCenter(new google.maps.LatLng(this.latitude, this.longitude));
        }

        this.markers.push(new google.maps.Marker({
          position: {lat: item.luogo.latit, lng: item.luogo.longit},
          map: this.map,
          title: 'Click to zoom'
        }));
      });
      this.markers.forEach(item=>{
        item.setMap(this.map);
      });


    },(error)=>{
      console.log(error.toString());});
  }



}

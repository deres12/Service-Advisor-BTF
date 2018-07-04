import {Component, OnInit, ViewChild} from '@angular/core';
import {Luogo} from "../../interfaces/luogo";
import {FornitorePlace} from "../../interfaces/fornitore-place";
import {TakeFornintoriService} from "../../services/take-fornintori.service";
import {Fornitore} from "../../interfaces/fornitore";

@Component({
  selector: 'app-mappa',
  templateUrl: './mappa.component.html',
  styleUrls: ['./mappa.component.css']
})
export class MappaComponent implements OnInit {
  @ViewChild('gmap') gmapElement: any;
  map: google.maps.Map;
  fornitori: Fornitore[];
  fornitoriOnMap: FornitorePlace[];
  place:Luogo;
  markerCenter:any;
  markers:any[]=[];
  circle: any;
  radius: number=150.0;
  latitude:number;
  longitude:number;
  constructor(public serv: TakeFornintoriService) { }

  ngOnInit() {

    this.serv.getFornitori().subscribe((list: Fornitore[]) => {
      this.fornitori=list;
      this.fornitori.forEach(item=>{
        console.log("LATITUDINE===> "+item.latit);
        console.log("LONGITUDINE===> "+item.longit);
        this.markers.push(new google.maps.Marker({
          position: {lat: item.latit, lng: item.longit},
          map: this.map,
          title: 'Click to zoom'
        }));
        }

      )
    },(error)=>{
      console.log(error.toString());});


    this.place={numeroCivico: 50,via: "giancarlo sismondi",paese:"Milano",nazione:"IT",lat:45.4654666, longi: 9.2313484, radius:150};

    var mapProp = {
      center: {lat: 45.4654666, lng: 9.2313484},
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP,
    };

    var marker = new google.maps.Marker({
      position: {lat: 45.4654666, lng: 9.2313484},
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


  disableMarkersRadius(){
    this.circle.setMap(null);
    this.markerCenter.setMap(null);
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
    this.place.longi=0.0;
    this.place.lat=0.0;
    this.place.radius=this.radius;
    this.disableMarkersRadius();
    this.markers=[];
    this.serv.getFornitoriByAddress(this.place).subscribe((list: FornitorePlace[]) => {
      this.fornitoriOnMap=list;
      this.fornitoriOnMap.forEach(item=>{

        if(this.fornitoriOnMap[0].luogo===item.luogo){
          this.markerCenter=new google.maps.Marker({
            position: {lat: item.luogo.lat, lng: item.luogo.longi},
            map: this.map,
            title: 'Click to zoom'
          });
          this.latitude=item.luogo.lat;
          this.longitude=item.luogo.longi;
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
          position: {lat: item.luogo.lat, lng: item.luogo.longi},
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

import {Component, OnInit, ViewChild} from '@angular/core';
import {Luogo} from "../interfaces/luogo";
import {TakeFornintoriService} from "../services/take-fornintori.service";
import {FornitorePlace} from "../interfaces/fornitore-place";
import {Fornitore} from "../interfaces/fornitore";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {


  fornitori: any[];
  showFornit: Fornitore[];
  fornitoriOnMap: FornitorePlace[];
  place:Luogo;

  @ViewChild('gmap')

  gmapElement: any;
  map: google.maps.Map;

  markerCenter:any;
  markers:any[];
  marker: any;
  circle: any;
  radius: number=150.0;
  latitude:number;

  longitude:number;
  empty = false;

  prova: any;
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

  constructor(public serv: TakeFornintoriService) {}

  disableMarkersRadius(){
    this.circle.setMap(null);
    this.markerCenter.setMap(null);
  }

  ngOnInit() {
    this.serv.getFornitori().subscribe((list: Fornitore[]) => {

      this.fornitori=list;
      this.showFornit=list;
      console.log(list);
      console.log(this.fornitori);
      this.addMarkers(this.fornitori);
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





    var marker2 = new google.maps.Marker({
      position: {lat: 45.40000, lng:9.2313668},
      map: this.map,
      title: 'Click to zoom 2'
    });


   /*for(let fornitore of this.fornitori){
      var marker = new google.maps.Marker({
        position: {lat: fornitore.latit, lng:fornitore.longit},
        map: this.map,
        title: 'Click to zoom'
      });
    }; */



    var circle = new google.maps.Circle({
      map: this.map,
      radius: 150,    // 10 miles in metres
      fillColor: '#347baa'
    });
    this.marker=marker;
    this.markerCenter=marker;
    this.map = new google.maps.Map(this.gmapElement.nativeElement, mapProp);
    this.markerCenter.setMap(this.map);
    circle.bindTo('center', marker2, 'position');
    this.circle=circle;
  }

  addMarkers(fornitori : Fornitore[]){
    for(let fornitore of fornitori) {
      var longi=fornitore.longit;
      var lat=fornitore.latit;

      var marker = new google.maps.Marker({
        position: {lat: lat, lng: longi},
        map: this.map,
        title: 'Click to zoom'
      });
      this.markerCenter = marker;
      this.markerCenter.setMap(this.map);
    }
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

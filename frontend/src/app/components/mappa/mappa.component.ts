import {Component, OnInit, ViewChild} from '@angular/core';
import {Luogo} from "../../models/luogo";
import {FornitorePlace} from "../../models/fornitore-place";
import {Fornitore} from "../../models/fornitore";
import {TakeFornintoriService} from "../../services/take-fornintori.service";
import {Router} from "@angular/router";
import {$} from "protractor";

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
  constructor(public serv: TakeFornintoriService,public router: Router) { }

  provami(){
    console.log("SONO ENTRATOOOOOOO...");
    this.router.navigateByUrl("new-request");
  }
  ngOnInit() {

    this.serv.getFornitori().subscribe((list: Fornitore[]) => {
      this.fornitori=list;
      this.fornitori.forEach(item=>{
        var contentString = '<div id="content">'+
          '<div id="siteNotice">'+
          '</div>'+
          '<h1 id="firstHeading" class="firstHeading">'+item.nome+'</h1>'+
          '<div id="bodyContent">'+
          '<br>Professione: <strong>'+item.nomeProfessione+
          '</strong><p>Attribution: '+item.descrizione+
          '<br><br>' +
          '<a href="http://localhost/#/new-request">Chiedi preventivo</a>'+
          '<button style="margin-left: 5px" type="button" (click)="provami()" class="btn btn-info" >Chiedi preventivo</button-->'+
          '</div>' +
          '<br>'+
          '</div>';

        var infowindow = new google.maps.InfoWindow({
          content: contentString
        });
/*
        google.maps.event.addListener(marker, 'click', function() {
          infowindow.setContent(contentString);
          infowindow.open(this.map, this);
          var btn = $(contentString).findElement('#prova');
          console.log("premuto");
        });*/




        var marker=new google.maps.Marker({
          position: {lat: item.latit, lng: item.longit},
          map: this.map,
          title: 'Click to zoom'
        });

        marker.addListener('click', function() {
          infowindow.open(this.map, marker);
        });


        this.markers.push(marker);

        }

      );


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



    /*********************************************/
    var contentString = '<div id="content">'+
      '<div id="siteNotice">'+
      '</div>'+
      '<h1 id="firstHeading" class="firstHeading">Uluru</h1>'+
      '<div id="bodyContent">'+
      '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +
      'sandstone rock formation in the southern part of the '+
      'Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) '+
      'south west of the nearest large town, Alice Springs; 450&#160;km '+
      '(280&#160;mi) by road. Kata Tjuta and Uluru are the two major '+
      'features of the Uluru - Kata Tjuta National Park. Uluru is '+
      'sacred to the Pitjantjatjara and Yankunytjatjara, the '+
      'Aboriginal people of the area. It has many springs, waterholes, '+
      'rock caves and ancient paintings. Uluru is listed as a World '+
      'Heritage Site.</p>'+
      '<p>Attribution: Uluru, <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'+
      'https://en.wikipedia.org/w/index.php?title=Uluru</a> '+
      '(last visited June 22, 2009).</p>'+
      '</div>'+
      '</div>';

    var infowindow = new google.maps.InfoWindow({
      content: contentString
    });
    marker.addListener('click', function() {
      infowindow.open(this.map, marker);
    });

    /************************************************/



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


    },
    (error)=>console.log(error));
  }



}

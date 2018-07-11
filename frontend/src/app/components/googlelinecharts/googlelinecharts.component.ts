import {Component, Input, OnInit} from '@angular/core';
import {LineChartConfig} from "../../models/LineChartConfig";
import {GoogleLineChartService} from "../../services/google-line-chart.service";
import {Visita} from "../../models/Visita";
import {VisiteService} from "../../services/visite.service";
import {AuthService} from "../../services/auth.service";

declare var google: any;

@Component({
  selector: 'app-googlelinecharts',
  templateUrl: './googlelinecharts.component.html',
  styleUrls: ['./googlelinecharts.component.css']
})

export class GooglelinechartsComponent implements OnInit {

  config1 = new LineChartConfig("Visite Settimanali", '', {position: 'bottom'});
  elementId1 = 'myLineChart1';
  data1: any[] = [["Giorno", "Click"]];

  constructor(private _lineChartService: GoogleLineChartService, public visitato: VisiteService, public auth: AuthService) {
  }

  ngOnInit() {

    this.visitato.getVisite(this.auth.userInfo.email).subscribe((list: Visita[]) => {
      for (let i = 0; i < list.length; i++) {
        this.data1.push([list[i].dataStr, list[i].numero]);
        //console.log(list[i].dataStr, list[i].numero);
        this._lineChartService.BuildPieChart(this.elementId1, this.data1, this.config1);
      }

    }, (error) => {
      console.log(error);
    });


    console.log("unauthorized");


  }
}

import {Component, Input, OnInit} from '@angular/core';
import {PieChartConfig} from "../../models/PieChartConfig";
import {GooglePieChartService} from "../../services/google-pie-chart.service";

declare var google: any;

@Component({
  selector: 'app-googlecharts',
  templateUrl: './googlecharts.component.html',
  styleUrls: ['./googlecharts.component.css']
})
export class GooglechartsComponent implements OnInit {

  @Input() data: any[];
  @Input() config: PieChartConfig;
  @Input() elementId: string;

  constructor(private _pieChartService: GooglePieChartService) { }

  ngOnInit() {

    this._pieChartService.BuildPieChart(this.elementId, this.data, this.config);
  }

}

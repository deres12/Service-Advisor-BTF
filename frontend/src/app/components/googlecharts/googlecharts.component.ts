import {Component, Input, OnInit} from '@angular/core';
import {PieChartConfig} from "../../models/PieChartConfig";
import {GooglePieChartServiceService} from "../../services/google-pie-chart-service.service";

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

  constructor(private _pieChartService: GooglePieChartServiceService) { }

  ngOnInit() {

    this._pieChartService.BuildPieChart(this.elementId, this.data, this.config);
  }

}

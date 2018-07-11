import {Component, Input, OnInit} from '@angular/core';
import {LineChartConfig} from "../../models/LineChartConfig";
import {GoogleLineChartService} from "../../services/google-line-chart.service";

declare var google: any;

@Component({
  selector: 'app-googlelinecharts',
  templateUrl: './googlelinecharts.component.html',
  styleUrls: ['./googlelinecharts.component.css']
})

export class GooglelinechartsComponent implements OnInit {

  @Input() data: any[];
  @Input() config: LineChartConfig;
  @Input() elementId: string;

  constructor(private _lineChartService: GoogleLineChartService) { }

  ngOnInit() {
    this._lineChartService.BuildPieChart(this.elementId, this.data, this.config);

  }
}

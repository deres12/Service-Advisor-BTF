import { Injectable } from '@angular/core';
import {GoogleChartsBaseService} from "../models/GoogleChartsBaseService";
import {LineChartConfig} from "../models/LineChartConfig";

declare var google: any;

@Injectable({
  providedIn: 'root'
})
export class GoogleLineChartService extends GoogleChartsBaseService{

  constructor() { super(); }


  public BuildPieChart(elementId: string, data: any[], config: LineChartConfig) : void {
    var chartFunc = () => { return new google.visualization.LineChart(document.getElementById(elementId)); };
    var options = {
      title: config.title,
      curveType: config.curveType,
      legend: config.legend
    };

    this.buildChart(data, chartFunc, options);

}
}

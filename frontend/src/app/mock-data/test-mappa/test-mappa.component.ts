import { Component, OnInit } from '@angular/core';
import {PieChartConfig} from "../../models/PieChartConfig";
import {LineChartConfig} from "../../models/LineChartConfig";

@Component({
  selector: 'app-test-mappa',
  templateUrl: './test-mappa.component.html',
  styleUrls: ['./test-mappa.component.css']
})
export class TestMappaComponent implements OnInit {
  title = 'Reusable charts sample';

  data1: any[];
  config1: LineChartConfig;
  elementId1: String;
  data2: any[];
  config2: PieChartConfig;
  elementId2: String;



  ngOnInit(): void {

    //Piechart1 Data & Config
    this.data1 = [
      ['Year', 'Sales', 'Expenses'],
      ['2004',  100,      40],
      ['2005',  117,      46],
      ['2006',  66,       112],
      ['2007',  103,      54]
    ];

    this.config1 = new LineChartConfig('ESEMPIOOOOO 1', 'function',{ position: 'bottom' });
    this.elementId1 = 'myLineChart1';



    this.data2 = [['Task', 'Hours per Day'],
      ['Work',     11],
      ['Eat',      2],
      ['Commute',  2],
      ['Watch TV', 2],
      ['Sleep',    7]]

    this.config2 = new PieChartConfig('My Daily Activities at 30 years old', 0.4);
    this.elementId2 = 'myPieChart2';

  }
}

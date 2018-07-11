export class LineChartConfig {
  title: string;
  curveType: string;
  legend: any;


  constructor(title: string, curveType: string,legend:any) {
    this.title = title;
    this.curveType = curveType;
    this.legend=legend;
  }
}


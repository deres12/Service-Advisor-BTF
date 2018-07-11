import { TestBed, inject } from '@angular/core/testing';

import { GooglePieChartService } from './google-pie-chart.service';

describe('GooglePieChartService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GooglePieChartService]
    });
  });

  it('should be created', inject([GooglePieChartService], (service: GooglePieChartService) => {
    expect(service).toBeTruthy();
  }));
});

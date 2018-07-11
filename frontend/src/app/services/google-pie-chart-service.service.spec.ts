import { TestBed, inject } from '@angular/core/testing';

import { GooglePieChartServiceService } from './google-pie-chart-service.service';

describe('GooglePieChartServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GooglePieChartServiceService]
    });
  });

  it('should be created', inject([GooglePieChartServiceService], (service: GooglePieChartServiceService) => {
    expect(service).toBeTruthy();
  }));
});

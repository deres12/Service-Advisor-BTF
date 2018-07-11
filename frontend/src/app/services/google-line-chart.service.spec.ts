import { TestBed, inject } from '@angular/core/testing';

import { GoogleLineChartService } from './google-line-chart.service';

describe('GoogleLineChartService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GoogleLineChartService]
    });
  });

  it('should be created', inject([GoogleLineChartService], (service: GoogleLineChartService) => {
    expect(service).toBeTruthy();
  }));
});

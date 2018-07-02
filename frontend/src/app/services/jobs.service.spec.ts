import { TestBed, inject } from '@angular/core/testing';

import { JobsDataService } from './jobs.service';

describe('JobsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [JobsDataService]
    });
  });

  it('should be created', inject([JobsDataService], (service: JobsDataService) => {
    expect(service).toBeTruthy();
  }));
});

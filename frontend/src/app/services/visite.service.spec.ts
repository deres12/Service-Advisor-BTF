import { TestBed, inject } from '@angular/core/testing';

import { VisiteService } from './visite.service';

describe('VisiteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [VisiteService]
    });
  });

  it('should be created', inject([VisiteService], (service: VisiteService) => {
    expect(service).toBeTruthy();
  }));
});

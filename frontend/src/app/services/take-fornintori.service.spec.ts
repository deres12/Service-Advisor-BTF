import { TestBed, inject } from '@angular/core/testing';

import { TakeFornintoriService } from './take-fornintori.service';

describe('TakeFornintoriService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TakeFornintoriService]
    });
  });

  it('should be created', inject([TakeFornintoriService], (service: TakeFornintoriService) => {
    expect(service).toBeTruthy();
  }));
});

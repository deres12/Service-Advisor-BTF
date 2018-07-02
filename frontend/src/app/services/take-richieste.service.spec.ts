import { TestBed, inject } from '@angular/core/testing';

import { TakeRichiesteService } from './take-richieste.service';

describe('TakeRichiesteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TakeRichiesteService]
    });
  });

  it('should be created', inject([TakeRichiesteService], (service: TakeRichiesteService) => {
    expect(service).toBeTruthy();
  }));
});

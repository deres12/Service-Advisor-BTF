import { TestBed, inject } from '@angular/core/testing';

import { AddRequestService } from './add-request.service';

describe('AddRequestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AddRequestService]
    });
  });

  it('should be created', inject([AddRequestService], (service: AddRequestService) => {
    expect(service).toBeTruthy();
  }));
});

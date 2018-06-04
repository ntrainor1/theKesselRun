import { TestBed, inject } from '@angular/core/testing';

import { CrewService } from './crew.service';

describe('CrewService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CrewService]
    });
  });

  it('should be created', inject([CrewService], (service: CrewService) => {
    expect(service).toBeTruthy();
  }));
});

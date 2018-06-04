import { TestBed, inject } from '@angular/core/testing';

import { CrewmemberService } from './crewmember.service';

describe('CrewmemberService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CrewmemberService]
    });
  });

  it('should be created', inject([CrewmemberService], (service: CrewmemberService) => {
    expect(service).toBeTruthy();
  }));
});

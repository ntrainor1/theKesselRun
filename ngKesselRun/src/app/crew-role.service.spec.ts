import { TestBed, inject } from '@angular/core/testing';

import { CrewRoleService } from './crew-role.service';

describe('CrewRoleService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CrewRoleService]
    });
  });

  it('should be created', inject([CrewRoleService], (service: CrewRoleService) => {
    expect(service).toBeTruthy();
  }));
});

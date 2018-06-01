import { CrewMemberModule } from './crew-member.module';

describe('CrewMemberModule', () => {
  let crewMemberModule: CrewMemberModule;

  beforeEach(() => {
    crewMemberModule = new CrewMemberModule();
  });

  it('should create an instance', () => {
    expect(crewMemberModule).toBeTruthy();
  });
});

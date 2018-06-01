import { CrewModule } from './crew.module';

describe('CrewModule', () => {
  let crewModule: CrewModule;

  beforeEach(() => {
    crewModule = new CrewModule();
  });

  it('should create an instance', () => {
    expect(crewModule).toBeTruthy();
  });
});

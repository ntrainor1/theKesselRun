import { RoleModule } from './../role/role.module';
import { CrewModule } from './../crew/crew.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: []
})
export class CrewMemberModule {
  id: number;
  name: string;
  crew: CrewModule;
  role: RoleModule;

    constructor(id: number, name: string, crew: CrewModule, role: RoleModule) {
      this.id = id;
      this.name = name;
      this.crew = crew;
      this.role = role;
    }


}

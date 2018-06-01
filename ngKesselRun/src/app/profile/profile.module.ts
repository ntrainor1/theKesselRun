import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserModule } from '../user/user.module';
import { ItemModule } from '../item/item.module';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: []
})
export class ProfileModule {

  id: number;
  imageUrl: string;
  name: string;
  credits: number;
  species: string;
  user: UserModule;
  items: ItemModule[];

  constructor(id: number, imageUrl: string, name: string, credits: number, species: string, user: UserModule, items: ItemModule[] ) {
    this.id = id;
    this.imageUrl = imageUrl;
    this.name = name;
    this.credits = credits;
    this.species = species;
    this.user = user;
    this.items = items;

  }
}

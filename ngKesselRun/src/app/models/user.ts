import { Inventory } from './inventory';

export class User {
  id: number;
  username: string;
  password: string;
  role: string;
  enabled: boolean;
  imageUrl: string;
  credits: number;
  species: string;
  inventory: Inventory;

  constructor(id?: number, username?: string, password?: string, role?: string, enabled?: boolean, imageUrl?: string,
    credits?: number, species?: string, inventory?: Inventory) {

    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
    this.enabled = enabled;
    this.imageUrl = imageUrl;
    this.credits = credits;
    this.species = species;
    this.inventory = inventory;
  }
}

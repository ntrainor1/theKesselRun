export class User {
  id: number;
  username: string;
  password: string;
  role: boolean;
  enabled: boolean;
  image_url: string;
  credits: number;
  species: string;

  constructor(id?: number, username?: string, password?: string, role?: boolean, enabled?: boolean, image_url?: string,
    credits?: number, species?: string) {

    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
    this.enabled = enabled;
    this.image_url = image_url;
    this.credits = credits;
    this.species = species;

  }
}

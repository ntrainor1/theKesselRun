export class User {
  id: number;
  username: string;
  password: string;
  admin: boolean;
  active: boolean;
  constructor(id?: number, username?: string, password?: string, admin?: boolean, active?: boolean) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.admin = admin;
    this.active = active;
  }
}

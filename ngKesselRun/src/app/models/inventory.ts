import { User } from './user';
import { Item } from './item';

export class Inventory {
  id: number;
  user: User;
  item: Item;
  constructor(id?: number, user?: User, item?: Item) {
    this.id = id;
    this.user = user;
    this.item = item;
  }
}

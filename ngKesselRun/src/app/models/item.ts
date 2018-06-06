import { Category } from './category';
import { User } from './user';
export class Item {

  id: number;
  name: string;
  description: string;
  imageUrl: string;
  price: number;
  category: Category;
  user: User;
  constructor(id?: number, name?: string, description?: string, imageUrl?: string, price?: number, category?: Category, user?: User) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.imageUrl = imageUrl;
    this.price = price;
    this.category = category;
    this.user = user;
  }

}

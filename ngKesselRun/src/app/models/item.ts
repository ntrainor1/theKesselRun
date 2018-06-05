import { Category } from './category';
export class Item {

  id: number;
  name: string;
  description: string;
  imageUrl: string;
  price: number;
  category: Category;
  constructor(id?: number, name?: string, description?: string, imageUrl?: string, price?: number, category?: Category) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.imageUrl = imageUrl;
    this.price = price;
    this.category = category;
  }

}

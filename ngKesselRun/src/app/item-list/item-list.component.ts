import { Inventory } from './../models/inventory';
import { ProfileComponent } from './../profile/profile.component';
import { CartService } from './../cart.service';
import { Category } from './../models/category';
import { ItemService } from './../item.service';
import { Component, OnInit } from '@angular/core';
import { Item } from '../models/item';
import { Router } from '@angular/router';
import { CategoryService } from '../category.service';
import { Cart } from '../models/cart';
import { User } from '../models/user';
import { UserService } from '../user.service';
import { InventoryService } from '../inventory.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})


export class ItemListComponent implements OnInit {

  editItem: Item = null;
  items: Item[] = [];
  selected: Item = null;
  newItem = null;
  user = new User();

  show(id) {
    this.itemService.show(id).subscribe(
      data => this.selected = data,
      err => {
        console.log('Unable to load item');
        this.router.navigateByUrl('not-found');
      }
    );

  }

  addItem(item) {
    this.user.username = localStorage.getItem('username');
    console.log(this.newItem);
    item.user = this.user;
    this.itemService.create(this.newItem).subscribe(
      data => {
        // this.addNewItemToInventory(data, this.user);
        this.reload();
      },

      err => {
        console.log('Unable to create item');
        this.router.navigateByUrl('not-found');
      }
    );
    this.newItem = null;
  }

  getCategoryThenAdd(id: number) {
    console.log('in getCategoryById');
    let category: Category;
    this.catService.show(id).subscribe(
      data => {
        console.log(data);
        this.newItem.category = data;
        category = data;
        this.addItem(this.newItem);
      },
      err => console.log(err)
    );
  }

  setUpCreateDiv() {
    this.newItem = new Item();
  }

  addItemToCart(item, cart) {
    console.log('In addItemToCart');
    this.itemService.addingToCart(item, cart).subscribe(
      data => {
        this.reload();
      },

      err => {
        console.log('Unable to add item to cart');
        this.router.navigateByUrl('not-found');
      }
    );
  }

  getCartThenAdd(item: Item) {
    console.log(item);
    console.log('in getCartThenAdd');
    console.log(localStorage.getItem('username'));
    let cart: Cart;
    this.cartService.showByUsername(localStorage.getItem('username')).subscribe(
      data => {
        this.profileComp.reload();
        console.log(data);
        cart = data;
        this.addItemToCart(item, cart);
      },
      err => console.log(err)
    );
  }

  update (item) {
    this.itemService.update(item).subscribe(
      data => {
        this.reload();
        this.selected = data;
        this.editItem = null;
      },
      err => {
        console.log('Unable to edit item');
        this.router.navigateByUrl('not-found');
      }
    );
  }
  addNewItemToInventory(item: Item, user: User) {
    const inventory = new Inventory;
    inventory.item = item;
    inventory.user = user;
    console.log(inventory);

    this.inventoryService.create(inventory).subscribe(
      data => console.log('Added item to inventory'),
      err => console.log('error creating inventory')
    );
  }

  delete(id) {
    this.itemService.destroy(id).subscribe(
      data => this.reload(),
      err => console.log('Unable to delete item')
    );
  }

  reload() {
    this.userService.show(localStorage.getItem('username')).subscribe(
      data => {this.user = data;
              console.log(data);
      },
      err => console.log(err)
   );
    this.itemService.index().subscribe(
      data => {
        this.items = data;
        console.log(this.items);
      },
      err => {
        console.log('Unable to load items');
        this.router.navigateByUrl('not-found');
      }
    );
  }

  hideAdd() {
    this.newItem = null;
  }

  constructor(private itemService: ItemService,
    private categoryService: CategoryService,
    private router: Router,
    private profileComp: ProfileComponent,
    private catService: CategoryService, private cartService: CartService,
    private userService: UserService, private inventoryService: InventoryService) { }

  ngOnInit() {
    this.reload();
    console.log(this.items);

  }
}

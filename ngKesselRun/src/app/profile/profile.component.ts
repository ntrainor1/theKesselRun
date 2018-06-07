import { Category } from './../models/category';
import { CategoryService } from './../category.service';
import { CartService } from './../cart.service';
import { CartItem } from './../models/cart-item';
import { HomeComponent } from './../home/home.component';
import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Item } from '../models/item';
import { ItemService } from '../item.service';
import { InventoryService } from '../inventory.service';
import { Inventory } from '../models/inventory';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  // FIELDS
  audio = new Audio();
  cartTotal: number;
  inventoryItems: Item[];
  user = new User();
  updatedUser = new User();
  cartItems: CartItem[] = [];
  editItem: Item = null;
  items: Item[] = [];
  selected: Item = null;
  showUpdateForm = null;
  showAllItems = null;
  showUserItems = null;
  newItem = null;


  // DISPLAY METHODS
  hideAdd() {
    this.newItem = null;
  }
  showProfile() {
    this.reload();
    this.hideUpdate();
    this.hideAllItemsList();
    this.hideUserItems();
  }
  showUpdate() {
    this.hideAllItemsList();
    this.showUserItems = null;
    this.showUpdateForm = true;
  }
  showAllItemsList() {
    this.hideUpdate();
    this.showAllItems = true;
  }
  hideAllItemsList() {
    this.showAllItems = null;
  }
  hideUpdate() {
    this.showUpdateForm = null;
  }
  hideUserItems() {
    this.showUserItems = null;
  }
  showAllUserItems() {
    this.showUserItems = true;
    this.getInventoryItems();
    this.inventoryService.index();
    this.hideUpdate();
    this.hideAllItemsList();
  }
  // CRUDS
  show(id) {
    this.itemService.show(id).subscribe(
      data => this.selected = data,
      err => {
        console.log('Unable to load item');
        this.router.navigateByUrl('notFound');
      }
    );


  }
  reload() {
    this.user.username = localStorage.getItem('username');
    this.userService.show(this.user.username).subscribe(
      data => {
        this.user = data;
        this.getCart(this.user.id);
        console.log(this.cartItems);
      },
      err => console.log('Could not load user')
    );

    this.itemService.index().subscribe(
      data => {
        this.items = data;
        this.getCart(this.user.id);
        console.log(this.cartItems);
      },
      err => {
        console.log('Unable to load items');
        this.router.navigateByUrl('notFound');
      }
    );
  }
  addItem(item) {
    this.addNewItemToInventory(item, this.user);
    this.itemService.create(this.newItem).subscribe(
      data => {
        // this.addNewItemToInventory(item, this.user);
        this.reload();
      },
      err => {
        console.log('Unable to create item');
        this.router.navigateByUrl('notFound');
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
        this.reload();
      },
      err => console.log(err)
    );
  }

  setUpCreateDiv() {
    this.newItem = new Item();
  }
  updateUser() {
    if (this.updatedUser.imageUrl) {
      this.user.imageUrl = this.updatedUser.imageUrl;
    }
    this.user.species = this.updatedUser.species;
    console.log(this.updatedUser);
    this.userService.update(this.user).subscribe(
      data => {
        console.log(data);
        this.hideAllItemsList();
        this.hideUpdate();
        this.router.navigateByUrl('profile');
      },
      err => console.log(err)
    );
  }
  getCart(userId) {
    console.log('in getCart');
    console.log(userId);
    this.cartItems = [];
    this.cartTotal = 0;
    this.cartService.getCartItems(userId).subscribe(
      cartItems => cartItems.forEach(cartItem => {
          this.cartItems.push(cartItem);
          this.cartTotal = this.cartTotal + cartItem.item.price;
          console.log(this.cartTotal);

      }),
      err => console.log('Error loading cart')
    );
  }
  checkForSufficientCredits() {
    if (this.user.credits < this.cartTotal) {
      return false;
    } else {
      return true;
    }
  }
  checkoutCart() {
    console.log('in Checkout Cart');
    console.log(this.cartItems);
    this.cartItems.forEach(cartItem => {
      this.cartService.checkoutCart(this.user.id, cartItem).subscribe(
        data => {
          console.log('checked out item ' + cartItem);
          this.getCart(this.user.id);
          this.showUserItems = true;
          this.showAllItems = false;
          this.getInventoryItems();
        },
        err => console.log(err)
      );
    });
    this.reload();
  }

  getInventoryItems() {
    this.inventoryService.show(this.user.username).subscribe(
      data => {
        this.inventoryItems = data;
        console.log(data);
      },
      err => console.log(err)
    );
  }

  getCategoryById(id: number) {
    let category: Category;
    this.catService.show(id).subscribe(
      data => category = data,
      err => console.log(err)
    );
  }
  deleteUser() {
    this.userService.destroy(this.user.id).subscribe(
      data => this.router.navigateByUrl('home'),
      err => console.log(err)
    );
  }
  logout() {
    this.audio.pause();
    this.authServ.logout();
    this.router.navigateByUrl('home');
    console.log('logged out');
    this.user = null;
    localStorage.removeItem('username');
  }
  removeItemFromCart(cartItem) {
    this.cartService.removeCartItem(cartItem).subscribe(
      data => this.reload(),
      err => console.log(err)
    );
  }
  playMusic() {
    this.audio.src = 'https://archive.org/download/StarWarsCantinaBand12/Star%20Wars%20Cantina%20Band%201%202.mp3';
    this.audio.load();
    this.audio.play();
  }
  addNewItemToInventory(item: Item, user: User) {
    const inventory = new Inventory();
    inventory.item = item;
    inventory.user = user;
    this.inventoryService.create(inventory).subscribe(
      data => console.log('Added item to inventory'),
      err => console.log(err)
    );
  }
  constructor(private itemService: ItemService, private inventoryService: InventoryService,
    private cartService: CartService, private authServ: AuthService, private catService: CategoryService,
     private router: Router, private userService: UserService, private home: HomeComponent) { }

  ngOnInit() {
    this.user.username = localStorage.getItem('username');
    this.userService.show(this.user.username).subscribe(
      data => {
        this.user = data;
          this.getCart(this.user.id);
          console.log(this.cartItems);
          this.playMusic();
      },
      err => console.log('Could not load user')
    );
  }

}

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
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user = new User();
  updatedUser = new User();
  cartItems: CartItem[] = [];
  showUpdateForm = null;
  showAllItems = null;
  showProfile() {
    this.hideUpdate();
    this.hideAllItemsList();
  }
  showUpdate() {
    this.hideAllItemsList();
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
    this.cartService.getCartItems(userId).subscribe(
      cartItems => cartItems.forEach(cartItem => {
          this.cartItems.push(cartItem);
      }),
      err => console.log('Error loading cart')
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
    // console.log(this.user.id);
  }
  logout() {
    this.authServ.logout();
    this.router.navigateByUrl('home');
    console.log('logged out');
  }
  constructor(private cartService: CartService, private authServ: AuthService, private catService: CategoryService,
     private router: Router, private userService: UserService, private home: HomeComponent) { }

  ngOnInit() {
    this.user.username = localStorage.getItem('username');
    this.userService.show(this.user.username).subscribe(
      data => {
        this.user = data;
          this.getCart(this.user.id);
          console.log(this.cartItems);

      },
      err => console.log('Could not load user')
    );
  }
}

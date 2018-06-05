import { HomeComponent } from './../home/home.component';
import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user = new User();
  updatedUser = new User();
  showUpdateForm = null;
  showAllItems = null;
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
        this.router.navigateByUrl('profile');
      },
      err => console.log(err)
    );
  }
  constructor(private router: Router, private userService: UserService, private home: HomeComponent) { }

  ngOnInit() {
    this.user.username = localStorage.getItem('username');
    this.userService.show(this.user.username).subscribe(
      data => this.user = data,
      err => console.log('Could not load user')
    );
  }
}

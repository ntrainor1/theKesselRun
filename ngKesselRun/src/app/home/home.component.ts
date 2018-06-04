import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { UserService } from '../user.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  showLoginForm = null;
  showCreateForm = null;
  username = '';
  password = '';
  user = new User();
  login(username, password) {
    console.log(username);
    console.log(password);
  }
  createUser(user) {
    this.userService.create(user).subscribe(
      data => console.log(user),
      err => console.log(err)
    );
  }
  // DISPLAY AND HIDE METHODS
  showLogin() {
    this.hideCreate();
    this.showLoginForm = true;
  }
  showCreate() {
    this.hideLogin();
    this.showCreateForm = true;
  }
  hideLogin() {
    this.showLoginForm = null;
  }
  hideCreate() {
    this.showCreateForm = null;
  }

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

}

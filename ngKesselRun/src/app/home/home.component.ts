import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { UserService } from '../user.service';
import { AuthService } from '../auth.service';
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

    this.authService.login(username, password);
  }
  createUser(user) {
    // user = this.userService.create(user).subscribe(
    //   data => {
    //     console.log(user);
    //     this.user = data;
    //     console.log(this.user);
    //     this.router.navigateByUrl('profile');
    //   },
    //   err => console.log(err)
    // );

    console.log(user);

    this.authService.register(user);
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

  constructor(private userService: UserService, private router: Router, private authService: AuthService) { }

  ngOnInit() {
  }

  returnUser() {
    return this.user;
  }
}

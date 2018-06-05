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

    this.authService.login(username, password).subscribe(
      data => {
        console.log('Log in successful');
        console.log('Check tokens');
        this.router.navigateByUrl('profile');
       },
      err => console.log(err)
    );
  }
  createUser(user) {
    this.authService.register(user).subscribe(
        data => {
          console.log(user);
          this.router.navigateByUrl('profile');
        },
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
  goNotFound() {
    this.router.navigateByUrl('not-found');
  }

  returnUser() {
    return this.user;
  }
  constructor(private userService: UserService, private router: Router, private authService: AuthService) { }

  ngOnInit() {
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  showLoginForm = null;
  showCreateForm = null;
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

  constructor(private router: Router) { }

  ngOnInit() {
  }

}

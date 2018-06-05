import { HomeComponent } from './../home/home.component';
import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user = new User();


  updateUser(user) {
    this.userService.update(user);
  }
  constructor(private userService: UserService, private home: HomeComponent) { }

  ngOnInit() {
    this.user = this.home.returnUser();
    console.log(this.user);
  }
}

import { HomeComponent } from './../home/home.component';
import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user = new User();

  constructor(private userService: UserService, private home: HomeComponent) { }

  ngOnInit() {
    this.user = this.home.returnUser();
    console.log(this.user);
  }

  updateUser(user) {
    this.user.username = user.username;
    this.user.password = user.password;
    this.userService.update(this.user).subscribe(
      data => console.log('user updated'),
      error => console.log('error updating user')
    );
  }
}

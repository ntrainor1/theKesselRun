import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-music',
  templateUrl: './music.component.html',
  styleUrls: ['./music.component.css']
})
export class MusicComponent implements OnInit {
  audio = new Audio();

  constructor() { }

  ngOnInit() {
    this.audio = new Audio();
    this.audio.src = 'https://ia801703.us.archive.org/15/items/StarWarsThemeSongByJohnWilliams/'
    + 'Star%20Wars%20Theme%20Song%20By%20John%20Williams.mp3';
    this.audio.load();
    this.audio.play();
  }

}

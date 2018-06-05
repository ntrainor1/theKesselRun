import { ItemService } from './../item.service';
import { Component, OnInit } from '@angular/core';
import { Item } from '../models/item';
import { Router } from '@angular/router';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})


export class ItemListComponent implements OnInit {

  editItem: Item;
  items: Item[] = [];
  selected: Item;

  constructor(private itemService: ItemService, private router: Router) { }

  ngOnInit() {
    this.reload();
    console.log(this.items);

  }

  show(id) {
    this.itemService.show(id).subscribe(
      data => this.selected = data,
      err => {
        console.log('Unable to load item');
        this.router.navigateByUrl('notFound');
      }
    );


  }

  update (item) {
    this.itemService.update(item).subscribe(
      data => {
        this.reload();
        this.selected = data;
        this.editItem = null;
      },
      err => {
        console.log('Unable to edit item');
        this.router.navigateByUrl('notFound');
      }
    );
  }

  delete(id) {
    this.itemService.destroy(id).subscribe(
      data => this.reload(),
      err => console.log('Unable to delete item')
    );
  }
  reload() {
    this.itemService.index().subscribe(
      data => {
        this.items = data;
        console.log(this.items);
      },
      err => {
        console.log('Unable to load items');
        this.router.navigateByUrl('notFound');
      }
    );
  }
}

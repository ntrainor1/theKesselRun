import { Category } from './../models/category';
import { ItemService } from './../item.service';
import { Component, OnInit } from '@angular/core';
import { Item } from '../models/item';
import { Router } from '@angular/router';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})


export class ItemListComponent implements OnInit {

  editItem: Item = null;
  items: Item[] = [];
  selected: Item = null;
  newItem = null;


  show(id) {
    this.itemService.show(id).subscribe(
      data => this.selected = data,
      err => {
        console.log('Unable to load item');
        this.router.navigateByUrl('notFound');
      }
    );


  }

  addItem(item) {
    // this.newItem;
    console.log(this.newItem);
    this.itemService.create(this.newItem).subscribe(
      data => {
        this.reload();
      },

      err => {
        console.log('Unable to create item');
        this.router.navigateByUrl('notFound');
      }
    );
    this.newItem = null;
  }
  getCategoryThenAdd(id: number) {
    console.log('in getCategoryById');
    let category: Category;
    this.catService.show(id).subscribe(
      data => {
        console.log(data);
        this.newItem.category = data;
        category = data;
        this.addItem(this.newItem);
      },
      err => console.log(err)
    );
  }

  setUpCreateDiv() {
    this.newItem = new Item();
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
  hideAdd() {
    this.newItem = null;
  }
  constructor(private itemService: ItemService,
     private categoryService: CategoryService, private router: Router, private catService: CategoryService) { }

  ngOnInit() {
    this.reload();
    console.log(this.items);

  }
}

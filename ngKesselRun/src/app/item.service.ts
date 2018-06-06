import { User } from './models/user';
import { CartItem } from './models/cart-item';
import { Item } from './models/item';
import { AuthService } from './auth.service';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Cart } from './models/cart';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  private url = 'http://localhost:8080/api/items';
  private items = [];

  index() {
    return this.http.get<Item[]>(this.url)
        .pipe(
            catchError((err: any) => {
              console.log(err);
              return throwError('KABOOM');
            })
        );
  }
  show(id) {
    return this.http.get<Item>(this.url + '/' + id, this.getHeaders())
        .pipe(
            catchError((err: any) => {
              console.log(err);
              return throwError('KABOOM');
            })
        );
  }
  create(item: Item) {
    console.log('in item service');
    return this.http.post<Item>(this.url, item)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }
  addingToCart(item: Item, cart: Cart) {
    console.log('in item service');
    const cartItem = new CartItem();
    cartItem.item = item;
    cartItem.cart = cart;
    console.log(cartItem);

    return this.http.post<Item>('http://localhost:8080/api/cartitems/' + item.id + '/' + cart.id, cartItem)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }
  update(item) {
    // set the local auth header token
    const token = this.authServ.getToken();
    const headers = new HttpHeaders()
        .set('Authorization', `Basic ${token}`);
    if (!this.authServ.checkLogin()) {
      this.router.navigateByUrl('/login');
    }
    return this.http.put<Item>(this.url + '/' + item.id, item, {headers})
        .pipe(
          catchError((err: any) => {
            console.log(err);
            return throwError('KABOOM');
          })
        );
  }
  destroy(id) {
    return this.http.delete(this.url + '/' + id)
        .pipe(
          catchError((err: any) => {
            console.log(err);
            return throwError('KABOOM');
          })
        );
  }

  getHeaders() {
    const token = this.authServ.getToken();
    const headers = new HttpHeaders()
      .set('Authorization', `Basic ${token}`);
      return {headers};
  }
  constructor(private authServ: AuthService, private http: HttpClient, private router: Router) { }
}

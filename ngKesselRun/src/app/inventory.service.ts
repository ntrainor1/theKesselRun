import { User } from './models/user';
import { Inventory } from './models/inventory';
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
export class InventoryService {
  private url = 'http://localhost:8080/api/inventories';
  private items = [];

  index() {
    return this.http.get<Inventory[]>(this.url)
        .pipe(
            catchError((err: any) => {
              console.log(err);
              return throwError('KABOOM');
            })
        );
  }
  show(id) {
    return this.http.get<Inventory>(this.url + '/' + id, this.getHeaders())
        .pipe(
            catchError((err: any) => {
              console.log(err);
              return throwError('KABOOM');
            })
        );
  }
  create(item: Inventory) {
    console.log('in item service');
    return this.http.post<Inventory>(this.url, item)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }
  update(inventory) {
    // set the local auth header token
    const token = this.authServ.getToken();
    const headers = new HttpHeaders()
        .set('Authorization', `Basic ${token}`);
    if (!this.authServ.checkLogin()) {
      this.router.navigateByUrl('/login');
    }
    return this.http.put<Inventory>(this.url + '/' + inventory.id, inventory, {headers})
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

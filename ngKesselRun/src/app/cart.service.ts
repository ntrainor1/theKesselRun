import { Cart } from './models/cart';
import { Injectable } from '@angular/core';
import { User } from './models/user';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private url = 'http://localhost:8080/api/carts';
  private cart = new Cart();

  index() {
    return this.http.get<User[]>(this.url)
        .pipe(
            catchError((err: any) => {
              console.log(err);
              return throwError('KABOOM');
            })
        );
  }
  show(userId) {
    return this.http.get<User>('http://localhost:8080/api/cartitems/' + userId)
        .pipe(
            catchError((err: any) => {
              console.log(err);
              return throwError('KABOOM');
            })
        );
  }
  create(user: User) {
    console.log('in user service');
    return this.http.post<User>(this.url, user)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }
  update(user) {
    // set the local auth header token
    const localUn = localStorage.getItem('username');
    user.username = localUn;
    const token = this.authServ.getToken();
    const headers = new HttpHeaders()
        .set('Authorization', `Basic ${token}`);
    if (!this.authServ.checkLogin()) {
      this.router.navigateByUrl('/login');
    }
    console.log('in update method in service');
    return this.http.put<User>(this.url + '/' + user.id, user, {headers})
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
  constructor(private authServ: AuthService, private http: HttpClient, private router: Router) { }
}

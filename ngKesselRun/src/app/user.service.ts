import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './models/user';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { AuthService } from './auth.service';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  // private url = 'http://localhost:8080/api/users';
  private baseUrl = '/swREST/';
  private url = this.baseUrl + 'api/users';
  private user = new User();
  index() {
    return this.http.get<User[]>(this.url)
        .pipe(
            catchError((err: any) => {
              console.log(err);
              return throwError('KABOOM');
            })
        );
  }
  show(username) {
    return this.http.get<User>(this.url + '/' + username)
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
    console.log(id);
    const token = this.authServ.getToken();
    const headers = new HttpHeaders()
        .set('Authorization', `Basic ${token}`);
    if (!this.authServ.checkLogin()) {
      this.router.navigateByUrl('/login');
    }
    return this.http.delete(this.url + '/' + id, {headers})
        .pipe(
          catchError((err: any) => {
            console.log(err);
            return throwError('KABOOM');
          })
        );
  }
  constructor(private authServ: AuthService, private http: HttpClient, private router: Router) { }
}

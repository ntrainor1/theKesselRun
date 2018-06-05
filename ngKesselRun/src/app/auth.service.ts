import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(username, password) {
    // Make token
    const token = this.generateBasicAuthToken(username, password);
    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders()
      .set('Authorization', `Basic ${token}`);

    // create request to authenticate credentials
    return this.http
      .get('http://localhost:8080/authenticate', {headers})
      .pipe(
        tap((res) => {
          localStorage.setItem('token' , token);
          console.log(res);
          return res;
        }),
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }

  register(user) {

    // create request to register a new account
    return this.http.post('http://localhost:8080/register', user)
    .pipe(
      tap((res) => {  // create a user and then upon success, log them in
          console.log(user);
          this.login(user.username, user.password).subscribe(
            data => {
              console.log(user);
             },
            err => console.log(err)
          );
        }),
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }



  logout() {
    localStorage.removeItem('token');
  }

  checkLogin() {
    if (localStorage.getItem('token')) {
      return true;
    }
    return false;
  }

  generateBasicAuthToken(username, password) {
    return btoa(`${username}:${password}`);
  }

  getToken() {
    return localStorage.getItem('token');
  }
}

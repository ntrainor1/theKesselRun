import { AuthService } from './auth.service';
import { Category } from './models/category';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Router } from '@angular/router';
import { HttpHeaders, HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  // private url = 'http://localhost:8080/api/categories';
  private baseUrl = '/swREST/';
  private url = this.baseUrl + 'api/categories';
  private category = new Category();
  index() {
    return this.http.get<Category[]>(this.url)
        .pipe(
            catchError((err: any) => {
              console.log(err);
              return throwError('KABOOM');
            })
        );
  }
  show(id) {
    return this.http.get<Category>(this.url + '/' + id)
        .pipe(
            catchError((err: any) => {
              console.log(err);
              return throwError('KABOOM');
            })
        );
  }


  constructor(private authServ: AuthService, private http: HttpClient, private router: Router) { }

}

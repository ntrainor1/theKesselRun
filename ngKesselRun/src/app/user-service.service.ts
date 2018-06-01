import { Injectable } from '@angular/core';
import { Http}

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(
    private http: HttpClient
  ) { }

  index() {
    const token = this.auth.getToken();
    const headers = new HttpHeaders().set(
      'Authorization', 'Basic ${token}'
    );
    // http://localhost:8080/api/users/1/todos
    return this.http.get<Todo[]>(this.url, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  //   make a public create(todo) method.

  // move all of the logic of pushing the todo into the array into the service class.

  // don't forget to move the generateId method from the TodoListComponent over to the service as well.
  create(todo: Todo) {
    todo.completed = false;
    return this.http.post<Todo[]>(this.url, todo)
    .pipe(
      catchError((err: any) => {
       console.log(err);
       return throwError('KABOOM');
     })
 );
  }
  updateTodo(todo) {
    if (todo.completed) {
      todo.completeDate = this.datePipe.transform(Date.now(), 'shortDate');
    } else {
      todo.completeDate = '';
    }
    return this.http.put<Todo[]>(this.url + '/' + todo.id, todo)
    .pipe(
      catchError((err: any) => {
       console.log(err);
       return throwError('KABOOM');
     })
 );
  }

  show(id: number) {
        return this.http.get<Todo>(this.url + '/' + id).pipe(
          catchError((err: any) => {
            console.log(err);
            return throwError('KABOOM');
          })
        );
  }
  // make a public destroy(id) method. The method will iterate over the todos array
  // looking for a todo with the provided id. If the id is found, use splice to
  // remove the todo at that index.

  destroy(id: number) {
    return this.http.delete<Todo[]>(this.url + '/' + id)
    .pipe(
      catchError((err: any) => {
       console.log(err);
       return throwError('KABOOM');
     })
 );
  }
}

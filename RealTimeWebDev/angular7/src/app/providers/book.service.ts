import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../model/book';
import { Checkout } from '../model/checkout';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http : HttpClient) { }

  getAllBooks(): Observable<any> {
    return this.http.get('/library/books');
  }

  getBookById(id:string): Observable<any> {
    return this.http.get('/library/getBook?id='+id);
  }

  addBook(book:Book): Observable<any> {
    console.log(book);
    return this.http.post('/library/insert',book);
  }

  addCart(id: Checkout) : Observable<any>{
    console.log(id);
    return this.http.post('/library/addcart',id);
  }

  getCheckout(): Observable<any>{
    return this.http.get('/library/getcart');
  }
}

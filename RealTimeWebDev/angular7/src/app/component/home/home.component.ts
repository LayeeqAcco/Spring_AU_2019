import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';
import { Book } from 'src/app/model/book';
import { Checkout } from 'src/app/model/checkout';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
 
  // books : any = [];

  // constructor(private bookService : BookService) { }

  // ngOnInit() {
  //   this.bookService.getAllBooks().subscribe((response) =>{
  //     if(response && response.length > 0)
  //       this.books = response;
      
  //     console.log(response);
  //   })
  // }

  ch : Checkout;
  book : Book;
  books : Book[];
  constructor(private bookService : BookService){  }

  ngOnInit(){
    this.book = new Book();
    this.bookService.getAllBooks().subscribe((response)=>{
      console.log(response);
      if(response && response.length > 0){
        this.books = response;
      }
    });
  }

  postData(){
    //const book = new Book(this.id, this.bookName, this.author, this.price, this.desc);
    this.bookService.addBook(this.book).subscribe();
    this.books.push(this.book);
  }

  checkout(id: number){
    this.ch = new Checkout(id);
    this.bookService.addCart(this.ch).subscribe();
  }
}

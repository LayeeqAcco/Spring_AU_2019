import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  book : any;
  id : string;
  constructor(private bookService : BookService) { }

  ngOnInit() {
    // this.bookService.getBookById().subscribe((response) => {
    //   if(response)
    //     this.book = response;
    //   console.log(response);
    // })
  }

  getId(){
    this.bookService.getBookById(this.id).subscribe((response) => {
      if(response)
        this.book = response;
      console.log(response);
    })
  }
  
}
//this.bookId = this.route.sanpshot.paramMap.get('id');
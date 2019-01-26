import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {

  book : any;
  id : any;

  constructor(private act : ActivatedRoute, private bookService : BookService) { }

  ngOnInit() {
    this.id = this.act.snapshot.paramMap.get('id');
    this.bookService.getBookById(this.id).subscribe((response)=>{
      console.log(response);
      this.book = response;
    })
  }

}

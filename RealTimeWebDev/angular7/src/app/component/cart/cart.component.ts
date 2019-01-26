import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  list : any = [];
  constructor(private bookService : BookService) { }

  ngOnInit() {
    this.bookService.getCheckout().subscribe((resp)=>{
      if(resp && resp.length>0){
        this.list = resp;
        console.log(resp);
        console.log(this.list);
      }
    })
  
  }

}

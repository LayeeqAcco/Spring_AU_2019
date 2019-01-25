package com.acco.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acco.library.model.Book;
import com.acco.library.model.Checkout;
import com.acco.library.repository.BooksDAO;

@RestController
public class BooksController {
	
	@Autowired
	BooksDAO booksDAO;
	
	//@RequestMapping(value="/books")
	@RequestMapping(value="/books", produces="application/json")
	public List<Book> getAll() {
		return booksDAO.getAll();
	}
	
	@RequestMapping(value="/getBook")
	public Book getBookById(@RequestParam("id") String id) {
		return booksDAO.getBookById(id);
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertBook(@RequestBody Book newBook) {
		if(booksDAO.insertBook(newBook) == 1)
			return "SUCCESS";
		return "FAILURE";
	}
	
	@RequestMapping(value="/getcart", method=RequestMethod.GET)
	public List<Book> getCart() {
		return booksDAO.getCart();
	}
	
	@RequestMapping(value="/addcart", method=RequestMethod.POST, consumes="application/json")
	public void addCart(@RequestBody Checkout ch) {
		booksDAO.addCart(ch.getId());
	}
}

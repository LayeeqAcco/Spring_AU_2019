package com.acco.library.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.acco.library.model.Book;

@Repository
public class BooksDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Book> getAll(){
		return jdbcTemplate.query("SELECT * FROM books", (rs,i)->{
			return new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
		});
	}
	
	public Book getBookById(String id) {
		String query = "SELECT * FROM books where id='"+id+"';";
		System.out.println(query);
		List<Book> myBook = jdbcTemplate.query(query, (rs,i)->{
			return new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
		});
		return myBook.get(0);
	}

	public int insertBook(Book newBook) {
		String query = "Insert into books values ('"+ newBook.getId() + "','" 
				+ newBook.getBookName() + "','"
				+ newBook.getAuthorName() + "',"
				+ newBook.getPrice() + ",'"
				+ newBook.getDescription()+"');";
		System.out.println("query= " + query);
		return jdbcTemplate.update(query);
	}

	public List<Book> getCart() {
		String query = "Select * from books,cart where books.id=cart.bookId";
		return jdbcTemplate.query(query, (rs,i)->{
			return new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
		});
	}

	public void addCart(int id) {
		String query = "insert into cart values( ? , ?);";
		System.out.println(query+id);
		jdbcTemplate.update(query,id,id);
	}

}

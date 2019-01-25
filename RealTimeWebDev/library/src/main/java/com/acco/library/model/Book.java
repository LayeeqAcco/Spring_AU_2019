package com.acco.library.model;

public class Book {
	private String id;
	private String bookName;
	private String authorName;
	private Double price;
	private String description;
	
	public Book() {
		
	}
	
	public Book(String id, String bookName, String authorName, Double price, String description) {
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

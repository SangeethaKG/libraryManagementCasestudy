package com.librarymanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Entity
public class Books {
	
	@Id
	@NotBlank
	private String book_id;	
	
	@NotBlank
	private String author;
	
	@NotBlank
	private Integer available_copies;
	
	@NotBlank
	private String book_name;
	
	@NotBlank
	private Integer total_copies;
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getAvailable_copies() {
		return available_copies;
	}
	public void setAvailable_copies(Integer available_copies) {
		this.available_copies = available_copies;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Integer getTotal_copies() {
		return total_copies;
	}
	public void setTotal_copies(Integer total_copies) {
		this.total_copies = total_copies;
	}
	public Books(String book_id, String author, Integer available_copies, String book_name, Integer total_copies) {
		super();
		this.book_id = book_id;
		this.author = author;
		this.available_copies = available_copies;
		this.book_name = book_name;
		this.total_copies = total_copies;
	}
	public Books() {
		// TODO Auto-generated constructor stub
	}
	
}

package com.librarymanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Subscription {
	
	@Id
	@NotBlank
	private String subscriber_name;
	
	@NotBlank
	private String book_id;	
	
	
	private String date_returned;
	
	@NotBlank
	private String date_scubscribed;
	public String getSubscriber_name() {
		return subscriber_name;
	}
	public void setSubscriber_name(String subscriber_name) {
		this.subscriber_name = subscriber_name;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getDate_returned() {
		return date_returned;
	}
	public void setDate_returned(String date_returned) {
		this.date_returned = date_returned;
	}
	public String getDate_scubscribed() {
		return date_scubscribed;
	}
	public void setDate_scubscribed(String date_scubscribed) {
		this.date_scubscribed = date_scubscribed;
	}
	public Subscription(String subscriber_name, String book_id, String date_returned, String date_scubscribed) {
		super();
		this.subscriber_name = subscriber_name;
		this.book_id = book_id;
		this.date_returned = date_returned;
		this.date_scubscribed = date_scubscribed;
	}
	public Subscription() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	

}

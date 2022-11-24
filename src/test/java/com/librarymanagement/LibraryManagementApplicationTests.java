package com.librarymanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions;
import java.util.List;

import org.junit.jupiter.api.Order;

import com.librarymanagement.model.Books;
import com.librarymanagement.model.Subscription;
import com.librarymanagement.repository.BooksRepository;
import com.librarymanagement.repository.SubscriptionRepository;

@SpringBootTest
class LibraryManagementApplicationTests {

	@Autowired
	private BooksRepository booksrepository;

	@Autowired
	private SubscriptionRepository subscriptionrepository;

	@Test
	@Order(1)
	public void getAllBooks() {
		List<Books> bookList = booksrepository.findAll();
		Assertions.assertThat(bookList.size() > 0);

	}

	@Test
	@Order(2)
	public void getAllSubscriptions() {
		List<Subscription> subList = subscriptionrepository.findAll();
		Assertions.assertThat(subList.size() > 0);

	}

	@Test
	@Order(3)
	public void addSubscription() {
		Subscription subs = new Subscription("Nidharsana", "B1212", "", "2022-11-26");
		subscriptionrepository.save(subs);
		Assertions.assertThat(subs.getBook_id().equalsIgnoreCase("B1212"));

	}

	@Test
	@Order(4)
	public void getAllSubscription() {
		Subscription subs = subscriptionrepository.findById("Nidharsana").get();
		Assertions.assertThat(subs.getBook_id()).isEqualTo("B1212");

	}

	@Test
	void contextLoads() {
	}

}

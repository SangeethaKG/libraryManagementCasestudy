package com.librarymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.librarymanagement.model.Books;
import com.librarymanagement.model.PublicApiData;
import com.librarymanagement.model.Subscription;
import com.librarymanagement.repository.BooksRepository;
import com.librarymanagement.repository.SubscriptionRepository;


@Service
public class LibraryMgmtService {

	@Autowired
	BooksRepository booksrepository;

	@Autowired
	SubscriptionRepository subscriptionrepository;
	
	private final RestTemplate restTemplate;

    public LibraryMgmtService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
    public PublicApiData getEntriesFromThirdParty() {
    	String url = "https://api.coinbase.com/v2/currencies";
    	return this.restTemplate.getForObject(url, PublicApiData.class);
    	
    }

	public List<Books> getAllBooks() {
		return booksrepository.findAll();

	}

	public List<Subscription> getAllSubscriptions(){	
		return subscriptionrepository.findAll();		

	}

	public Subscription getAllSubscription(String subscriptionName){	
		return subscriptionrepository.findById(subscriptionName).get();	

	}
	
	@Transactional
	public boolean addSubscription(Subscription sub) {
		if(booksrepository.findById(sub.getBook_id()).filter(s -> s.getAvailable_copies() > 0).isPresent()) {
			subscriptionrepository.save(sub);
			return true;
		} 
		return false;
				
	}


}

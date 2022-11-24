package com.librarymanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.librarymanagement.model.Books;
import com.librarymanagement.model.PublicApiData;
import com.librarymanagement.model.Subscription;
import com.librarymanagement.service.LibraryMgmtService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/library")
public class LibraryMgmtController {

	@Autowired
	LibraryMgmtService libraryMgmtService;


	@GetMapping("/books")
	@ResponseStatus( HttpStatus.OK)
	public List<Books> getBooks(){
		return libraryMgmtService.getAllBooks();

	}

	@GetMapping("/subscriptions")
	@ResponseStatus( HttpStatus.OK)
	public List<Subscription> getSubscriptions(@RequestParam(required = false) String subscriberName) {
		if(null == subscriberName) {
			return libraryMgmtService.getAllSubscriptions();
		} else {			
			List<Subscription> list = new ArrayList<>();
			list.add(libraryMgmtService.getAllSubscription(subscriberName));
			return list;
		}
	}

	@PostMapping("/subscriptions")
	public ResponseEntity<?> addSubscriptions(@RequestBody Subscription sub){
		if(libraryMgmtService.addSubscription(sub))
			return ResponseEntity.status(HttpStatus.CREATED).body("Subscription created !!");
		else
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Book copies not available !!");

	}
	
	@GetMapping("/thirdPartyApiEntries")
	public PublicApiData getEntriesFromThirdParty() {
		return libraryMgmtService.getEntriesFromThirdParty();
	}

}

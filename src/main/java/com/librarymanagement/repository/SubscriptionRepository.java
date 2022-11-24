package com.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.librarymanagement.model.Subscription;


@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, String>{

}

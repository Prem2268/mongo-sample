package com.sample.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sample.mongo.collections.ClientAccountDetails;

@Repository
public interface UserAccountsRepository extends MongoRepository<ClientAccountDetails, String> {
	
	public ClientAccountDetails findByClientId(String clientId);
	

}

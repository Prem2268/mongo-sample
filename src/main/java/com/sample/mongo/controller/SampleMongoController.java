package com.sample.mongo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.mongo.collections.ClientAccountDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/sample-mongo")
@RestController
public class SampleMongoController {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@GetMapping("/getaccount")
	public ClientAccountDetails getAccountDetails() {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("ClientId").is("1000010"));
		
		mongoTemplate.findOne(query, ClientAccountDetails.class);
		ClientAccountDetails clientAccountDetails = mongoTemplate.findOne(query, ClientAccountDetails.class);
		log.info("GetAccount Response: {}", clientAccountDetails);
		return clientAccountDetails;
	}
	
	@PostMapping(value = "/saveaccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientAccountDetails saveDetails(@RequestBody ClientAccountDetails clientAccountDetails) {
		
		log.info("Save  Details Request : {}", clientAccountDetails);
		ClientAccountDetails accountDetails = mongoTemplate.save(clientAccountDetails);
		log.info("Save  Details Response : {}", accountDetails);
		
		return accountDetails;
	}
}

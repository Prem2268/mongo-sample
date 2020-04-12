package com.sample.mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfiguration {
	
	@Value("${spring.data.mongodb.uri}")
	private String mongoDBUri;
	
	@Value("${spring.data.mongodb.database}")
	private String mongoDBName;
	
	@Bean
    public SimpleMongoClientDbFactory mongoDbFactory() {
        return new SimpleMongoClientDbFactory(MongoClients.create(mongoDBUri), mongoDBName);
    }

	@Bean
	public MongoTemplate mongoTemplate() {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		return mongoTemplate;

    }
}

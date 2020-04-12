package com.sample.mongo.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "UserAccounts")
public class ClientAccountDetails {
	
	@Id
	private String Id;
	private String clientId;
	private String accountNo;

}

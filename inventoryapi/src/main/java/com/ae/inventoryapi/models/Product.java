package com.ae.inventoryapi.models;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Scope(scopeName = "request", proxyMode =ScopedProxyMode.TARGET_CLASS)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product {
    @Id
	private long productId;
	private String name;
	private long cost;
	private String dop;
	
}

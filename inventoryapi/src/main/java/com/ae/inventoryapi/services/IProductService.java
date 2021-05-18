package com.ae.inventoryapi.services;

import com.ae.inventoryapi.models.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {
	
	void add(Product product);
	Flux<Product> getAllProducts();
	Mono<Product> getProductById(long id); //zero or one
	Flux<Product> getProductByName(String name);
	Mono<Product> updateProduct(Product product);
	Mono<Void> deleteProduct(long id);
	

}

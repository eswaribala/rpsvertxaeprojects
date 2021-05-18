package com.ae.inventoryapi.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ae.inventoryapi.models.Product;

import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Product,Long>{
	@Query("{ 'name': ?0 }")
    Flux<Product> findByName(final String name);
}

package com.ae.inventoryapi.services;

import org.springframework.stereotype.Service;

import com.ae.inventoryapi.models.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements IProductService{

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flux<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Product> getProductById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Product> getProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Product> updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProduct(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}

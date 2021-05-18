package com.ae.inventoryapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ae.inventoryapi.models.Product;
import com.ae.inventoryapi.repositories.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements IProductService{
    @Autowired
	private ProductRepository productRepository;
	@Override
	public Mono<Product> add(Product product) {
		// TODO Auto-generated method stub
		return this.productRepository.insert(product);
	}

	@Override
	public Flux<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();
	}

	@Override
	//zero or one
	public Mono<Product> getProductById(long id) {
		// TODO Auto-generated method stub
		return this.productRepository.findById(id);
	}

	@Override
	public Flux<Product> getProductByName(String name) {
		// TODO Auto-generated method stub
		return this.productRepository.findByName(name);
	}

	@Override
	public Mono<Product> updateProduct(Product product) {
		// TODO Auto-generated method stub
		return this.productRepository.save(product);
	}

	@Override
	public Mono<Void> deleteProduct(long id) {
		// TODO Auto-generated method stub
	    return this.productRepository.deleteById(id);
	}

}

package com.ae.inventoryapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ae.inventoryapi.models.Product;
import com.ae.inventoryapi.services.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")

	public Mono<Product> addProduct(@RequestBody Product product) {
		return this.productService.add(product);
	}
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") long id){
		Mono<Product> product=this.productService.getProductById(id);
		HttpStatus status = product != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		if(product!=null)
			return ResponseEntity.status(status).body(product);
		else
			return ResponseEntity.status(status).body("Product Not Found");			
	}
	
	@GetMapping("/products")
	public Flux<Product> getProducts(){
		return this.productService.getAllProducts();		
	}
}

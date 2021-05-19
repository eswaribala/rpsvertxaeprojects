package com.ae.inventoryapi;
/*
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.ae.inventoryapi.controllers.ProductController;
import com.ae.inventoryapi.models.Product;
import com.ae.inventoryapi.repositories.ProductRepository;
import com.ae.inventoryapi.services.ProductService;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ProductController.class)
@Import(ProductService.class)
public class ProductControllerTest 
{
    @MockBean
    ProductRepository repository;
 
    @Autowired
    private WebTestClient webClient;
 
    @Test
    void testCreateProduct() {
       Product product=new Product();
        Mockito.when(repository.save(product)).thenReturn(Mono.just(product));
 
        webClient.post()
            .uri("/create")
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromObject(product))
            .exchange()
            .expectStatus().isCreated();
 
        Mockito.verify(repository, times(1)).save(product);
    }
     
 
}

*/
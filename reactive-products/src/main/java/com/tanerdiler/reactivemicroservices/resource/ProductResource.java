package com.tanerdiler.reactivemicroservices.resource;

import com.tanerdiler.reactivemicroservices.model.Product;
import com.tanerdiler.reactivemicroservices.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductResource
{
	@Autowired
	private ProductRepository repository;

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Product>> get(@PathVariable("id") String id)
	{
		return repository
				.findById(id).map(a->ResponseEntity.ok(a))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping
	public Flux<Product> getAll()
	{
		return repository.findAll();
	}
}

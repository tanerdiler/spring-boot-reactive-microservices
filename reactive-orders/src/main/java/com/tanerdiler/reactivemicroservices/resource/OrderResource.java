package com.tanerdiler.reactivemicroservices.resource;

import com.tanerdiler.reactivemicroservices.model.Order;
import com.tanerdiler.reactivemicroservices.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderResource
{
	@Autowired
	private OrderRepository repository;

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Order>> get(@PathVariable("id") String id)
	{
		return repository
				.findById(id).map(a->ResponseEntity.ok(a))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping
	public Flux<Order> getAll()
	{
		return repository.findAll();
	}
}

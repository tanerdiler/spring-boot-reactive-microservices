package com.tanerdiler.reactivemicroservices.resource;

import com.tanerdiler.reactivemicroservices.model.Account;
import com.tanerdiler.reactivemicroservices.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountResource
{
	@Autowired
	private AccountRepository repository;

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Account>> get(@PathVariable("id") String id)
	{
		return repository
				.findById(id).map(a->ResponseEntity.ok(a))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping
	public Flux<Account> getAll()
	{
		return repository.findAll();
	}
}

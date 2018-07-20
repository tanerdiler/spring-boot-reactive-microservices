package com.tanerdiler.reactivemicroservices.repository;

import com.tanerdiler.reactivemicroservices.model.Account;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AccountServiceClient
{
	private WebClient webClient;

	public AccountServiceClient(WebClient.Builder webClientBuilder)
	{
		this.webClient = webClientBuilder.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE)
				.baseUrl("http://reactive-accounts/api/v1/accounts").build();
	}

	public Mono<Account> findById(String accountId){
		return webClient.get().uri("/{id}", accountId).retrieve().bodyToMono(Account.class);
	}

	public Flux<Account> findAll()
	{
		return webClient.get().retrieve().bodyToFlux(Account.class);
	}

}

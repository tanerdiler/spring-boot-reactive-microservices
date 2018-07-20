package com.tanerdiler.reactivemicroservices.repository;

import com.tanerdiler.reactivemicroservices.model.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class OrderServiceClient
{
	private final WebClient webClient;

	public OrderServiceClient(WebClient.Builder webClientBuilder)
	{
		this.webClient = webClientBuilder.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE)
				.baseUrl("http://reactive-orders/api/v1/orders").build();
	}

	public Mono<Order> findById(String orderId){
		return webClient.get().uri("/{id}", orderId).retrieve().bodyToMono(Order.class);
	}

	public Flux<Order> findAll()
	{
		return webClient.get().retrieve().bodyToFlux(Order.class);
	}

}

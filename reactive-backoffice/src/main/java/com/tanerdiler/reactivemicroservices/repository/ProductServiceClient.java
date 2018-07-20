package com.tanerdiler.reactivemicroservices.repository;

import com.tanerdiler.reactivemicroservices.model.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ProductServiceClient
{
	private final WebClient webClient;

	public ProductServiceClient(WebClient.Builder builder)
	{
		this.webClient = builder.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE)
				.baseUrl("http://reactive-products/api/v1/orders").build();
	}
	public Mono<Product> findById(String orderId){
		return webClient.get().uri("/{id}", orderId).retrieve().bodyToMono(Product.class);
	}

	public Flux<Product> findAll(){
		return webClient.get().retrieve().bodyToFlux(Product.class);
	}
}

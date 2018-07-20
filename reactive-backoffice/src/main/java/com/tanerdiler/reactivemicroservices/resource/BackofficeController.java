package com.tanerdiler.reactivemicroservices.resource;

import com.tanerdiler.reactivemicroservices.dto.OrderDTO;
import com.tanerdiler.reactivemicroservices.model.Account;
import com.tanerdiler.reactivemicroservices.model.Order;
import com.tanerdiler.reactivemicroservices.model.Product;
import com.tanerdiler.reactivemicroservices.repository.AccountServiceClient;
import com.tanerdiler.reactivemicroservices.repository.OrderServiceClient;
import com.tanerdiler.reactivemicroservices.repository.ProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/backoffice")
public class BackofficeController
{
	@Autowired
	private ProductServiceClient productService;
	@Autowired
	private OrderServiceClient orderService;
	@Autowired
	private AccountServiceClient accountService;

	@GetMapping("/orders")
	public Flux<OrderDTO> getOrders()
	{
		Flux<Order> orders = orderService.findAll();
		Map<String, Account> accounts = new HashMap<>();
		Map<String, Product> products = new HashMap<>();

		orders
				.filter(o->!accounts.containsKey(o.getAccountId()))
				.flatMap(o->accountService.findById(o.getAccountId()))
				.subscribe(a->accounts.put(a.getId(), a));

		orders
				.filter(o->!products.containsKey(o.getProductId()))
				.flatMap(o->productService.findById(o.getProductId()))
				.subscribe(p->products.put(p.getId(), p));

		return orders
				.map(o->new OrderDTO(
						o.getId(),
						o.getCount(),
						o.getPrice(),
						o.getDiscountedPrice(),
						accounts.get(o.getAccountId()).getFullname(),
						products.get(o.getProductId()).getName()
				));
	}
}

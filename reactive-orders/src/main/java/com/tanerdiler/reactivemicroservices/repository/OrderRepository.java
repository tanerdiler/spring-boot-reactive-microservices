package com.tanerdiler.reactivemicroservices.repository;

import com.tanerdiler.reactivemicroservices.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRepository extends ReactiveMongoRepository<Order, String>
{
}

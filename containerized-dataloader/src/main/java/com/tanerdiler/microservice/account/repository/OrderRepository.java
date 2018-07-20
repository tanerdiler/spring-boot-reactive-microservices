package com.tanerdiler.microservice.account.repository;

import com.tanerdiler.microservice.account.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>
{
}
